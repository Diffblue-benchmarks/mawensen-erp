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
import com.yufeng.entity.Log;
import com.yufeng.entity.Supplier;
import com.yufeng.service.LogService;
import com.yufeng.service.SupplierService;
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

@ContextConfiguration(classes = {SupplierAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SupplierAdminControllerDiffblueTest {
  @MockBean private LogService logService;

  @Autowired private SupplierAdminController supplierAdminController;

  @MockBean private SupplierService supplierService;

  /**
   * Test {@link SupplierAdminController#list(Supplier, Integer, Integer)}.
   *
   * <p>Method under test: {@link SupplierAdminController#list(Supplier, Integer, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SupplierAdminController.list(Supplier, Integer, Integer)"})
  public void testList() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());
    when(supplierService.getCount(Mockito.<Supplier>any())).thenReturn(3L);
    when(supplierService.list(
            Mockito.<Supplier>any(),
            Mockito.<Integer>any(),
            Mockito.<Integer>any(),
            Mockito.<Direction>any(),
            (String[]) Mockito.any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/supplier/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(supplierAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"total\":3,\"rows\":[]}"));
  }

  /**
   * Test {@link SupplierAdminController#comboList(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link SupplierAdminController#comboList(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List SupplierAdminController.comboList(String)"})
  public void testComboList_whenFoo() throws Exception {
    // Arrange
    when(supplierService.findByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/supplier/comboList").param("q", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(supplierAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link SupplierAdminController#save(Supplier)}.
   *
   * <p>Method under test: {@link SupplierAdminController#save(Supplier)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SupplierAdminController.save(Supplier)"})
  public void testSave() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());
    doNothing().when(supplierService).save(Mockito.<Supplier>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/supplier/save");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(supplierAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"success\":true}"));
  }

  /**
   * Test {@link SupplierAdminController#delete(String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SupplierAdminController#delete(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SupplierAdminController.delete(String)"})
  public void testDelete_whenComma_thenReturnSizeIsOne() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    Map<String, Object> actualDeleteResult = new SupplierAdminController().delete(",");

    // Assert
    assertEquals(1, actualDeleteResult.size());
    assertTrue((Boolean) actualDeleteResult.get("success"));
  }
}
