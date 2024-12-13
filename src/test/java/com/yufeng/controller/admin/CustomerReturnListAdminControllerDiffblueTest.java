package com.yufeng.controller.admin;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Customer;
import com.yufeng.entity.CustomerReturnList;
import com.yufeng.entity.CustomerReturnListGoods;
import com.yufeng.entity.Log;
import com.yufeng.entity.User;
import com.yufeng.service.CustomerReturnListGoodsService;
import com.yufeng.service.CustomerReturnListService;
import com.yufeng.service.LogService;
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

@ContextConfiguration(classes = {CustomerReturnListAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerReturnListAdminControllerDiffblueTest {
  @Autowired
  private CustomerReturnListAdminController customerReturnListAdminController;

  @MockBean
  private CustomerReturnListGoodsService customerReturnListGoodsService;

  @MockBean
  private CustomerReturnListService customerReturnListService;

  @MockBean
  private LogService logService;

  @MockBean
  private UserService userService;

  /**
   * Test {@link CustomerReturnListAdminController#list(CustomerReturnList)}.
   * <p>
   * Method under test:
   * {@link CustomerReturnListAdminController#list(CustomerReturnList)}
   */
  @Test
  public void testList() throws Exception {
    // Arrange
    when(customerReturnListService.list(Mockito.<CustomerReturnList>any(), Mockito.<Sort.Direction>any(),
        (String[]) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/customerReturnList/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerReturnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link CustomerReturnListAdminController#listGoods(Integer)}.
   * <ul>
   *   <li>When valueOf one.</li>
   *   <li>Then content contentType {@code application/json;charset=UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerReturnListAdminController#listGoods(Integer)}
   */
  @Test
  public void testListGoods_whenValueOfOne_thenContentContentTypeApplicationJsonCharsetUtf8() throws Exception {
    // Arrange
    when(customerReturnListGoodsService.listByCustomerReturnListId(Mockito.<Integer>any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/customerReturnList/listGoods");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("customerReturnListId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerReturnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test
   * {@link CustomerReturnListAdminController#listCount(CustomerReturnList, CustomerReturnListGoods)}.
   * <p>
   * Method under test:
   * {@link CustomerReturnListAdminController#listCount(CustomerReturnList, CustomerReturnListGoods)}
   */
  @Test
  public void testListCount() throws Exception {
    // Arrange
    when(customerReturnListService.list(Mockito.<CustomerReturnList>any(), Mockito.<Sort.Direction>any(),
        (String[]) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/customerReturnList/listCount");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerReturnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link CustomerReturnListAdminController#genBillCode(String)}.
   * <ul>
   *   <li>Then content string {@code XT202412130001}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerReturnListAdminController#genBillCode(String)}
   */
  @Test
  public void testGenBillCode_thenContentStringXt202412130001() throws Exception {
    // Arrange
    when(customerReturnListService.getTodayMaxCustomerReturnNumber()).thenReturn(null);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/admin/customerReturnList/getCustomerReturnNumber")
        .param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerReturnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("XT202412130001"));
  }

  /**
   * Test {@link CustomerReturnListAdminController#genBillCode(String)}.
   * <ul>
   *   <li>Then content string {@code XT202412130100}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerReturnListAdminController#genBillCode(String)}
   */
  @Test
  public void testGenBillCode_thenContentStringXt202412130100() throws Exception {
    // Arrange
    when(customerReturnListService.getTodayMaxCustomerReturnNumber()).thenReturn("admin");
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/admin/customerReturnList/getCustomerReturnNumber")
        .param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerReturnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("XT202412130100"));
  }

  /**
   * Test {@link CustomerReturnListAdminController#update(Integer)}.
   * <p>
   * Method under test: {@link CustomerReturnListAdminController#update(Integer)}
   */
  @Test
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

    CustomerReturnList customerReturnList = new CustomerReturnList();
    customerReturnList.setAmountPaid(10.0f);
    customerReturnList.setAmountPayable(10.0f);
    customerReturnList.setCustomer(customer);
    customerReturnList
        .setCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList.setCustomerReturnNumber("42");
    customerReturnList.setId(1);
    customerReturnList.setRemarks("Remarks");
    customerReturnList.setState(1);
    customerReturnList.setUser(user);
    customerReturnList
        .setbCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList
        .seteCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(customerReturnListService).update(Mockito.<CustomerReturnList>any());
    when(customerReturnListService.findById(Mockito.<Integer>any())).thenReturn(customerReturnList);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/customerReturnList/update");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerReturnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link CustomerReturnListAdminController#delete(Integer)}.
   * <p>
   * Method under test: {@link CustomerReturnListAdminController#delete(Integer)}
   */
  @Test
  public void testDelete() throws Exception {
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

    CustomerReturnList customerReturnList = new CustomerReturnList();
    customerReturnList.setAmountPaid(10.0f);
    customerReturnList.setAmountPayable(10.0f);
    customerReturnList.setCustomer(customer);
    customerReturnList
        .setCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList.setCustomerReturnNumber("42");
    customerReturnList.setId(1);
    customerReturnList.setRemarks("Remarks");
    customerReturnList.setState(1);
    customerReturnList.setUser(user);
    customerReturnList
        .setbCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList
        .seteCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(customerReturnListService.findById(Mockito.<Integer>any())).thenReturn(customerReturnList);
    doNothing().when(customerReturnListService).delete(Mockito.<Integer>any());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/customerReturnList/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerReturnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }
}
