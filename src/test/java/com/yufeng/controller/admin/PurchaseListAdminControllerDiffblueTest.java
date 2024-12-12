package com.yufeng.controller.admin;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Log;
import com.yufeng.entity.PurchaseList;
import com.yufeng.entity.PurchaseListGoods;
import com.yufeng.entity.Supplier;
import com.yufeng.entity.User;
import com.yufeng.service.LogService;
import com.yufeng.service.PurchaseListGoodsService;
import com.yufeng.service.PurchaseListService;
import com.yufeng.service.UserService;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
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

@ContextConfiguration(classes = {PurchaseListAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PurchaseListAdminControllerDiffblueTest {
  @MockBean
  private LogService logService;

  @Autowired
  private PurchaseListAdminController purchaseListAdminController;

  @MockBean
  private PurchaseListGoodsService purchaseListGoodsService;

  @MockBean
  private PurchaseListService purchaseListService;

  @MockBean
  private UserService userService;

  /**
   * Test {@link PurchaseListAdminController#list(PurchaseList)}.
   * <p>
   * Method under test: {@link PurchaseListAdminController#list(PurchaseList)}
   */
  @Test
  public void testList() throws Exception {
    // Arrange
    when(purchaseListService.list(Mockito.<PurchaseList>any(), Mockito.<Sort.Direction>any(), (String[]) any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/purchaseList/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(purchaseListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link PurchaseListAdminController#listGoods(Integer)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then content contentType {@code application/json;charset=UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PurchaseListAdminController#listGoods(Integer)}
   */
  @Test
  public void testListGoods_whenValueOfOne_thenContentContentTypeApplicationJsonCharsetUtf8() throws Exception {
    // Arrange
    when(purchaseListGoodsService.listByPurchaseListId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/purchaseList/listGoods");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("purchaseListId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(purchaseListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test
   * {@link PurchaseListAdminController#listCount(PurchaseList, PurchaseListGoods)}.
   * <p>
   * Method under test:
   * {@link PurchaseListAdminController#listCount(PurchaseList, PurchaseListGoods)}
   */
  @Test
  public void testListCount() throws Exception {
    // Arrange
    when(purchaseListService.list(Mockito.<PurchaseList>any(), Mockito.<Sort.Direction>any(), (String[]) any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/purchaseList/listCount");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(purchaseListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link PurchaseListAdminController#genBillCode(String)}.
   * <ul>
   *   <li>Then content string {@code JH202412120001}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PurchaseListAdminController#genBillCode(String)}
   */
  @Test
  public void testGenBillCode_thenContentStringJh202412120001() throws Exception {
    // Arrange
    when(purchaseListService.getTodayMaxPurchaseNumber()).thenReturn(null);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/purchaseList/getPurchaseNumber")
        .param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(purchaseListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("JH202412120001"));
  }

  /**
   * Test {@link PurchaseListAdminController#genBillCode(String)}.
   * <ul>
   *   <li>Then content string {@code JH202412120100}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PurchaseListAdminController#genBillCode(String)}
   */
  @Test
  public void testGenBillCode_thenContentStringJh202412120100() throws Exception {
    // Arrange
    when(purchaseListService.getTodayMaxPurchaseNumber()).thenReturn("admin");
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/purchaseList/getPurchaseNumber")
        .param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(purchaseListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("JH202412120100"));
  }

  /**
   * Test {@link PurchaseListAdminController#update(Integer)}.
   * <p>
   * Method under test: {@link PurchaseListAdminController#update(Integer)}
   */
  @Test
  public void testUpdate() throws Exception {
    // Arrange
    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    PurchaseList purchaseList = new PurchaseList();
    purchaseList.setAmountPaid(10.0f);
    purchaseList.setAmountPayable(10.0f);
    purchaseList.setId(1);
    purchaseList.setPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList.setPurchaseListGoodsList(new ArrayList<>());
    purchaseList.setPurchaseNumber("42");
    purchaseList.setRemarks("Remarks");
    purchaseList.setState(1);
    purchaseList.setSupplier(supplier);
    purchaseList.setUser(user);
    purchaseList
        .setbPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList
        .setePurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(purchaseListService).update(Mockito.<PurchaseList>any());
    when(purchaseListService.findById(Mockito.<Integer>any())).thenReturn(purchaseList);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/purchaseList/update");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(purchaseListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link PurchaseListAdminController#delete(Integer)}.
   * <p>
   * Method under test: {@link PurchaseListAdminController#delete(Integer)}
   */
  @Test
  public void testDelete() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());

    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    PurchaseList purchaseList = new PurchaseList();
    purchaseList.setAmountPaid(10.0f);
    purchaseList.setAmountPayable(10.0f);
    purchaseList.setId(1);
    purchaseList.setPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList.setPurchaseListGoodsList(new ArrayList<>());
    purchaseList.setPurchaseNumber("42");
    purchaseList.setRemarks("Remarks");
    purchaseList.setState(1);
    purchaseList.setSupplier(supplier);
    purchaseList.setUser(user);
    purchaseList
        .setbPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList
        .setePurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(purchaseListService.findById(Mockito.<Integer>any())).thenReturn(purchaseList);
    doNothing().when(purchaseListService).delete(Mockito.<Integer>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/purchaseList/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(purchaseListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }
}
