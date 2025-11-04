package com.yufeng.controller.admin;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Log;
import com.yufeng.entity.ReturnList;
import com.yufeng.entity.ReturnListGoods;
import com.yufeng.entity.Supplier;
import com.yufeng.entity.User;
import com.yufeng.service.LogService;
import com.yufeng.service.ReturnListGoodsService;
import com.yufeng.service.ReturnListService;
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

@ContextConfiguration(classes = {ReturnListAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ReturnListAdminControllerDiffblueTest {
  @MockBean
  private LogService logService;

  @Autowired
  private ReturnListAdminController returnListAdminController;

  @MockBean
  private ReturnListGoodsService returnListGoodsService;

  @MockBean
  private ReturnListService returnListService;

  @MockBean
  private UserService userService;

  /**
   * Method under test: {@link ReturnListAdminController#list(ReturnList)}
   */
  @Test
  public void testList() throws Exception {
    // Arrange
    when(returnListService.list(Mockito.<ReturnList>any(), Mockito.<Sort.Direction>any(), (String[]) any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/returnList/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Method under test:
   * {@link ReturnListAdminController#listCount(ReturnList, ReturnListGoods)}
   */
  @Test
  public void testListCount() throws Exception {
    // Arrange
    when(returnListService.list(Mockito.<ReturnList>any(), Mockito.<Sort.Direction>any(), (String[]) any()))
        .thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/returnList/listCount");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Method under test: {@link ReturnListAdminController#update(Integer)}
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

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(returnListService).update(Mockito.<ReturnList>any());
    when(returnListService.findById(Mockito.<Integer>any())).thenReturn(returnList);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/returnList/update");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Method under test: {@link ReturnListAdminController#delete(Integer)}
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

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(returnListService.findById(Mockito.<Integer>any())).thenReturn(returnList);
    doNothing().when(returnListService).delete(Mockito.<Integer>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/returnList/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Method under test: {@link ReturnListAdminController#genBillCode(String)}
   */
  @Test
  public void testGenBillCode() throws Exception {
    // Arrange
    when(returnListService.getTodayMaxReturnNumber()).thenReturn("admin");
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/returnList/getReturnNumber")
        .param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("TH202511040100"));
  }

  /**
   * Method under test: {@link ReturnListAdminController#genBillCode(String)}
   */
  @Test
  public void testGenBillCode2() throws Exception {
    // Arrange
    when(returnListService.getTodayMaxReturnNumber()).thenReturn(null);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/returnList/getReturnNumber")
        .param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("TH202511040001"));
  }

  /**
   * Method under test: {@link ReturnListAdminController#listGoods(Integer)}
   */
  @Test
  public void testListGoods() throws Exception {
    // Arrange
    when(returnListGoodsService.listByReturnListId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/returnList/listGoods");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("returnListId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }
}
