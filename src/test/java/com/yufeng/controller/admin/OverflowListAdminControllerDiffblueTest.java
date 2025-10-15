package com.yufeng.controller.admin;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.OverflowList;
import com.yufeng.service.LogService;
import com.yufeng.service.OverflowListGoodsService;
import com.yufeng.service.OverflowListService;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OverflowListAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OverflowListAdminControllerDiffblueTest {
  @MockBean private LogService logService;

  @Autowired private OverflowListAdminController overflowListAdminController;

  @MockBean private OverflowListGoodsService overflowListGoodsService;

  @MockBean private OverflowListService overflowListService;

  @MockBean private UserService userService;

  /**
   * Test {@link OverflowListAdminController#list(OverflowList)}.
   *
   * <p>Method under test: {@link OverflowListAdminController#list(OverflowList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map OverflowListAdminController.list(OverflowList)"})
  public void testList() throws Exception {
    // Arrange
    when(overflowListService.list(
            Mockito.<OverflowList>any(), Mockito.<Direction>any(), (String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/overflowList/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(overflowListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link OverflowListAdminController#listGoods(Integer)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then content contentType {@code application/json;charset=UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link OverflowListAdminController#listGoods(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map OverflowListAdminController.listGoods(Integer)"})
  public void testListGoods_whenValueOfOne_thenContentContentTypeApplicationJsonCharsetUtf8()
      throws Exception {
    // Arrange
    when(overflowListGoodsService.listByOverflowListId(Mockito.<Integer>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/overflowList/listGoods")
            .param("overflowListId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(overflowListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link OverflowListAdminController#genBillCode(String)}.
   *
   * <ul>
   *   <li>Then content string {@code BY202510150001}.
   * </ul>
   *
   * <p>Method under test: {@link OverflowListAdminController#genBillCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OverflowListAdminController.genBillCode(String)"})
  public void testGenBillCode_thenContentStringBy202510150001() throws Exception {
    // Arrange
    when(overflowListService.getTodayMaxOverflowNumber()).thenReturn(null);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/overflowList/getOverflowNumber").param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(overflowListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("BY202510150001"));
  }

  /**
   * Test {@link OverflowListAdminController#genBillCode(String)}.
   *
   * <ul>
   *   <li>Then content string {@code BY202510150100}.
   * </ul>
   *
   * <p>Method under test: {@link OverflowListAdminController#genBillCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OverflowListAdminController.genBillCode(String)"})
  public void testGenBillCode_thenContentStringBy202510150100() throws Exception {
    // Arrange
    when(overflowListService.getTodayMaxOverflowNumber()).thenReturn("admin");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/overflowList/getOverflowNumber").param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(overflowListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("BY202510150100"));
  }
}
