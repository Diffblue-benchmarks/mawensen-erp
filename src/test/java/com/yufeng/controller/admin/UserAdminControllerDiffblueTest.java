package com.yufeng.controller.admin;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Log;
import com.yufeng.entity.Role;
import com.yufeng.entity.User;
import com.yufeng.entity.UserRole;
import com.yufeng.service.LogService;
import com.yufeng.service.RoleService;
import com.yufeng.service.UserRoleService;
import com.yufeng.service.UserService;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAdminControllerDiffblueTest {
  @MockBean
  private LogService logService;

  @MockBean
  private RoleService roleService;

  @Autowired
  private UserAdminController userAdminController;

  @MockBean
  private UserRoleService userRoleService;

  @MockBean
  private UserService userService;

  /**
   * Test {@link UserAdminController#list(User, Integer, Integer)}.
   * <p>
   * Method under test: {@link UserAdminController#list(User, Integer, Integer)}
   */
  @Test
  public void testList() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());
    when(userService.getCount(Mockito.<User>any())).thenReturn(3L);
    when(userService.list(Mockito.<User>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Sort.Direction>any(), (String[]) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/user/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"total\":3,\"rows\":[]}"));
  }

  /**
   * Test {@link UserAdminController#saveRoleSet(String, Integer)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAdminController#saveRoleSet(String, Integer)}
   */
  @Test
  public void testSaveRoleSet_when42() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");
    when(roleService.findById(Mockito.<Integer>any())).thenReturn(role);
    doNothing().when(userRoleService).save(Mockito.<UserRole>any());
    doNothing().when(userRoleService).deleteByUserId(Mockito.<Integer>any());

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    when(userService.findById(Mockito.<Integer>any())).thenReturn(user);
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/admin/user/saveRoleSet")
        .param("roleIds", "42");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("userId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link UserAdminController#saveRoleSet(String, Integer)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserAdminController#saveRoleSet(String, Integer)}
   */
  @Test
  public void testSaveRoleSet_whenEmptyString() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");
    when(roleService.findById(Mockito.<Integer>any())).thenReturn(role);
    doNothing().when(userRoleService).save(Mockito.<UserRole>any());
    doNothing().when(userRoleService).deleteByUserId(Mockito.<Integer>any());

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    when(userService.findById(Mockito.<Integer>any())).thenReturn(user);
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/admin/user/saveRoleSet")
        .param("roleIds", "");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("userId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link UserAdminController#save(User)}.
   * <p>
   * Method under test: {@link UserAdminController#save(User)}
   */
  @Test
  public void testSave() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    when(userService.findByUserName(Mockito.<String>any())).thenReturn(user);
    doNothing().when(userService).save(Mockito.<User>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/user/save");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":false,\"errorInfo\":\"用户名已经存在!\"}"));
  }

  /**
   * Test {@link UserAdminController#delete(Integer)}.
   * <p>
   * Method under test: {@link UserAdminController#delete(Integer)}
   */
  @Test
  public void testDelete() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());
    doNothing().when(userRoleService).deleteByUserId(Mockito.<Integer>any());

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    when(userService.findById(Mockito.<Integer>any())).thenReturn(user);
    doNothing().when(userService).delete(Mockito.<Integer>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/user/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(userAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }
}
