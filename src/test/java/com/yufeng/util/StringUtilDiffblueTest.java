package com.yufeng.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StringUtilDiffblueTest {
  /**
   * Test {@link StringUtil#isEmpty(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#isEmpty(String)}
   */
  @Test
  public void testIsEmpty_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtil.isEmpty(""));
  }

  /**
   * Test {@link StringUtil#isEmpty(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#isEmpty(String)}
   */
  @Test
  public void testIsEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtil.isEmpty(null));
  }

  /**
   * Test {@link StringUtil#isEmpty(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#isEmpty(String)}
   */
  @Test
  public void testIsEmpty_whenStr_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtil.isEmpty("Str"));
  }

  /**
   * Test {@link StringUtil#isNotEmpty(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#isNotEmpty(String)}
   */
  @Test
  public void testIsNotEmpty_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtil.isNotEmpty(""));
  }

  /**
   * Test {@link StringUtil#isNotEmpty(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#isNotEmpty(String)}
   */
  @Test
  public void testIsNotEmpty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtil.isNotEmpty(null));
  }

  /**
   * Test {@link StringUtil#isNotEmpty(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#isNotEmpty(String)}
   */
  @Test
  public void testIsNotEmpty_whenStr_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtil.isNotEmpty("Str"));
  }

  /**
   * Test {@link StringUtil#formatCode(String)}.
   * <ul>
   *   <li>When {@code 0100}.</li>
   *   <li>Then return {@code 0101}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#formatCode(String)}
   */
  @Test
  public void testFormatCode_when0100_thenReturn0101() {
    // Arrange, Act and Assert
    assertEquals("0101", StringUtil.formatCode("0100"));
  }

  /**
   * Test {@link StringUtil#formatCode(String)}.
   * <ul>
   *   <li>When {@code Code}.</li>
   *   <li>Then return {@code 0100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtil#formatCode(String)}
   */
  @Test
  public void testFormatCode_whenCode_thenReturn0100() {
    // Arrange, Act and Assert
    assertEquals("0100", StringUtil.formatCode("Code"));
  }
}
