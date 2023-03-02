package com.mattbiggin.javonical.multithreading.blockqueue;

public final class Producer {
  private final BlockingQueue<Message> queue;
  private final int messageCount;
  private final int consumerCount;
  private final long delay;

  public Producer(final BlockingQueue<Message> queue,
      final int messageCount,
      final int consumerCount,
      final long delay) {
    this.queue = queue;
    this.messageCount = messageCount;
    this.consumerCount = consumerCount;
    this.delay = delay;
  }

  public void start() throws InterruptedException {
    for (int i = 0; i < messageCount; i++) {
      queue.push(Message.valueOf("message-" + i));
      Thread.sleep(delay);
    }

    for (int i = 0; i < consumerCount; i++) {
      queue.push(Message.POISON);
    }
  }
}