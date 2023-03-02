package com.mattbiggin.javonical.algorithms.factorial;

public final class Factorial
{
  public static int factorial(int f)
  {
    return ((f == 0) ? 1 : f * factorial(f - 1));
  }
}