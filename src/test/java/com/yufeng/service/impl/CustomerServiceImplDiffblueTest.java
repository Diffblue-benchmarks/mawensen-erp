package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Customer;
import com.yufeng.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomerServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplDiffblueTest {
  @MockBean
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerServiceImpl customerServiceImpl;

  /**
   * Test {@link CustomerServiceImpl#save(Customer)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#save(Customer)}
   */
  @Test
  public void testSave() {
    // Arrange
    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");
    when(customerRepository.save(Mockito.<Customer>any())).thenReturn(customer);

    Customer customer2 = new Customer();
    customer2.setAddress("42 Main St");
    customer2.setContact("Contact");
    customer2.setId(1);
    customer2.setName("Name");
    customer2.setNumber("42");
    customer2.setRemarks("Remarks");

    // Act
    customerServiceImpl.save(customer2);

    // Assert
    verify(customerRepository).save(isA(Customer.class));
  }

  /**
   * Test
   * {@link CustomerServiceImpl#list(Customer, Integer, Integer, Direction, String[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerServiceImpl#list(Customer, Integer, Integer, Sort.Direction, String[])}
   */
  @Test
  public void testList_thenReturnEmpty() {
    // Arrange
    when(customerRepository.findAll(Mockito.<Specification<Customer>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");

    // Act
    List<Customer> actualListResult = customerServiceImpl.list(customer, 1, 3, Sort.Direction.ASC, "Properties");

    // Assert
    verify(customerRepository).findAll(isA(Specification.class), isA(Pageable.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link CustomerServiceImpl#getCount(Customer)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#getCount(Customer)}
   */
  @Test
  public void testGetCount() {
    // Arrange
    when(customerRepository.count(Mockito.<Specification<Customer>>any())).thenReturn(3L);

    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");

    // Act
    Long actualCount = customerServiceImpl.getCount(customer);

    // Assert
    verify(customerRepository).count(isA(Specification.class));
    assertEquals(3L, actualCount.longValue());
  }

  /**
   * Test {@link CustomerServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(customerRepository).delete(Mockito.<Integer>any());

    // Act
    customerServiceImpl.delete(1);

    // Assert
    verify(customerRepository).delete(anyInt());
  }

  /**
   * Test {@link CustomerServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
    // Arrange
    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");
    when(customerRepository.findOne(Mockito.<Integer>any())).thenReturn(customer);

    // Act
    Customer actualFindByIdResult = customerServiceImpl.findById(1);

    // Assert
    verify(customerRepository).findOne(anyInt());
    assertSame(customer, actualFindByIdResult);
  }

  /**
   * Test {@link CustomerServiceImpl#findByName(String)}.
   * <p>
   * Method under test: {@link CustomerServiceImpl#findByName(String)}
   */
  @Test
  public void testFindByName() {
    // Arrange
    when(customerRepository.findByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Customer> actualFindByNameResult = customerServiceImpl.findByName("Name");

    // Assert
    verify(customerRepository).findByName(Mockito.<String>any());
    assertTrue(actualFindByNameResult.isEmpty());
  }
}
