package com.yufeng.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StringUtilDiffblueTest {
  /**
   * Method under test: {@link StringUtil#isEmpty(String)}
   */
  @Test
  public void testIsEmpty() {
    // Arrange, Act and Assert
    assertFalse(StringUtil.isEmpty("Str"));
    assertTrue(StringUtil.isEmpty(null));
    assertTrue(StringUtil.isEmpty(""));
  }

  /**
   * Method under test: {@link StringUtil#isNotEmpty(String)}
   */
  @Test
  public void testIsNotEmpty() {
    // Arrange, Act and Assert
    assertTrue(StringUtil.isNotEmpty("Str"));
    assertFalse(StringUtil.isNotEmpty(null));
    assertFalse(StringUtil.isNotEmpty(""));
  }

  /**
   * Method under test: {@link StringUtil#formatCode(String)}
   */
  @Test
  public void testFormatCode() {
    // Arrange, Act and Assert
    assertEquals("0100", StringUtil.formatCode("Code"));
    assertEquals("0101", StringUtil.formatCode("0100"));
  }
}
