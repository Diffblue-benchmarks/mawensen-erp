package com.yufeng.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class DateUtilDiffblueTest {
  /**
   * Test {@link DateUtil#formatDate(Date, String)}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateUtil#formatDate(Date, String)}
   */
  @Test
  public void testFormatDate_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("",
        DateUtil.formatDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), ""));
  }

  /**
   * Test {@link DateUtil#formatDate(Date, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateUtil#formatDate(Date, String)}
   */
  @Test
  public void testFormatDate_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", DateUtil.formatDate(null, ""));
  }

  /**
   * Test {@link DateUtil#formatString(String, String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@link SimpleDateFormat#SimpleDateFormat(String)} with
   * {@code yyyy-MM-dd} format is {@code 1970-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateUtil#formatString(String, String)}
   */
  @Test
  public void testFormatString_when42_thenReturnSimpleDateFormatWithYyyyMmDdFormatIs19700101() throws Exception {
    // Arrange and Act
    Date actualFormatStringResult = DateUtil.formatString("42", "42");

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualFormatStringResult));
  }

  /**
   * Test {@link DateUtil#formatString(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateUtil#formatString(String, String)}
   */
  @Test
  public void testFormatString_whenEmptyString_thenReturnNull() throws Exception {
    // Arrange, Act and Assert
    assertNull(DateUtil.formatString("", "Format"));
  }

  /**
   * Test {@link DateUtil#formatString(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DateUtil#formatString(String, String)}
   */
  @Test
  public void testFormatString_whenNull_thenReturnNull() throws Exception {
    // Arrange, Act and Assert
    assertNull(DateUtil.formatString(null, "Format"));
  }
}
