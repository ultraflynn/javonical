package com.mattbiggin.javonical.multithreading.blockqueue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public final class Start {
  @Test
  public void runDemo() {
    // A message is produced every 5ms and 100 are produced. Total time taken on
    // producing messages is thus 500ms. There are 10 consumers and they take at
    // least 20ms to process each message. Thus a minimum of 2000ms to process all
    // messages.
    // On my JVM this results in all consumers getting to process messages.
    final int consumerCount = 10;
    final long consumerDelay = 20;
    final long producerDelay = 5;
    final int messageCount = 100;
    final long shutdownTimeout = 10000;

    final ScheduledExecutorService executor = Executors.newScheduledThreadPool(consumerCount);
    final CountDownLatch ready = new CountDownLatch(consumerCount);
    final BlockingQueue<Message> queue = new BlockingQueue<Message>();

    try {
      startConsumers(consumerCount, executor, queue, ready, consumerDelay);
      startProducer(queue, messageCount, producerDelay, consumerCount);
    } catch (final InterruptedException e) {
      e.printStackTrace();
    } finally {
      try {
        executor.shutdown();
        executor.awaitTermination(shutdownTimeout, TimeUnit.MILLISECONDS);
      } catch (final InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void startConsumers(final int consumerCount, final ScheduledExecutorService executor,
      final BlockingQueue<Message> queue, final CountDownLatch ready,
      final long delay) throws InterruptedException {
    for (int i = 0; i < consumerCount; i++) {
      executor.submit(new Consumer(queue, ready, delay));
    }
    ready.await();
  }

  private void startProducer(final BlockingQueue<Message> queue, final int messageCount,
      final long delay, final int consumerCount) throws InterruptedException {
    new Producer(queue, messageCount, consumerCount, delay).start();
  }
}
