package com.yufeng.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MathUtilDiffblueTest {
  /**
   * Test {@link MathUtil#format2Bit(float)}.
   * <p>
   * Method under test: {@link MathUtil#format2Bit(float)}
   */
  @Test
  public void testFormat2Bit() {
    // Arrange, Act and Assert
    assertEquals(10.0f, MathUtil.format2Bit(10.0f), 0.0f);
  }
}
