package com.yufeng.controller.admin;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Log;
import com.yufeng.entity.Supplier;
import com.yufeng.service.LogService;
import com.yufeng.service.SupplierService;
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

@ContextConfiguration(classes = {SupplierAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SupplierAdminControllerDiffblueTest {
  @MockBean
  private LogService logService;

  @Autowired
  private SupplierAdminController supplierAdminController;

  @MockBean
  private SupplierService supplierService;

  /**
   * Test {@link SupplierAdminController#list(Supplier, Integer, Integer)}.
   * <p>
   * Method under test:
   * {@link SupplierAdminController#list(Supplier, Integer, Integer)}
   */
  @Test
  public void testList() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());
    when(supplierService.getCount(Mockito.<Supplier>any())).thenReturn(3L);
    when(supplierService.list(Mockito.<Supplier>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Sort.Direction>any(), (String[]) any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/supplier/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(supplierAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"total\":3,\"rows\":[]}"));
  }

  /**
   * Test {@link SupplierAdminController#comboList(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SupplierAdminController#comboList(String)}
   */
  @Test
  public void testComboList_whenFoo() throws Exception {
    // Arrange
    when(supplierService.findByName(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/supplier/comboList")
        .param("q", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(supplierAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Test {@link SupplierAdminController#save(Supplier)}.
   * <p>
   * Method under test: {@link SupplierAdminController#save(Supplier)}
   */
  @Test
  public void testSave() throws Exception {
    // Arrange
    doNothing().when(logService).save(Mockito.<Log>any());
    doNothing().when(supplierService).save(Mockito.<Supplier>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/supplier/save");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(supplierAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link SupplierAdminController#delete(String)}.
   * <p>
   * Method under test: {@link SupplierAdminController#delete(String)}
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
    when(supplierService.findById(Mockito.<Integer>any())).thenReturn(supplier);
    doNothing().when(supplierService).delete(Mockito.<Integer>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/supplier/delete")
        .param("ids", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(supplierAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }
}
