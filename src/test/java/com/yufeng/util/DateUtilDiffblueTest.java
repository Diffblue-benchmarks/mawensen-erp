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
   * Method under test: {@link DateUtil#formatDate(Date, String)}
   */
  @Test
  public void testFormatDate() {
    // Arrange, Act and Assert
    assertEquals("",
        DateUtil.formatDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()), ""));
    assertEquals("", DateUtil.formatDate(null, ""));
  }

  /**
   * Method under test: {@link DateUtil#formatString(String, String)}
   */
  @Test
  public void testFormatString() throws Exception {
    // Arrange, Act and Assert
    assertNull(DateUtil.formatString(null, "Format"));
    assertNull(DateUtil.formatString("", "Format"));
  }

  /**
   * Method under test: {@link DateUtil#formatString(String, String)}
   */
  @Test
  public void testFormatString2() throws Exception {
    // Arrange and Act
    Date actualFormatStringResult = DateUtil.formatString("42", "42");

    // Assert
    assertEquals("1970-01-01", (new SimpleDateFormat("yyyy-MM-dd")).format(actualFormatStringResult));
  }
}
