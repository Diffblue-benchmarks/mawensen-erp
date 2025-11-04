package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UserDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link User}
   *   <li>{@link User#setId(Integer)}
   *   <li>{@link User#setPassword(String)}
   *   <li>{@link User#setRemarks(String)}
   *   <li>{@link User#setRoles(String)}
   *   <li>{@link User#setTrueName(String)}
   *   <li>{@link User#setUserName(String)}
   *   <li>{@link User#toString()}
   *   <li>{@link User#getId()}
   *   <li>{@link User#getPassword()}
   *   <li>{@link User#getRemarks()}
   *   <li>{@link User#getRoles()}
   *   <li>{@link User#getTrueName()}
   *   <li>{@link User#getUserName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void User.<init>()", "Integer User.getId()", "String User.getPassword()",
      "String User.getRemarks()", "String User.getRoles()", "String User.getTrueName()", "String User.getUserName()",
      "void User.setId(Integer)", "void User.setPassword(String)", "void User.setRemarks(String)",
      "void User.setRoles(String)", "void User.setTrueName(String)", "void User.setUserName(String)",
      "String User.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    User actualUser = new User();
    actualUser.setId(1);
    actualUser.setPassword("iloveyou");
    actualUser.setRemarks("Remarks");
    actualUser.setRoles("Roles");
    actualUser.setTrueName("True Name");
    actualUser.setUserName("janedoe");
    String actualToStringResult = actualUser.toString();
    Integer actualId = actualUser.getId();
    String actualPassword = actualUser.getPassword();
    String actualRemarks = actualUser.getRemarks();
    String actualRoles = actualUser.getRoles();
    String actualTrueName = actualUser.getTrueName();

    // Assert
    assertEquals("Remarks", actualRemarks);
    assertEquals("Roles", actualRoles);
    assertEquals("True Name", actualTrueName);
    assertEquals("[id=1, userName=janedoe, password=iloveyou, trueName=True Name, remarks=Remarks, roles=Roles]",
        actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUser.getUserName());
    assertEquals(1, actualId.intValue());
  }
}
