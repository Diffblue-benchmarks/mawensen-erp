package com.yufeng.controller.admin;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.Customer;
import com.yufeng.entity.Log;
import com.yufeng.entity.SaleList;
import com.yufeng.entity.SaleListGoods;
import com.yufeng.entity.User;
import com.yufeng.service.LogService;
import com.yufeng.service.SaleListGoodsService;
import com.yufeng.service.SaleListService;
import com.yufeng.service.UserService;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
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

@ContextConfiguration(classes = {SaleListAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SaleListAdminControllerDiffblueTest {
  @MockBean private LogService logService;

  @Autowired private SaleListAdminController saleListAdminController;

  @MockBean private SaleListGoodsService saleListGoodsService;

  @MockBean private SaleListService saleListService;

  @MockBean private UserService userService;

  /**
   * Test {@link SaleListAdminController#list(SaleList)}.
   *
   * <p>Method under test: {@link SaleListAdminController#list(SaleList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map SaleListAdminController.list(SaleList)"})
  public void testList() throws Exception {
    // Arrange
    when(saleListService.list(
            Mockito.<SaleList>any(), Mockito.<Direction>any(), (String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/saleList/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(saleListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link SaleListAdminController#listGoods(Integer)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then content contentType {@code application/json;charset=UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link SaleListAdminController#listGoods(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map SaleListAdminController.listGoods(Integer)"})
  public void testListGoods_whenValueOfOne_thenContentContentTypeApplicationJsonCharsetUtf8()
      throws Exception {
    // Arrange
    when(saleListGoodsService.listBySaleListId(Mockito.<Integer>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/admin/saleList/listGoods");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("saleListId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(saleListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link SaleListAdminController#listCount(SaleList, SaleListGoods)}.
   *
   * <p>Method under test: {@link SaleListAdminController#listCount(SaleList, SaleListGoods)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map SaleListAdminController.listCount(SaleList, SaleListGoods)"})
  public void testListCount() throws Exception {
    // Arrange
    when(saleListService.list(
            Mockito.<SaleList>any(), Mockito.<Direction>any(), (String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/saleList/listCount");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(saleListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link SaleListAdminController#genBillCode(String)}.
   *
   * <ul>
   *   <li>Then content string {@code XS202507140001}.
   * </ul>
   *
   * <p>Method under test: {@link SaleListAdminController#genBillCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SaleListAdminController.genBillCode(String)"})
  public void testGenBillCode_thenContentStringXs202507140001() throws Exception {
    // Arrange
    when(saleListService.getTodayMaxSaleNumber()).thenReturn(null);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/saleList/getSaleNumber").param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(saleListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("XS202507140001"));
  }

  /**
   * Test {@link SaleListAdminController#genBillCode(String)}.
   *
   * <ul>
   *   <li>Then content string {@code XS202507140100}.
   * </ul>
   *
   * <p>Method under test: {@link SaleListAdminController#genBillCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SaleListAdminController.genBillCode(String)"})
  public void testGenBillCode_thenContentStringXs202507140100() throws Exception {
    // Arrange
    when(saleListService.getTodayMaxSaleNumber()).thenReturn("admin");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/saleList/getSaleNumber").param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(saleListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("XS202507140100"));
  }

  /**
   * Test {@link SaleListAdminController#update(Integer)}.
   *
   * <p>Method under test: {@link SaleListAdminController#update(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map SaleListAdminController.update(Integer)"})
  public void testUpdate() throws Exception {
    // Arrange
    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    SaleList saleList = new SaleList();
    saleList.setAmountPaid(10.0f);
    saleList.setAmountPayable(10.0f);
    saleList.setCustomer(customer);
    saleList.setId(1);
    saleList.setRemarks("Remarks");
    saleList.setSaleDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.setSaleListGoodsList(new ArrayList<>());
    saleList.setSaleNumber("42");
    saleList.setState(1);
    saleList.setUser(user);
    saleList.setbSaleDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.seteSaleDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(saleListService).update(Mockito.<SaleList>any());
    when(saleListService.findById(Mockito.<Integer>any())).thenReturn(saleList);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/saleList/update");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(saleListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link SaleListAdminController#delete(Integer)}.
   *
   * <p>Method under test: {@link SaleListAdminController#delete(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map SaleListAdminController.delete(Integer)"})
  public void testDelete() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());

    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    SaleList saleList = new SaleList();
    saleList.setAmountPaid(10.0f);
    saleList.setAmountPayable(10.0f);
    saleList.setCustomer(customer);
    saleList.setId(1);
    saleList.setRemarks("Remarks");
    saleList.setSaleDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.setSaleListGoodsList(new ArrayList<>());
    saleList.setSaleNumber("42");
    saleList.setState(1);
    saleList.setUser(user);
    saleList.setbSaleDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.seteSaleDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(saleListService.findById(Mockito.<Integer>any())).thenReturn(saleList);
    doNothing().when(saleListService).delete(Mockito.<Integer>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/saleList/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(saleListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }
}
