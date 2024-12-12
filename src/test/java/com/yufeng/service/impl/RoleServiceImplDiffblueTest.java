package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Role;
import com.yufeng.repository.RoleRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {RoleServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleServiceImplDiffblueTest {
  @MockBean
  private RoleRepository roleRepository;

  @Autowired
  private RoleServiceImpl roleServiceImpl;

  /**
   * Test {@link RoleServiceImpl#findByUserId(Integer)}.
   * <p>
   * Method under test: {@link RoleServiceImpl#findByUserId(Integer)}
   */
  @Test
  public void testFindByUserId() {
    // Arrange
    when(roleRepository.findByUserId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

    // Act
    List<Role> actualFindByUserIdResult = roleServiceImpl.findByUserId(1);

    // Assert
    verify(roleRepository).findByUserId(anyInt());
    assertTrue(actualFindByUserIdResult.isEmpty());
  }

  /**
   * Test {@link RoleServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link RoleServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
    // Arrange
    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");
    when(roleRepository.findOne(Mockito.<Integer>any())).thenReturn(role);

    // Act
    Role actualFindByIdResult = roleServiceImpl.findById(1);

    // Assert
    verify(roleRepository).findOne(anyInt());
    assertSame(role, actualFindByIdResult);
  }

  /**
   * Test {@link RoleServiceImpl#listAll()}.
   * <p>
   * Method under test: {@link RoleServiceImpl#listAll()}
   */
  @Test
  public void testListAll() {
    // Arrange
    when(roleRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<Role> actualListAllResult = roleServiceImpl.listAll();

    // Assert
    verify(roleRepository).findAll();
    assertTrue(actualListAllResult.isEmpty());
  }

  /**
   * Test
   * {@link RoleServiceImpl#list(Role, Integer, Integer, Direction, String[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RoleServiceImpl#list(Role, Integer, Integer, Sort.Direction, String[])}
   */
  @Test
  public void testList_thenReturnEmpty() {
    // Arrange
    when(roleRepository.findAll(Mockito.<Specification<Role>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");

    // Act
    List<Role> actualListResult = roleServiceImpl.list(role, 1, 3, Sort.Direction.ASC, "Properties");

    // Assert
    verify(roleRepository).findAll(isA(Specification.class), isA(Pageable.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link RoleServiceImpl#getCount(Role)}.
   * <p>
   * Method under test: {@link RoleServiceImpl#getCount(Role)}
   */
  @Test
  public void testGetCount() {
    // Arrange
    when(roleRepository.count(Mockito.<Specification<Role>>any())).thenReturn(3L);

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");

    // Act
    Long actualCount = roleServiceImpl.getCount(role);

    // Assert
    verify(roleRepository).count(isA(Specification.class));
    assertEquals(3L, actualCount.longValue());
  }

  /**
   * Test {@link RoleServiceImpl#save(Role)}.
   * <p>
   * Method under test: {@link RoleServiceImpl#save(Role)}
   */
  @Test
  public void testSave() {
    // Arrange
    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");
    when(roleRepository.save(Mockito.<Role>any())).thenReturn(role);

    Role role2 = new Role();
    role2.setId(1);
    role2.setName("Name");
    role2.setRemarks("Remarks");

    // Act
    roleServiceImpl.save(role2);

    // Assert
    verify(roleRepository).save(isA(Role.class));
  }

  /**
   * Test {@link RoleServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link RoleServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(roleRepository).delete(Mockito.<Integer>any());

    // Act
    roleServiceImpl.delete(1);

    // Assert
    verify(roleRepository).delete(anyInt());
  }
}
