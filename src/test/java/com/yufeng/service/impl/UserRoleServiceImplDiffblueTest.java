package com.yufeng.service.impl;

import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Role;
import com.yufeng.entity.User;
import com.yufeng.entity.UserRole;
import com.yufeng.repository.UserRoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {UserRoleServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRoleServiceImplDiffblueTest {
  @MockBean
  private UserRoleRepository userRoleRepository;

  @Autowired
  private UserRoleServiceImpl userRoleServiceImpl;

  /**
   * Test {@link UserRoleServiceImpl#save(UserRole)}.
   * <p>
   * Method under test: {@link UserRoleServiceImpl#save(UserRole)}
   */
  @Test
  public void testSave() {
    // Arrange
    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    UserRole userRole = new UserRole();
    userRole.setId(1);
    userRole.setRole(role);
    userRole.setUser(user);
    when(userRoleRepository.save(Mockito.<UserRole>any())).thenReturn(userRole);

    Role role2 = new Role();
    role2.setId(1);
    role2.setName("Name");
    role2.setRemarks("Remarks");

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    UserRole userRole2 = new UserRole();
    userRole2.setId(1);
    userRole2.setRole(role2);
    userRole2.setUser(user2);

    // Act
    userRoleServiceImpl.save(userRole2);

    // Assert
    verify(userRoleRepository).save(isA(UserRole.class));
  }

  /**
   * Test {@link UserRoleServiceImpl#delete(UserRole)}.
   * <p>
   * Method under test: {@link UserRoleServiceImpl#delete(UserRole)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(userRoleRepository).delete(Mockito.<UserRole>any());

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    UserRole userRole = new UserRole();
    userRole.setId(1);
    userRole.setRole(role);
    userRole.setUser(user);

    // Act
    userRoleServiceImpl.delete(userRole);

    // Assert
    verify(userRoleRepository).delete(isA(UserRole.class));
  }

  /**
   * Test {@link UserRoleServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link UserRoleServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
    // Arrange
    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    UserRole userRole = new UserRole();
    userRole.setId(1);
    userRole.setRole(role);
    userRole.setUser(user);
    when(userRoleRepository.findOne(Mockito.<Integer>any())).thenReturn(userRole);

    // Act
    UserRole actualFindByIdResult = userRoleServiceImpl.findById(1);

    // Assert
    verify(userRoleRepository).findOne(anyInt());
    assertSame(userRole, actualFindByIdResult);
  }

  /**
   * Test {@link UserRoleServiceImpl#deleteByUserId(Integer)}.
   * <p>
   * Method under test: {@link UserRoleServiceImpl#deleteByUserId(Integer)}
   */
  @Test
  public void testDeleteByUserId() {
    // Arrange
    doNothing().when(userRoleRepository).deleteByUserId(Mockito.<Integer>any());

    // Act
    userRoleServiceImpl.deleteByUserId(1);

    // Assert
    verify(userRoleRepository).deleteByUserId(anyInt());
  }

  /**
   * Test {@link UserRoleServiceImpl#deleteByRoleId(Integer)}.
   * <p>
   * Method under test: {@link UserRoleServiceImpl#deleteByRoleId(Integer)}
   */
  @Test
  public void testDeleteByRoleId() {
    // Arrange
    doNothing().when(userRoleRepository).deleteByRoleId(Mockito.<Integer>any());

    // Act
    userRoleServiceImpl.deleteByRoleId(1);

    // Assert
    verify(userRoleRepository).deleteByRoleId(anyInt());
  }
}
