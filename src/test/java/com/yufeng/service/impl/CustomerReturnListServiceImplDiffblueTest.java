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
import com.yufeng.entity.CustomerReturnList;
import com.yufeng.entity.User;
import com.yufeng.repository.CustomerReturnListGoodsRepository;
import com.yufeng.repository.CustomerReturnListRepository;
import com.yufeng.repository.GoodsRepository;
import com.yufeng.repository.GoodsTypeRepository;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomerReturnListServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerReturnListServiceImplDiffblueTest {
  @MockBean
  private CustomerReturnListGoodsRepository customerReturnListGoodsRepository;

  @MockBean
  private CustomerReturnListRepository customerReturnListRepository;

  @Autowired
  private CustomerReturnListServiceImpl customerReturnListServiceImpl;

  @MockBean
  private GoodsRepository goodsRepository;

  @MockBean
  private GoodsTypeRepository goodsTypeRepository;

  /**
   * Test {@link CustomerReturnListServiceImpl#getTodayMaxCustomerReturnNumber()}.
   * <p>
   * Method under test:
   * {@link CustomerReturnListServiceImpl#getTodayMaxCustomerReturnNumber()}
   */
  @Test
  public void testGetTodayMaxCustomerReturnNumber() {
    // Arrange
    when(customerReturnListRepository.getTodayMaxCustomerReturnNumber()).thenReturn("42");

    // Act
    String actualTodayMaxCustomerReturnNumber = customerReturnListServiceImpl.getTodayMaxCustomerReturnNumber();

    // Assert
    verify(customerReturnListRepository).getTodayMaxCustomerReturnNumber();
    assertEquals("42", actualTodayMaxCustomerReturnNumber);
  }

  /**
   * Test {@link CustomerReturnListServiceImpl#save(CustomerReturnList, List)}.
   * <p>
   * Method under test:
   * {@link CustomerReturnListServiceImpl#save(CustomerReturnList, List)}
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
    when(customerReturnListRepository.save(Mockito.<CustomerReturnList>any())).thenReturn(customerReturnList);

    Customer customer2 = new Customer();
    customer2.setAddress("42 Main St");
    customer2.setContact("Contact");
    customer2.setId(1);
    customer2.setName("Name");
    customer2.setNumber("42");
    customer2.setRemarks("Remarks");

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    CustomerReturnList customerReturnList2 = new CustomerReturnList();
    customerReturnList2.setAmountPaid(10.0f);
    customerReturnList2.setAmountPayable(10.0f);
    customerReturnList2.setCustomer(customer2);
    customerReturnList2
        .setCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList2.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList2.setCustomerReturnNumber("42");
    customerReturnList2.setId(1);
    customerReturnList2.setRemarks("Remarks");
    customerReturnList2.setState(1);
    customerReturnList2.setUser(user2);
    customerReturnList2
        .setbCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList2
        .seteCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    customerReturnListServiceImpl.save(customerReturnList2, new ArrayList<>());

    // Assert
    verify(customerReturnListRepository).save(isA(CustomerReturnList.class));
  }

  /**
   * Test
   * {@link CustomerReturnListServiceImpl#list(CustomerReturnList, Direction, String[])}.
   * <ul>
   *   <li>When {@code Properties}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerReturnListServiceImpl#list(CustomerReturnList, Sort.Direction, String[])}
   */
  @Test
  public void testList_whenProperties_thenReturnEmpty() {
    // Arrange
    when(customerReturnListRepository.findAll(Mockito.<Specification<CustomerReturnList>>any(), Mockito.<Sort>any()))
        .thenReturn(new ArrayList<>());

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

    // Act
    List<CustomerReturnList> actualListResult = customerReturnListServiceImpl.list(customerReturnList,
        Sort.Direction.ASC, "Properties");

    // Assert
    verify(customerReturnListRepository).findAll(isA(Specification.class), isA(Sort.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link CustomerReturnListServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link CustomerReturnListServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(customerReturnListGoodsRepository).deleteByCustomerReturnListId(Mockito.<Integer>any());
    doNothing().when(customerReturnListRepository).delete(Mockito.<Integer>any());

    // Act
    customerReturnListServiceImpl.delete(1);

    // Assert
    verify(customerReturnListGoodsRepository).deleteByCustomerReturnListId(anyInt());
    verify(customerReturnListRepository).delete(anyInt());
  }

  /**
   * Test {@link CustomerReturnListServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link CustomerReturnListServiceImpl#findById(Integer)}
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
    when(customerReturnListRepository.findOne(Mockito.<Integer>any())).thenReturn(customerReturnList);

    // Act
    CustomerReturnList actualFindByIdResult = customerReturnListServiceImpl.findById(1);

    // Assert
    verify(customerReturnListRepository).findOne(anyInt());
    assertSame(customerReturnList, actualFindByIdResult);
  }

  /**
   * Test {@link CustomerReturnListServiceImpl#update(CustomerReturnList)}.
   * <p>
   * Method under test:
   * {@link CustomerReturnListServiceImpl#update(CustomerReturnList)}
   */
  @Test
  public void testUpdate() {
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
    when(customerReturnListRepository.save(Mockito.<CustomerReturnList>any())).thenReturn(customerReturnList);

    Customer customer2 = new Customer();
    customer2.setAddress("42 Main St");
    customer2.setContact("Contact");
    customer2.setId(1);
    customer2.setName("Name");
    customer2.setNumber("42");
    customer2.setRemarks("Remarks");

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    CustomerReturnList customerReturnList2 = new CustomerReturnList();
    customerReturnList2.setAmountPaid(10.0f);
    customerReturnList2.setAmountPayable(10.0f);
    customerReturnList2.setCustomer(customer2);
    customerReturnList2
        .setCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList2.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList2.setCustomerReturnNumber("42");
    customerReturnList2.setId(1);
    customerReturnList2.setRemarks("Remarks");
    customerReturnList2.setState(1);
    customerReturnList2.setUser(user2);
    customerReturnList2
        .setbCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList2
        .seteCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    customerReturnListServiceImpl.update(customerReturnList2);

    // Assert
    verify(customerReturnListRepository).save(isA(CustomerReturnList.class));
  }
}
