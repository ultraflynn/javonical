package com.ultraflynn.javonical.multithreading.blockqueue;

import java.util.concurrent.CountDownLatch;

public final class Consumer implements Runnable
{
  private final BlockingQueue<Message> queue;
  private final CountDownLatch ready;
  private final long delay;
  private volatile boolean keepRunning = true;

  public Consumer(BlockingQueue<Message> queue, CountDownLatch ready, long delay)
  {
    this.queue = queue;
    this.ready = ready;
    this.delay = delay;
  }

  public void run()
  {
    ready.countDown();

    try {
      while (keepRunning) {
        Message message = queue.pop();
        if (message == Message.POISON) {
          keepRunning = false;
        } else {
          System.out.println("[" + Thread.currentThread().getName() + "] " + message);
          Thread.sleep(delay);
        }
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}