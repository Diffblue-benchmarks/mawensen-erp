package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class DamageListDiffblueTest {
  /**
   * Test {@link DamageList#getbDamageDate()}.
   * <p>
   * Method under test: {@link DamageList#getbDamageDate()}
   */
  @Test
  public void testGetbDamageDate() {
    // Arrange, Act and Assert
    assertNull((new DamageList()).getbDamageDate());
  }

  /**
   * Test {@link DamageList#geteDamageDate()}.
   * <p>
   * Method under test: {@link DamageList#geteDamageDate()}
   */
  @Test
  public void testGeteDamageDate() {
    // Arrange, Act and Assert
    assertNull((new DamageList()).geteDamageDate());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DamageList}
   *   <li>{@link DamageList#setDamageDate(Date)}
   *   <li>{@link DamageList#setDamageNumber(String)}
   *   <li>{@link DamageList#setId(Integer)}
   *   <li>{@link DamageList#setRemarks(String)}
   *   <li>{@link DamageList#setUser(User)}
   *   <li>{@link DamageList#setbDamageDate(Date)}
   *   <li>{@link DamageList#seteDamageDate(Date)}
   *   <li>{@link DamageList#toString()}
   *   <li>{@link DamageList#getDamageDate()}
   *   <li>{@link DamageList#getDamageNumber()}
   *   <li>{@link DamageList#getId()}
   *   <li>{@link DamageList#getRemarks()}
   *   <li>{@link DamageList#getUser()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DamageList actualDamageList = new DamageList();
    Date damageDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualDamageList.setDamageDate(damageDate);
    actualDamageList.setDamageNumber("42");
    actualDamageList.setId(1);
    actualDamageList.setRemarks("Remarks");
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    actualDamageList.setUser(user);
    actualDamageList
        .setbDamageDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualDamageList
        .seteDamageDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualDamageList.toString();
    Date actualDamageDate = actualDamageList.getDamageDate();
    String actualDamageNumber = actualDamageList.getDamageNumber();
    Integer actualId = actualDamageList.getId();
    String actualRemarks = actualDamageList.getRemarks();
    User actualUser = actualDamageList.getUser();

    // Assert that nothing has changed
    assertEquals("42", actualDamageNumber);
    assertEquals("Remarks", actualRemarks);
    assertEquals(1, actualId.intValue());
    assertSame(user, actualUser);
    assertSame(damageDate, actualDamageDate);
  }
}
