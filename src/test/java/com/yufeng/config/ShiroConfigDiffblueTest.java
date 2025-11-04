package com.yufeng.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.yufeng.repository.MenuRepository;
import com.yufeng.repository.RoleRepository;
import com.yufeng.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ShiroConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ShiroConfigDiffblueTest {
  @MockBean
  private MenuRepository menuRepository;

  @MockBean
  private RoleRepository roleRepository;

  @Autowired
  private ShiroConfig shiroConfig;

  @MockBean
  private UserRepository userRepository;

  /**
   * Method under test: {@link ShiroConfig#lifecycleBeanPostProcessor()}
   */
  @Test
  public void testLifecycleBeanPostProcessor() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, shiroConfig.lifecycleBeanPostProcessor().getOrder());
  }

  /**
   * Method under test: {@link ShiroConfig#advisorAutoProxyCreator()}
   */
  @Test
  public void testAdvisorAutoProxyCreator() {
    // Arrange and Act
    DefaultAdvisorAutoProxyCreator actualAdvisorAutoProxyCreatorResult = shiroConfig.advisorAutoProxyCreator();

    // Assert
    assertEquals("advisorAutoProxyCreator.", actualAdvisorAutoProxyCreatorResult.getAdvisorBeanNamePrefix());
    assertFalse(actualAdvisorAutoProxyCreatorResult.isExposeProxy());
    assertFalse(actualAdvisorAutoProxyCreatorResult.isOpaque());
    assertFalse(actualAdvisorAutoProxyCreatorResult.isOptimize());
    assertFalse(actualAdvisorAutoProxyCreatorResult.isFrozen());
    assertFalse(actualAdvisorAutoProxyCreatorResult.isUsePrefix());
    assertTrue(actualAdvisorAutoProxyCreatorResult.isProxyTargetClass());
    assertEquals(Integer.MAX_VALUE, actualAdvisorAutoProxyCreatorResult.getOrder());
  }
}
