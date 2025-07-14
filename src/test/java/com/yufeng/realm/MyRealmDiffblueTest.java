package com.yufeng.realm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.User;
import com.yufeng.repository.MenuRepository;
import com.yufeng.repository.RoleRepository;
import com.yufeng.repository.UserRepository;
import java.util.Set;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MyRealm.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MyRealmDiffblueTest {
  @MockBean private MenuRepository menuRepository;

  @Autowired private MyRealm myRealm;

  @MockBean private RoleRepository roleRepository;

  @Rule public ExpectedException thrown = ExpectedException.none();

  @MockBean private UserRepository userRepository;

  /**
   * Test {@link MyRealm#doGetAuthenticationInfo(AuthenticationToken)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is one.
   *   <li>Then return {@link SimpleAuthenticationInfo}.
   * </ul>
   *
   * <p>Method under test: {@link MyRealm#doGetAuthenticationInfo(AuthenticationToken)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AuthenticationInfo MyRealm.doGetAuthenticationInfo(AuthenticationToken)"})
  public void testDoGetAuthenticationInfo_givenUserIdIsOne_thenReturnSimpleAuthenticationInfo()
      throws AuthenticationException {
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
    AuthenticationInfo actualDoGetAuthenticationInfoResult =
        myRealm.doGetAuthenticationInfo(new UsernamePasswordToken("janedoe", "iloveyou"));

    // Assert
    verify(userRepository).findByUserName(Mockito.<String>any());
    assertTrue(actualDoGetAuthenticationInfoResult instanceof SimpleAuthenticationInfo);
    PrincipalCollection principals = actualDoGetAuthenticationInfoResult.getPrincipals();
    assertTrue(principals instanceof SimplePrincipalCollection);
    assertEquals("iloveyou", actualDoGetAuthenticationInfoResult.getCredentials());
    assertEquals("janedoe", principals.getPrimaryPrincipal());
    assertNull(
        ((SimpleAuthenticationInfo) actualDoGetAuthenticationInfoResult).getCredentialsSalt());
    Set<String> realmNames = principals.getRealmNames();
    assertEquals(1, realmNames.size());
    assertFalse(principals.isEmpty());
    assertTrue(realmNames.contains("xxx"));
  }

  /**
   * Test {@link MyRealm#doGetAuthenticationInfo(AuthenticationToken)}.
   *
   * <ul>
   *   <li>Then throw {@link AuthenticationException}.
   * </ul>
   *
   * <p>Method under test: {@link MyRealm#doGetAuthenticationInfo(AuthenticationToken)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AuthenticationInfo MyRealm.doGetAuthenticationInfo(AuthenticationToken)"})
  public void testDoGetAuthenticationInfo_thenThrowAuthenticationException()
      throws AuthenticationException {
    // Arrange
    when(userRepository.findByUserName(Mockito.<String>any()))
        .thenThrow(new AuthenticationException("An error occurred"));

    // Act and Assert
    thrown.expect(AuthenticationException.class);
    myRealm.doGetAuthenticationInfo(new UsernamePasswordToken("janedoe", "iloveyou"));
    verify(userRepository).findByUserName(Mockito.<String>any());
  }

  /**
   * Test new {@link MyRealm} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link MyRealm}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void MyRealm.<init>()"})
  public void testNewMyRealm() {
    // Arrange and Act
    MyRealm actualMyRealm = new MyRealm();

    // Assert
    assertTrue(actualMyRealm.getCredentialsMatcher() instanceof SimpleCredentialsMatcher);
    assertTrue(actualMyRealm.getPermissionResolver() instanceof WildcardPermissionResolver);
    assertNull(actualMyRealm.getRolePermissionResolver());
    assertNull(actualMyRealm.getAuthenticationCache());
    assertNull(actualMyRealm.getAuthorizationCache());
    assertNull(actualMyRealm.getCacheManager());
    assertFalse(actualMyRealm.isAuthenticationCachingEnabled());
    assertTrue(actualMyRealm.isAuthorizationCachingEnabled());
    assertTrue(actualMyRealm.isCachingEnabled());
    Class<UsernamePasswordToken> expectedAuthenticationTokenClass = UsernamePasswordToken.class;
    assertEquals(expectedAuthenticationTokenClass, actualMyRealm.getAuthenticationTokenClass());
  }
}
