package com.yufeng.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.Role;
import com.yufeng.entity.User;
import com.yufeng.service.LogService;
import com.yufeng.service.MenuService;
import com.yufeng.service.RoleService;
import com.yufeng.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.catalina.session.StandardSession;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@ContextConfiguration(classes = {UserController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerDiffblueTest {
  @MockBean private LogService logService;

  @MockBean private MenuService menuService;

  @MockBean private RoleService roleService;

  @Autowired private UserController userController;

  @MockBean private UserService userService;

  /**
   * Test {@link UserController#login(String, User, BindingResult, HttpSession)}.
   *
   * <ul>
   *   <li>Given {@code Attribute}.
   *   <li>When {@code Image Code}.
   *   <li>Then return {@code errorInfo} is {@code 验证码输入错误！}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#login(String, User, BindingResult, HttpSession)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map UserController.login(String, User, BindingResult, HttpSession)"})
  public void testLogin_givenAttribute_whenImageCode_thenReturnErrorInfoIs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    UserController userController = new UserController();

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    BindException bindingResult = new BindException("Target", "Object Name");

    StandardSession session = mock(StandardSession.class);
    when(session.getAttribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    Map<String, Object> actualLoginResult =
        userController.login("Image Code", user, bindingResult, session);

    // Assert
    verify(session).getAttribute(Mockito.<String>any());
    assertEquals(2, actualLoginResult.size());
    assertEquals("验证码输入错误！", actualLoginResult.get("errorInfo"));
    assertFalse((Boolean) actualLoginResult.get("success"));
  }

  /**
   * Test {@link UserController#login(String, User, BindingResult, HttpSession)}.
   *
   * <ul>
   *   <li>Then return {@code errorInfo} is {@code Default Message}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#login(String, User, BindingResult, HttpSession)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map UserController.login(String, User, BindingResult, HttpSession)"})
  public void testLogin_thenReturnErrorInfoIsDefaultMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    UserController userController = new UserController();

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    BeanPropertyBindingResult bindingResult = mock(BeanPropertyBindingResult.class);
    FieldError fieldError = new FieldError("Object Name", "Field", "Default Message");
    when(bindingResult.getFieldError()).thenReturn(fieldError);
    when(bindingResult.hasErrors()).thenReturn(true);

    StandardSession session = mock(StandardSession.class);
    when(session.getAttribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    Map<String, Object> actualLoginResult =
        userController.login("Attribute", user, bindingResult, session);

    // Assert
    verify(session).getAttribute(Mockito.<String>any());
    verify(bindingResult).getFieldError();
    verify(bindingResult).hasErrors();
    assertEquals(2, actualLoginResult.size());
    assertEquals("Default Message", actualLoginResult.get("errorInfo"));
    assertFalse((Boolean) actualLoginResult.get("success"));
  }

  /**
   * Test {@link UserController#login(String, User, BindingResult, HttpSession)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code errorInfo} is {@code 请输入验证码！}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#login(String, User, BindingResult, HttpSession)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map UserController.login(String, User, BindingResult, HttpSession)"})
  public void testLogin_whenEmptyString_thenReturnErrorInfoIs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    UserController userController = new UserController();

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    // Act
    Map<String, Object> actualLoginResult =
        userController.login(
            "", user, new BindException("Target", "Object Name"), mock(StandardSession.class));

    // Assert
    assertEquals(2, actualLoginResult.size());
    assertEquals("请输入验证码！", actualLoginResult.get("errorInfo"));
    assertFalse((Boolean) actualLoginResult.get("success"));
  }

  /**
   * Test {@link UserController#saveRole(Integer, HttpSession)}.
   *
   * <p>Method under test: {@link UserController#saveRole(Integer, HttpSession)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map UserController.saveRole(Integer, HttpSession)"})
  public void testSaveRole() throws Exception {
    // Arrange
    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");
    when(roleService.findById(Mockito.<Integer>any())).thenReturn(role);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/user/saveRole").param("roleId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"success\":true}"));
  }
}
