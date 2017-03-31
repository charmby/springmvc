package com.gsafety;

import org.testng.annotations.Test;

public class UnknownResourceExceptionTest {

  @Test
  public void UnknownResourceException() {
    throw new RuntimeException("Test not implemented");
  }
}
