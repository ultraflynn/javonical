package com.ultraflynn.javonical.algorithms.factorial;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public final class Demonstration
{
  @Test
  public void factorialZero()
  {
    int result = Factorial.factorial(0);
    assertEquals(1, result);
  }

  @Ignore("What should the result of a negative factorial be")
  @Test
  public void factorialNegative()
  {
    int result = Factorial.factorial(-5);
    assertEquals(0, result);
  }

  @Test
  public void factorialOne()
  {
    int result = Factorial.factorial(1);
    assertEquals(1, result);
  }

  @Test
  public void factorialTwo()
  {
    int result = Factorial.factorial(2);
    assertEquals(2, result);
  }

  @Test
  public void factorialThree()
  {
    int result = Factorial.factorial(3);
    assertEquals(6, result);
  }

  @Test
  public void factorialFour()
  {
    int result = Factorial.factorial(4);
    assertEquals(24, result);
  }

  @Test
  public void factorialFive()
  {
    int result = Factorial.factorial(5);
    assertEquals(120, result);
  }

  @Test
  public void factorialSix()
  {
    int result = Factorial.factorial(6);
    assertEquals(720, result);
  }
}