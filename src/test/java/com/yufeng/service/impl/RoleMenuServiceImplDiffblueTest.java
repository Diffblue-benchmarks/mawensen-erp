package com.yufeng.service.impl;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Menu;
import com.yufeng.entity.Role;
import com.yufeng.entity.RoleMenu;
import com.yufeng.repository.RoleMenuRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RoleMenuServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleMenuServiceImplDiffblueTest {
  @MockBean
  private RoleMenuRepository roleMenuRepository;

  @Autowired
  private RoleMenuServiceImpl roleMenuServiceImpl;

  /**
   * Test {@link RoleMenuServiceImpl#deleteByRoleId(Integer)}.
   * <p>
   * Method under test: {@link RoleMenuServiceImpl#deleteByRoleId(Integer)}
   */
  @Test
  public void testDeleteByRoleId() {
    // Arrange
    doNothing().when(roleMenuRepository).deleteByRoleId(Mockito.<Integer>any());

    // Act
    roleMenuServiceImpl.deleteByRoleId(1);

    // Assert
    verify(roleMenuRepository).deleteByRoleId(anyInt());
  }

  /**
   * Test {@link RoleMenuServiceImpl#save(RoleMenu)}.
   * <p>
   * Method under test: {@link RoleMenuServiceImpl#save(RoleMenu)}
   */
  @Test
  public void testSave() {
    // Arrange
    Menu menu = new Menu();
    menu.setIcon("Icon");
    menu.setId(1);
    menu.setName("Name");
    menu.setState(1);
    menu.setUrl("https://example.org/example");
    menu.setpId(1);

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");

    RoleMenu roleMenu = new RoleMenu();
    roleMenu.setId(1);
    roleMenu.setMenu(menu);
    roleMenu.setRole(role);
    when(roleMenuRepository.save(Mockito.<RoleMenu>any())).thenReturn(roleMenu);

    Menu menu2 = new Menu();
    menu2.setIcon("Icon");
    menu2.setId(1);
    menu2.setName("Name");
    menu2.setState(1);
    menu2.setUrl("https://example.org/example");
    menu2.setpId(1);

    Role role2 = new Role();
    role2.setId(1);
    role2.setName("Name");
    role2.setRemarks("Remarks");

    RoleMenu roleMenu2 = new RoleMenu();
    roleMenu2.setId(1);
    roleMenu2.setMenu(menu2);
    roleMenu2.setRole(role2);

    // Act
    roleMenuServiceImpl.save(roleMenu2);

    // Assert
    verify(roleMenuRepository).save(isA(RoleMenu.class));
  }
}
