package com.yufeng.util;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MathUtilDiffblueTest {
  /**
   * Test {@link MathUtil#format2Bit(float)}.
   *
   * <p>Method under test: {@link MathUtil#format2Bit(float)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"float MathUtil.format2Bit(float)"})
  public void testFormat2Bit() {
    // Arrange, Act and Assert
    assertEquals(10.0f, MathUtil.format2Bit(10.0f), 0.0f);
  }
}
