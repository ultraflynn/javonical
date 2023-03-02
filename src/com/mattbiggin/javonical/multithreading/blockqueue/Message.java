package com.mattbiggin.javonical.multithreading.blockqueue;

public final class Message
{
  public static final Message POISON = poison();

  public final String payload;

  private Message(final String payload)
  {
    this.payload = payload;
  }

  public static Message valueOf(final String payload)
  {
    return new Message(payload);
  }

  public static Message poison()
  {
    return new Message(null);
  }

  @Override
  public String toString()
  {
    return "Message{" +
        "payload='" + payload + '\'' +
        '}';
  }
}