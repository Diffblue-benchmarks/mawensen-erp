package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class RoleMenuDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RoleMenu}
   *   <li>{@link RoleMenu#setId(Integer)}
   *   <li>{@link RoleMenu#setMenu(Menu)}
   *   <li>{@link RoleMenu#setRole(Role)}
   *   <li>{@link RoleMenu#toString()}
   *   <li>{@link RoleMenu#getId()}
   *   <li>{@link RoleMenu#getMenu()}
   *   <li>{@link RoleMenu#getRole()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RoleMenu actualRoleMenu = new RoleMenu();
    actualRoleMenu.setId(1);
    Menu menu = new Menu();
    menu.setIcon("Icon");
    menu.setId(1);
    menu.setName("Name");
    menu.setState(1);
    menu.setUrl("https://example.org/example");
    menu.setpId(1);
    actualRoleMenu.setMenu(menu);
    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");
    actualRoleMenu.setRole(role);
    String actualToStringResult = actualRoleMenu.toString();
    Integer actualId = actualRoleMenu.getId();
    Menu actualMenu = actualRoleMenu.getMenu();
    Role actualRole = actualRoleMenu.getRole();

    // Assert that nothing has changed
    assertEquals("RoleMenu [id=1, role=[id=1, name=Name, remarks=Remarks], menu=[id=1, name=Name, url=https://example"
        + ".org/example, state=1, icon=Icon, pId=1]]", actualToStringResult);
    assertEquals(1, actualId.intValue());
    assertSame(menu, actualMenu);
    assertSame(role, actualRole);
  }
}
