package com.yufeng.controller.admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.Customer;
import com.yufeng.entity.Log;
import com.yufeng.service.CustomerService;
import com.yufeng.service.LogService;
import java.util.ArrayList;
import java.util.Map;
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

@ContextConfiguration(classes = {CustomerAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerAdminControllerDiffblueTest {
  @Autowired private CustomerAdminController customerAdminController;

  @MockBean private CustomerService customerService;

  @MockBean private LogService logService;

  /**
   * Test {@link CustomerAdminController#list(Customer, Integer, Integer)}.
   *
   * <p>Method under test: {@link CustomerAdminController#list(Customer, Integer, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CustomerAdminController.list(Customer, Integer, Integer)"})
  public void testList() throws Exception {
    // Arrange
    when(customerService.getCount(Mockito.<Customer>any())).thenReturn(3L);
    when(customerService.list(
            Mockito.<Customer>any(),
            Mockito.<Integer>any(),
            Mockito.<Integer>any(),
            Mockito.<Direction>any(),
            (String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(logService).save(Mockito.<Log>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/customer/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"total\":3,\"rows\":[]}"));
  }

  /**
   * Test {@link CustomerAdminController#comboList(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAdminController#comboList(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List CustomerAdminController.comboList(String)"})
  public void testComboList_whenFoo() throws Exception {
    // Arrange
    when(customerService.findByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/customer/comboList").param("q", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link CustomerAdminController#save(Customer)}.
   *
   * <p>Method under test: {@link CustomerAdminController#save(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CustomerAdminController.save(Customer)"})
  public void testSave() throws Exception {
    // Arrange
    doNothing().when(customerService).save(Mockito.<Customer>any());
    doNothing().when(logService).save(Mockito.<Log>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/customer/save");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"success\":true}"));
  }

  /**
   * Test {@link CustomerAdminController#delete(String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CustomerAdminController#delete(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map CustomerAdminController.delete(String)"})
  public void testDelete_whenComma_thenReturnSizeIsOne() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    Map<String, Object> actualDeleteResult = new CustomerAdminController().delete(",");

    // Assert
    assertEquals(1, actualDeleteResult.size());
    assertTrue((Boolean) actualDeleteResult.get("success"));
  }
}
