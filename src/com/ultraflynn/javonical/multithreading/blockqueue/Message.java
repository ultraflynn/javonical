package com.ultraflynn.javonical.multithreading.blockqueue;

public final class Message
{
  public static final Message POISON = poison();

  public final String payload;

  private Message(String payload)
  {
    this.payload = payload;
  }

  public static Message valueOf(String payload)
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