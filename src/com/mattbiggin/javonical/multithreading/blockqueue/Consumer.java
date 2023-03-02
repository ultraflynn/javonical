package com.mattbiggin.javonical.multithreading.blockqueue;

import java.util.concurrent.CountDownLatch;

public final class Consumer implements Runnable {
  private final BlockingQueue<Message> queue;
  private final CountDownLatch ready;
  private final long delay;
  private volatile boolean keepRunning = true;

  public Consumer(final BlockingQueue<Message> queue, final CountDownLatch ready, final long delay) {
    this.queue = queue;
    this.ready = ready;
    this.delay = delay;
  }

  public void run() {
    ready.countDown();

    try {
      while (keepRunning) {
        final Message message = queue.pop();
        if (message == Message.POISON) {
          keepRunning = false;
        } else {
          System.out.println("[" + Thread.currentThread().getName() + "] " + message);
          Thread.sleep(delay);
        }
      }
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
  }
}