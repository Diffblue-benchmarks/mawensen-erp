package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class OverflowListDiffblueTest {
  /**
   * Test {@link OverflowList#getbOverflowDate()}.
   * <p>
   * Method under test: {@link OverflowList#getbOverflowDate()}
   */
  @Test
  public void testGetbOverflowDate() {
    // Arrange, Act and Assert
    assertNull((new OverflowList()).getbOverflowDate());
  }

  /**
   * Test {@link OverflowList#geteOverflowDate()}.
   * <p>
   * Method under test: {@link OverflowList#geteOverflowDate()}
   */
  @Test
  public void testGeteOverflowDate() {
    // Arrange, Act and Assert
    assertNull((new OverflowList()).geteOverflowDate());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OverflowList}
   *   <li>{@link OverflowList#setId(Integer)}
   *   <li>{@link OverflowList#setOverflowDate(Date)}
   *   <li>{@link OverflowList#setOverflowNumber(String)}
   *   <li>{@link OverflowList#setRemarks(String)}
   *   <li>{@link OverflowList#setUser(User)}
   *   <li>{@link OverflowList#setbOverflowDate(Date)}
   *   <li>{@link OverflowList#seteOverflowDate(Date)}
   *   <li>{@link OverflowList#toString()}
   *   <li>{@link OverflowList#getId()}
   *   <li>{@link OverflowList#getOverflowDate()}
   *   <li>{@link OverflowList#getOverflowNumber()}
   *   <li>{@link OverflowList#getRemarks()}
   *   <li>{@link OverflowList#getUser()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OverflowList actualOverflowList = new OverflowList();
    actualOverflowList.setId(1);
    Date overflowDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualOverflowList.setOverflowDate(overflowDate);
    actualOverflowList.setOverflowNumber("42");
    actualOverflowList.setRemarks("Remarks");
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    actualOverflowList.setUser(user);
    actualOverflowList
        .setbOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualOverflowList
        .seteOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualOverflowList.toString();
    Integer actualId = actualOverflowList.getId();
    Date actualOverflowDate = actualOverflowList.getOverflowDate();
    String actualOverflowNumber = actualOverflowList.getOverflowNumber();
    String actualRemarks = actualOverflowList.getRemarks();
    User actualUser = actualOverflowList.getUser();

    // Assert that nothing has changed
    assertEquals("42", actualOverflowNumber);
    assertEquals("Remarks", actualRemarks);
    assertEquals(1, actualId.intValue());
    assertSame(user, actualUser);
    assertSame(overflowDate, actualOverflowDate);
  }
}
