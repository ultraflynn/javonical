package com.mattbiggin.javonical.multithreading.blockqueue;

import java.util.LinkedList;
import java.util.Queue;

public final class BlockingQueue<T> {
  private final Queue<T> queue = new LinkedList<T>();

  public synchronized T pop() {
    // It's possible for this thread to spuriously wake up so we guard against this
    // using a "while". Had an "if" been used next time round the poll() would have
    // returned no element and this method is intended to return a valid element or
    // block. The "while" will keep testing and releasing the monitor until the
    // queue has an element in it to return.
    while (queue.size() == 0) {
      try {
        wait();
      } catch (final InterruptedException e) {
        return null;
      }
    }
    return queue.poll();
  }

  public synchronized void push(final T element) {
    queue.add(element);
    notifyAll();
  }
}
