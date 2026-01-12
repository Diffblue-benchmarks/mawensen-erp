package com.yufeng.controller.admin;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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

@ContextConfiguration(classes = {ReturnListAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ReturnListAdminControllerDiffblueTest {
  @MockBean private LogService logService;

  @Autowired private ReturnListAdminController returnListAdminController;

  @MockBean private ReturnListGoodsService returnListGoodsService;

  @MockBean private ReturnListService returnListService;

  @MockBean private UserService userService;

  /**
   * Test {@link ReturnListAdminController#list(ReturnList)}.
   *
   * <p>Method under test: {@link ReturnListAdminController#list(ReturnList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map ReturnListAdminController.list(ReturnList)"})
  public void testList() throws Exception {
    // Arrange
    when(returnListService.list(
            Mockito.<ReturnList>any(), Mockito.<Direction>any(), (String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/returnList/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link ReturnListAdminController#listGoods(Integer)}.
   *
   * <ul>
   *   <li>When valueOf one.
   *   <li>Then content contentType {@code application/json;charset=UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ReturnListAdminController#listGoods(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map ReturnListAdminController.listGoods(Integer)"})
  public void testListGoods_whenValueOfOne_thenContentContentTypeApplicationJsonCharsetUtf8()
      throws Exception {
    // Arrange
    when(returnListGoodsService.listByReturnListId(Mockito.<Integer>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/returnList/listGoods")
            .param("returnListId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link ReturnListAdminController#listCount(ReturnList, ReturnListGoods)}.
   *
   * <p>Method under test: {@link ReturnListAdminController#listCount(ReturnList, ReturnListGoods)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.util.Map ReturnListAdminController.listCount(ReturnList, ReturnListGoods)"
  })
  public void testListCount() throws Exception {
    // Arrange
    when(returnListService.list(
            Mockito.<ReturnList>any(), Mockito.<Direction>any(), (String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/returnList/listCount");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link ReturnListAdminController#genBillCode(String)}.
   *
   * <ul>
   *   <li>Then content string {@code TH202601130001}.
   * </ul>
   *
   * <p>Method under test: {@link ReturnListAdminController#genBillCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ReturnListAdminController.genBillCode(String)"})
  public void testGenBillCode_thenContentStringTh202601130001() throws Exception {
    // Arrange
    when(returnListService.getTodayMaxReturnNumber()).thenReturn(null);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/returnList/getReturnNumber").param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("TH202601130001"));
  }

  /**
   * Test {@link ReturnListAdminController#genBillCode(String)}.
   *
   * <ul>
   *   <li>Then content string {@code TH202601130100}.
   * </ul>
   *
   * <p>Method under test: {@link ReturnListAdminController#genBillCode(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ReturnListAdminController.genBillCode(String)"})
  public void testGenBillCode_thenContentStringTh202601130100() throws Exception {
    // Arrange
    when(returnListService.getTodayMaxReturnNumber()).thenReturn("admin");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/returnList/getReturnNumber").param("type", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("TH202601130100"));
  }

  /**
   * Test {@link ReturnListAdminController#update(Integer)}.
   *
   * <p>Method under test: {@link ReturnListAdminController#update(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map ReturnListAdminController.update(Integer)"})
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
    returnList.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    doNothing().when(returnListService).update(Mockito.<ReturnList>any());
    when(returnListService.findById(Mockito.<Integer>any())).thenReturn(returnList);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/returnList/update").param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"success\":true}"));
  }

  /**
   * Test {@link ReturnListAdminController#delete(Integer)}.
   *
   * <p>Method under test: {@link ReturnListAdminController#delete(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map ReturnListAdminController.delete(Integer)"})
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
    returnList.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(returnListService.findById(Mockito.<Integer>any())).thenReturn(returnList);
    doNothing().when(returnListService).delete(Mockito.<Integer>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/returnList/delete").param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(returnListAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"success\":true}"));
  }
}
