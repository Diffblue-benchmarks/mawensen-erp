package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UserRoleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UserRole}
   *   <li>{@link UserRole#setId(Integer)}
   *   <li>{@link UserRole#setRole(Role)}
   *   <li>{@link UserRole#setUser(User)}
   *   <li>{@link UserRole#toString()}
   *   <li>{@link UserRole#getId()}
   *   <li>{@link UserRole#getRole()}
   *   <li>{@link UserRole#getUser()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserRole.<init>()",
    "Integer UserRole.getId()",
    "Role UserRole.getRole()",
    "User UserRole.getUser()",
    "void UserRole.setId(Integer)",
    "void UserRole.setRole(Role)",
    "void UserRole.setUser(User)",
    "String UserRole.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UserRole actualUserRole = new UserRole();
    actualUserRole.setId(1);
    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");
    actualUserRole.setRole(role);
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    actualUserRole.setUser(user);
    String actualToStringResult = actualUserRole.toString();
    Integer actualId = actualUserRole.getId();
    Role actualRole = actualUserRole.getRole();
    User actualUser = actualUserRole.getUser();

    // Assert
    assertEquals(
        "[id=1, user=[id=1, userName=janedoe, password=iloveyou, trueName=True Name, remarks=Remarks, roles=Roles],"
            + " role=[id=1, name=Name, remarks=Remarks]]",
        actualToStringResult);
    assertEquals(1, actualId.intValue());
    assertSame(role, actualRole);
    assertSame(user, actualUser);
  }
}
