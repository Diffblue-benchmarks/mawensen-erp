package com.yufeng.service.impl;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Menu;
import com.yufeng.repository.MenuRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MenuServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MenuServiceImplDiffblueTest {
  @MockBean
  private MenuRepository menuRepository;

  @Autowired
  private MenuServiceImpl menuServiceImpl;

  /**
   * Test {@link MenuServiceImpl#findByRoleId(int)}.
   * <p>
   * Method under test: {@link MenuServiceImpl#findByRoleId(int)}
   */
  @Test
  public void testFindByRoleId() {
    // Arrange
    when(menuRepository.findByRoleId(anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<Menu> actualFindByRoleIdResult = menuServiceImpl.findByRoleId(1);

    // Assert
    verify(menuRepository).findByRoleId(anyInt());
    assertTrue(actualFindByRoleIdResult.isEmpty());
  }

  /**
   * Test {@link MenuServiceImpl#findByParentIdAndRoleId(int, int)}.
   * <p>
   * Method under test: {@link MenuServiceImpl#findByParentIdAndRoleId(int, int)}
   */
  @Test
  public void testFindByParentIdAndRoleId() {
    // Arrange
    when(menuRepository.findByParentIdAndRoleId(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<Menu> actualFindByParentIdAndRoleIdResult = menuServiceImpl.findByParentIdAndRoleId(1, 1);

    // Assert
    verify(menuRepository).findByParentIdAndRoleId(anyInt(), anyInt());
    assertTrue(actualFindByParentIdAndRoleIdResult.isEmpty());
  }

  /**
   * Test {@link MenuServiceImpl#findByParentId(int)}.
   * <p>
   * Method under test: {@link MenuServiceImpl#findByParentId(int)}
   */
  @Test
  public void testFindByParentId() {
    // Arrange
    when(menuRepository.findByParentId(anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<Menu> actualFindByParentIdResult = menuServiceImpl.findByParentId(1);

    // Assert
    verify(menuRepository).findByParentId(anyInt());
    assertTrue(actualFindByParentIdResult.isEmpty());
  }

  /**
   * Test {@link MenuServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link MenuServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
    // Arrange
    Menu menu = new Menu();
    menu.setIcon("Icon");
    menu.setId(1);
    menu.setName("Name");
    menu.setState(1);
    menu.setUrl("https://example.org/example");
    menu.setpId(1);
    when(menuRepository.findOne(Mockito.<Integer>any())).thenReturn(menu);

    // Act
    Menu actualFindByIdResult = menuServiceImpl.findById(1);

    // Assert
    verify(menuRepository).findOne(anyInt());
    assertSame(menu, actualFindByIdResult);
  }
}
