package com.ultraflynn.javonical.multithreading.blockqueue;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class Start
{
  @Test
  public void runDemo()
  {
    // A message is produced every 5ms and 100 are produced. Total time taken on
    // producing messages is thus 500ms. There are 10 consumers and they take at
    // least 20ms to process each message. Thus a minimum of 2000ms to process all
    // messages.
    // On my JVM this results in all consumers getting to process messages.
    int consumerCount = 10;
    long consumerDelay = 20;
    long producerDelay = 5;
    int messageCount = 100;
    long shutdownTimeout = 10000;

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(consumerCount);
    CountDownLatch ready = new CountDownLatch(consumerCount);
    BlockingQueue<Message> queue = new BlockingQueue<Message>();

    try {
      startConsumers(consumerCount, executor, queue, ready, consumerDelay);
      startProducer(queue, messageCount, producerDelay, consumerCount);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      try {
        executor.shutdown();
        executor.awaitTermination(shutdownTimeout, TimeUnit.MILLISECONDS);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void startConsumers(int consumerCount, ScheduledExecutorService executor,
                              BlockingQueue<Message> queue, CountDownLatch ready,
                              long delay) throws InterruptedException
  {
    for (int i = 0; i < consumerCount; i++) {
      executor.submit(new Consumer(queue, ready, delay));
    }
    ready.await();
  }

  private void startProducer(BlockingQueue<Message> queue, int messageCount,
                             long delay, int consumerCount) throws InterruptedException
  {
    new Producer(queue, messageCount, consumerCount, delay).start();
  }
}
