package com.yufeng.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.yufeng.repository.MenuRepository;
import com.yufeng.repository.RoleRepository;
import com.yufeng.repository.UserRepository;
import java.util.Collection;
import java.util.List;
import org.aopalliance.aop.Advice;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.aop.AuthorizingAnnotationMethodInterceptor;
import org.apache.shiro.event.support.DefaultEventBus;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AopAllianceAnnotationsAuthorizingMethodInterceptor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
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
   * Test {@link ShiroConfig#securityManager()}.
   * <p>
   * Method under test: {@link ShiroConfig#securityManager()}
   */
  @Test
  public void testSecurityManager() {
    // Arrange and Act
    SecurityManager actualSecurityManagerResult = shiroConfig.securityManager();

    // Assert
    Collection<Realm> realms = ((DefaultWebSecurityManager) actualSecurityManagerResult).getRealms();
    assertEquals(1, realms.size());
    assertTrue(realms instanceof List);
    assertTrue(((DefaultWebSecurityManager) actualSecurityManagerResult)
        .getAuthenticator() instanceof ModularRealmAuthenticator);
    assertTrue(
        ((DefaultWebSecurityManager) actualSecurityManagerResult).getAuthorizer() instanceof ModularRealmAuthorizer);
    assertTrue(((DefaultWebSecurityManager) actualSecurityManagerResult).getEventBus() instanceof DefaultEventBus);
    assertTrue(((DefaultWebSecurityManager) actualSecurityManagerResult).getSubjectDAO() instanceof DefaultSubjectDAO);
    assertTrue(((DefaultWebSecurityManager) actualSecurityManagerResult)
        .getRememberMeManager() instanceof CookieRememberMeManager);
    assertTrue(actualSecurityManagerResult instanceof DefaultWebSecurityManager);
    assertTrue(((DefaultWebSecurityManager) actualSecurityManagerResult)
        .getSubjectFactory() instanceof DefaultWebSubjectFactory);
    assertTrue(((DefaultWebSecurityManager) actualSecurityManagerResult)
        .getSessionManager() instanceof ServletContainerSessionManager);
    assertNull(((DefaultWebSecurityManager) actualSecurityManagerResult).getSessionMode());
    assertNull(((DefaultWebSecurityManager) actualSecurityManagerResult).getCacheManager());
    assertTrue(((DefaultWebSecurityManager) actualSecurityManagerResult).isHttpSessionMode());
  }

  /**
   * Test {@link ShiroConfig#lifecycleBeanPostProcessor()}.
   * <p>
   * Method under test: {@link ShiroConfig#lifecycleBeanPostProcessor()}
   */
  @Test
  public void testLifecycleBeanPostProcessor() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, shiroConfig.lifecycleBeanPostProcessor().getOrder());
  }

  /**
   * Test {@link ShiroConfig#advisorAutoProxyCreator()}.
   * <p>
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

  /**
   * Test {@link ShiroConfig#authorizationAttributeSourceAdvisor()}.
   * <p>
   * Method under test: {@link ShiroConfig#authorizationAttributeSourceAdvisor()}
   */
  @Test
  public void testAuthorizationAttributeSourceAdvisor() {
    // Arrange and Act
    AuthorizationAttributeSourceAdvisor actualAuthorizationAttributeSourceAdvisorResult = shiroConfig
        .authorizationAttributeSourceAdvisor();

    // Assert
    Advice advice = actualAuthorizationAttributeSourceAdvisorResult.getAdvice();
    Collection<AuthorizingAnnotationMethodInterceptor> methodInterceptors = ((AopAllianceAnnotationsAuthorizingMethodInterceptor) advice)
        .getMethodInterceptors();
    assertEquals(5, methodInterceptors.size());
    assertTrue(methodInterceptors instanceof List);
    SecurityManager securityManager = actualAuthorizationAttributeSourceAdvisorResult.getSecurityManager();
    Collection<Realm> realms = ((DefaultWebSecurityManager) securityManager).getRealms();
    assertEquals(1, realms.size());
    assertTrue(realms instanceof List);
    assertTrue(((DefaultWebSecurityManager) securityManager).getAuthenticator() instanceof ModularRealmAuthenticator);
    assertTrue(((DefaultWebSecurityManager) securityManager).getAuthorizer() instanceof ModularRealmAuthorizer);
    assertTrue(((DefaultWebSecurityManager) securityManager).getEventBus() instanceof DefaultEventBus);
    assertTrue(((DefaultWebSecurityManager) securityManager).getSubjectDAO() instanceof DefaultSubjectDAO);
    assertTrue(advice instanceof AopAllianceAnnotationsAuthorizingMethodInterceptor);
    assertTrue(((DefaultWebSecurityManager) securityManager).getRememberMeManager() instanceof CookieRememberMeManager);
    assertTrue(securityManager instanceof DefaultWebSecurityManager);
    assertTrue(((DefaultWebSecurityManager) securityManager).getSubjectFactory() instanceof DefaultWebSubjectFactory);
    assertTrue(
        ((DefaultWebSecurityManager) securityManager).getSessionManager() instanceof ServletContainerSessionManager);
    assertNull(((DefaultWebSecurityManager) securityManager).getSessionMode());
    assertNull(((DefaultWebSecurityManager) securityManager).getCacheManager());
    assertFalse(actualAuthorizationAttributeSourceAdvisorResult.isRuntime());
    assertTrue(((DefaultWebSecurityManager) securityManager).isHttpSessionMode());
    assertTrue(actualAuthorizationAttributeSourceAdvisorResult.isPerInstance());
    assertEquals(Integer.MAX_VALUE, actualAuthorizationAttributeSourceAdvisorResult.getOrder());
  }
}
