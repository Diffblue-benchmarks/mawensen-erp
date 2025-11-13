package com.yufeng.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.Menu;
import com.yufeng.entity.Role;
import com.yufeng.entity.User;
import com.yufeng.service.LogService;
import com.yufeng.service.MenuService;
import com.yufeng.service.RoleService;
import com.yufeng.service.UserService;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.catalina.session.StandardSession;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
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
   *   <li>Given {@code User}.
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
  public void testLogin_givenUser_whenEmptyString_thenReturnErrorInfoIs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    UserController userController = new UserController();

    User user = new User();
    user.setId(1);
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    user.setPassword("User");
    BindException bindingResult = new BindException("Target", "Object Name");

    MockHttpSession session = new MockHttpSession();
    session.setAttribute("checkcode", "Session");

    // Act
    Map<String, Object> actualLoginResult = userController.login("", user, bindingResult, session);

    // Assert
    assertEquals(2, actualLoginResult.size());
    assertEquals("请输入验证码！", actualLoginResult.get("errorInfo"));
    assertFalse((Boolean) actualLoginResult.get("success"));
  }

  /**
   * Test {@link UserController#login(String, User, BindingResult, HttpSession)}.
   *
   * <ul>
   *   <li>Given {@code User}.
   *   <li>When {@code null}.
   *   <li>Then return {@code errorInfo} is {@code 请输入验证码！}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#login(String, User, BindingResult, HttpSession)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map UserController.login(String, User, BindingResult, HttpSession)"})
  public void testLogin_givenUser_whenNull_thenReturnErrorInfoIs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    UserController userController = new UserController();

    User user = new User();
    user.setId(1);
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    user.setPassword("User");
    BindException bindingResult = new BindException("Target", "Object Name");

    MockHttpSession session = new MockHttpSession();
    session.setAttribute("checkcode", "Session");

    // Act
    Map<String, Object> actualLoginResult =
        userController.login(null, user, bindingResult, session);

    // Assert
    assertEquals(2, actualLoginResult.size());
    assertEquals("请输入验证码！", actualLoginResult.get("errorInfo"));
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

  /**
   * Test {@link UserController#loadUserInfo(HttpSession)}.
   *
   * <p>Method under test: {@link UserController#loadUserInfo(HttpSession)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserController.loadUserInfo(HttpSession)"})
  public void testLoadUserInfo() throws Exception {
    // Arrange
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/user/loadUserInfo")
            .sessionAttr("currentUser", user)
            .sessionAttr("currentRole", role);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("????True Name&nbsp;[&nbsp;Name&nbsp;]"));
  }

  /**
   * Test {@link UserController#loadMenuInfo(HttpSession, Integer)}.
   *
   * <ul>
   *   <li>Given {@link Menu} (default constructor) Icon is {@code user}.
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link UserController#loadMenuInfo(HttpSession, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserController.loadMenuInfo(HttpSession, Integer)"})
  public void testLoadMenuInfo_givenMenuIconIsUser_thenContentStringAString() throws Exception {
    // Arrange
    Menu menu = new Menu();
    menu.setIcon("user");
    menu.setId(1);
    menu.setName("user");
    menu.setState(2);
    menu.setUrl("https://example.org/example");
    menu.setpId(1);

    ArrayList<Menu> menuList = new ArrayList<>();
    menuList.add(menu);
    when(menuService.findByParentIdAndRoleId(anyInt(), anyInt())).thenReturn(menuList);

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/user/loadMenuInfo")
            .param("parentId", String.valueOf(1))
            .sessionAttr("currentRole", role);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(
            content()
                .string(
                    "[{\"id\":1,\"text\":\"user\",\"state\":\"open\",\"iconCls\":\"user\",\"attributes\":{\"url\":\"https://example.org"
                        + "/example\"}}]"));
  }

  /**
   * Test {@link UserController#loadMenuInfo(HttpSession, Integer)}.
   *
   * <ul>
   *   <li>Then content string {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link UserController#loadMenuInfo(HttpSession, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserController.loadMenuInfo(HttpSession, Integer)"})
  public void testLoadMenuInfo_thenContentStringLeftSquareBracketRightSquareBracket()
      throws Exception {
    // Arrange
    when(menuService.findByParentIdAndRoleId(anyInt(), anyInt())).thenReturn(new ArrayList<>());

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/user/loadMenuInfo")
            .param("parentId", String.valueOf(1))
            .sessionAttr("currentRole", role);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("[]"));
  }
}
