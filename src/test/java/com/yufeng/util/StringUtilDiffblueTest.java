package com.yufeng.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StringUtilDiffblueTest {
  /**
   * Test {@link StringUtil#isEmpty(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#isEmpty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtil.isEmpty(String)"})
  public void testIsEmpty_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtil.isEmpty(""));
  }

  /**
   * Test {@link StringUtil#isEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#isEmpty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtil.isEmpty(String)"})
  public void testIsEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtil.isEmpty(null));
  }

  /**
   * Test {@link StringUtil#isEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#isEmpty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtil.isEmpty(String)"})
  public void testIsEmpty_whenStr_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtil.isEmpty("Str"));
  }

  /**
   * Test {@link StringUtil#isNotEmpty(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#isNotEmpty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtil.isNotEmpty(String)"})
  public void testIsNotEmpty_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtil.isNotEmpty(""));
  }

  /**
   * Test {@link StringUtil#isNotEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#isNotEmpty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtil.isNotEmpty(String)"})
  public void testIsNotEmpty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtil.isNotEmpty(null));
  }

  /**
   * Test {@link StringUtil#isNotEmpty(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#isNotEmpty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringUtil.isNotEmpty(String)"})
  public void testIsNotEmpty_whenStr_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtil.isNotEmpty("Str"));
  }

  /**
   * Test {@link StringUtil#formatCode(String)}.
   *
   * <ul>
   *   <li>When {@code 0100}.
   *   <li>Then return {@code 0101}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#formatCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.formatCode(String)"})
  public void testFormatCode_when0100_thenReturn0101() {
    // Arrange, Act and Assert
    assertEquals("0101", StringUtil.formatCode("0100"));
  }

  /**
   * Test {@link StringUtil#formatCode(String)}.
   *
   * <ul>
   *   <li>When {@code Code}.
   *   <li>Then return {@code 0100}.
   * </ul>
   *
   * <p>Method under test: {@link StringUtil#formatCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringUtil.formatCode(String)"})
  public void testFormatCode_whenCode_thenReturn0100() {
    // Arrange, Act and Assert
    assertEquals("0100", StringUtil.formatCode("Code"));
  }
}
