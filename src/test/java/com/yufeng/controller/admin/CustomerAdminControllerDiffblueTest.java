package com.yufeng.controller.admin;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Customer;
import com.yufeng.entity.Log;
import com.yufeng.service.CustomerService;
import com.yufeng.service.LogService;
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

@ContextConfiguration(classes = {CustomerAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerAdminControllerDiffblueTest {
  @Autowired
  private CustomerAdminController customerAdminController;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private LogService logService;

  /**
   * Test {@link CustomerAdminController#list(Customer, Integer, Integer)}.
   * <p>
   * Method under test:
   * {@link CustomerAdminController#list(Customer, Integer, Integer)}
   */
  @Test
  public void testList() throws Exception {
    // Arrange
    when(customerService.getCount(Mockito.<Customer>any())).thenReturn(3L);
    when(customerService.list(Mockito.<Customer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Sort.Direction>any(), (String[]) any())).thenReturn(new ArrayList<>());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/customer/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"total\":3,\"rows\":[]}"));
  }

  /**
   * Test {@link CustomerAdminController#comboList(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerAdminController#comboList(String)}
   */
  @Test
  public void testComboList_whenFoo() throws Exception {
    // Arrange
    when(customerService.findByName(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/customer/comboList")
        .param("q", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Test {@link CustomerAdminController#save(Customer)}.
   * <p>
   * Method under test: {@link CustomerAdminController#save(Customer)}
   */
  @Test
  public void testSave() throws Exception {
    // Arrange
    doNothing().when(customerService).save(Mockito.<Customer>any());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/customer/save");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link CustomerAdminController#delete(String)}.
   * <p>
   * Method under test: {@link CustomerAdminController#delete(String)}
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
    when(customerService.findById(Mockito.<Integer>any())).thenReturn(customer);
    doNothing().when(customerService).delete(Mockito.<Integer>any());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/customer/delete")
        .param("ids", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(customerAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }
}
