package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.User;
import com.yufeng.repository.UserRepository;
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

@ContextConfiguration(classes = {UserServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplDiffblueTest {
  @MockBean
  private UserRepository userRepository;

  @Autowired
  private UserServiceImpl userServiceImpl;

  /**
   * Test {@link UserServiceImpl#findByUserName(String)}.
   * <p>
   * Method under test: {@link UserServiceImpl#findByUserName(String)}
   */
  @Test
  public void testFindByUserName() {
    // Arrange
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    when(userRepository.findByUserName(Mockito.<String>any())).thenReturn(user);

    // Act
    User actualFindByUserNameResult = userServiceImpl.findByUserName("janedoe");

    // Assert
    verify(userRepository).findByUserName(Mockito.<String>any());
    assertSame(user, actualFindByUserNameResult);
  }

  /**
   * Test {@link UserServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link UserServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
    // Arrange
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    when(userRepository.findOne(Mockito.<Integer>any())).thenReturn(user);

    // Act
    User actualFindByIdResult = userServiceImpl.findById(1);

    // Assert
    verify(userRepository).findOne(anyInt());
    assertSame(user, actualFindByIdResult);
  }

  /**
   * Test {@link UserServiceImpl#save(User)}.
   * <p>
   * Method under test: {@link UserServiceImpl#save(User)}
   */
  @Test
  public void testSave() {
    // Arrange
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    when(userRepository.save(Mockito.<User>any())).thenReturn(user);

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    // Act
    userServiceImpl.save(user2);

    // Assert
    verify(userRepository).save(isA(User.class));
  }

  /**
   * Test
   * {@link UserServiceImpl#list(User, Integer, Integer, Direction, String[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#list(User, Integer, Integer, Sort.Direction, String[])}
   */
  @Test
  public void testList_thenReturnEmpty() {
    // Arrange
    when(userRepository.findAll(Mockito.<Specification<User>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    // Act
    List<User> actualListResult = userServiceImpl.list(user, 1, 3, Sort.Direction.ASC, "Properties");

    // Assert
    verify(userRepository).findAll(isA(Specification.class), isA(Pageable.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link UserServiceImpl#getCount(User)}.
   * <p>
   * Method under test: {@link UserServiceImpl#getCount(User)}
   */
  @Test
  public void testGetCount() {
    // Arrange
    when(userRepository.count(Mockito.<Specification<User>>any())).thenReturn(3L);

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    // Act
    Long actualCount = userServiceImpl.getCount(user);

    // Assert
    verify(userRepository).count(isA(Specification.class));
    assertEquals(3L, actualCount.longValue());
  }

  /**
   * Test {@link UserServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link UserServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(userRepository).delete(Mockito.<Integer>any());

    // Act
    userServiceImpl.delete(1);

    // Assert
    verify(userRepository).delete(anyInt());
  }
}
