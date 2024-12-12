package com.yufeng.controller.admin;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Log;
import com.yufeng.entity.Menu;
import com.yufeng.entity.Role;
import com.yufeng.entity.RoleMenu;
import com.yufeng.service.LogService;
import com.yufeng.service.MenuService;
import com.yufeng.service.RoleMenuService;
import com.yufeng.service.RoleService;
import com.yufeng.service.UserRoleService;
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

@ContextConfiguration(classes = {RoleAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleAdminControllerDiffblueTest {
  @MockBean
  private LogService logService;

  @MockBean
  private MenuService menuService;

  @Autowired
  private RoleAdminController roleAdminController;

  @MockBean
  private RoleMenuService roleMenuService;

  @MockBean
  private RoleService roleService;

  @MockBean
  private UserRoleService userRoleService;

  /**
   * Test {@link RoleAdminController#listAll()}.
   * <p>
   * Method under test: {@link RoleAdminController#listAll()}
   */
  @Test
  public void testListAll() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());
    when(roleService.listAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/role/listAll");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(roleAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link RoleAdminController#list(Role, Integer, Integer)}.
   * <p>
   * Method under test: {@link RoleAdminController#list(Role, Integer, Integer)}
   */
  @Test
  public void testList() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());
    when(roleService.getCount(Mockito.<Role>any())).thenReturn(3L);
    when(roleService.list(Mockito.<Role>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Sort.Direction>any(), (String[]) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/role/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(roleAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"total\":3,\"rows\":[]}"));
  }

  /**
   * Test {@link RoleAdminController#save(Role)}.
   * <p>
   * Method under test: {@link RoleAdminController#save(Role)}
   */
  @Test
  public void testSave() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());
    doNothing().when(roleService).save(Mockito.<Role>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/role/save");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(roleAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link RoleAdminController#delete(Integer)}.
   * <p>
   * Method under test: {@link RoleAdminController#delete(Integer)}
   */
  @Test
  public void testDelete() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");
    when(roleService.findById(Mockito.<Integer>any())).thenReturn(role);
    doNothing().when(roleService).delete(Mockito.<Integer>any());
    doNothing().when(userRoleService).deleteByRoleId(Mockito.<Integer>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/role/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(roleAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link RoleAdminController#loadCheckMenuInfo(Integer, Integer)}.
   * <p>
   * Method under test:
   * {@link RoleAdminController#loadCheckMenuInfo(Integer, Integer)}
   */
  @Test
  public void testLoadCheckMenuInfo() throws Exception {
    // Arrange
    when(menuService.findByParentId(anyInt())).thenReturn(new ArrayList<>());
    when(menuService.findByRoleId(anyInt())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/admin/role/loadCheckMenuInfo");
    MockHttpServletRequestBuilder paramResult = postResult.param("parentId", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("roleId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(roleAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Test {@link RoleAdminController#loadCheckMenuInfo(Integer, Integer)}.
   * <ul>
   *   <li>Given {@link Menu} (default constructor) Icon is {@code admin}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RoleAdminController#loadCheckMenuInfo(Integer, Integer)}
   */
  @Test
  public void testLoadCheckMenuInfo_givenMenuIconIsAdmin() throws Exception {
    // Arrange
    Menu menu = new Menu();
    menu.setIcon("admin");
    menu.setId(1);
    menu.setName("admin");
    menu.setState(1);
    menu.setUrl("https://example.org/example");
    menu.setpId(1);

    ArrayList<Menu> menuList = new ArrayList<>();
    menuList.add(menu);
    when(menuService.findByParentId(anyInt())).thenReturn(new ArrayList<>());
    when(menuService.findByRoleId(anyInt())).thenReturn(menuList);
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/admin/role/loadCheckMenuInfo");
    MockHttpServletRequestBuilder paramResult = postResult.param("parentId", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("roleId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(roleAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Test {@link RoleAdminController#saveMenuSet(String, Integer)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoleAdminController#saveMenuSet(String, Integer)}
   */
  @Test
  public void testSaveMenuSet_when42() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());

    Menu menu = new Menu();
    menu.setIcon("Icon");
    menu.setId(1);
    menu.setName("Name");
    menu.setState(1);
    menu.setUrl("https://example.org/example");
    menu.setpId(1);
    when(menuService.findById(Mockito.<Integer>any())).thenReturn(menu);
    doNothing().when(roleMenuService).save(Mockito.<RoleMenu>any());
    doNothing().when(roleMenuService).deleteByRoleId(Mockito.<Integer>any());

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");
    when(roleService.findById(Mockito.<Integer>any())).thenReturn(role);
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/admin/role/saveMenuSet")
        .param("menuIds", "42");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("roleId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(roleAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link RoleAdminController#saveMenuSet(String, Integer)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link RoleAdminController#saveMenuSet(String, Integer)}
   */
  @Test
  public void testSaveMenuSet_whenEmptyString() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());

    Menu menu = new Menu();
    menu.setIcon("Icon");
    menu.setId(1);
    menu.setName("Name");
    menu.setState(1);
    menu.setUrl("https://example.org/example");
    menu.setpId(1);
    when(menuService.findById(Mockito.<Integer>any())).thenReturn(menu);
    doNothing().when(roleMenuService).save(Mockito.<RoleMenu>any());
    doNothing().when(roleMenuService).deleteByRoleId(Mockito.<Integer>any());

    Role role = new Role();
    role.setId(1);
    role.setName("Name");
    role.setRemarks("Remarks");
    when(roleService.findById(Mockito.<Integer>any())).thenReturn(role);
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/admin/role/saveMenuSet")
        .param("menuIds", "");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("roleId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(roleAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }
}
