package com.yufeng.controller.admin;

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.DamageList;
import com.yufeng.service.DamageListGoodsService;
import com.yufeng.service.DamageListService;
import com.yufeng.service.LogService;
import com.yufeng.service.UserService;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {DamageListAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DamageListAdminControllerDiffblueTest {
  @Autowired
  private DamageListAdminController damageListAdminController;

  @MockBean
  private DamageListGoodsService damageListGoodsService;

  @MockBean
  private DamageListService damageListService;

  @MockBean
  private LogService logService;

  @MockBean
  private UserService userService;

  /**
   * Test {@link DamageListAdminController#list(DamageList)}.
   * <p>
   * Method under test: {@link DamageListAdminController#list(DamageList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map DamageListAdminController.list(DamageList)"})
  public void testList() throws Exception {
    // Arrange
    when(damageListService.list(Mockito.<DamageList>any(), Mockito.<Direction>any(), (String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/damageList/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(damageListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link DamageListAdminController#listGoods(Integer)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then content contentType {@code application/json;charset=UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DamageListAdminController#listGoods(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map DamageListAdminController.listGoods(Integer)"})
  public void testListGoods_whenValueOfOne_thenContentContentTypeApplicationJsonCharsetUtf8() throws Exception {
    // Arrange
    when(damageListGoodsService.listByDamageListId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/damageList/listGoods");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("damageListId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(damageListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link DamageListAdminController#genBillCode(String)}.
   * <ul>
   *   <li>Then content string {@code BS202511040001}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DamageListAdminController#genBillCode(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DamageListAdminController.genBillCode(String)"})
  public void testGenBillCode_thenContentStringBs202511040001() throws Exception {
    // Arrange
    when(damageListService.getTodayMaxDamageNumber()).thenReturn(null);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/damageList/getDamageNumber")
        .param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(damageListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("BS202511040001"));
  }

  /**
   * Test {@link DamageListAdminController#genBillCode(String)}.
   * <ul>
   *   <li>Then content string {@code BS202511040100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DamageListAdminController#genBillCode(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DamageListAdminController.genBillCode(String)"})
  public void testGenBillCode_thenContentStringBs202511040100() throws Exception {
    // Arrange
    when(damageListService.getTodayMaxDamageNumber()).thenReturn("admin");
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/damageList/getDamageNumber")
        .param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(damageListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("BS202511040100"));
  }
}
