package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Customer;
import com.yufeng.entity.CustomerReturnList;
import com.yufeng.entity.CustomerReturnListGoods;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.User;
import com.yufeng.repository.CustomerReturnListGoodsRepository;
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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomerReturnListGoodsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerReturnListGoodsServiceImplDiffblueTest {
  @MockBean
  private CustomerReturnListGoodsRepository customerReturnListGoodsRepository;

  @Autowired
  private CustomerReturnListGoodsServiceImpl customerReturnListGoodsServiceImpl;

  /**
   * Test
   * {@link CustomerReturnListGoodsServiceImpl#listByCustomerReturnListId(Integer)}.
   * <p>
   * Method under test:
   * {@link CustomerReturnListGoodsServiceImpl#listByCustomerReturnListId(Integer)}
   */
  @Test
  public void testListByCustomerReturnListId() {
    // Arrange
    when(customerReturnListGoodsRepository.listByCustomerReturnListId(Mockito.<Integer>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<CustomerReturnListGoods> actualListByCustomerReturnListIdResult = customerReturnListGoodsServiceImpl
        .listByCustomerReturnListId(1);

    // Assert
    verify(customerReturnListGoodsRepository).listByCustomerReturnListId(anyInt());
    assertTrue(actualListByCustomerReturnListIdResult.isEmpty());
  }

  /**
   * Test {@link CustomerReturnListGoodsServiceImpl#getTotalByGoodsId(Integer)}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerReturnListGoodsServiceImpl#getTotalByGoodsId(Integer)}
   */
  @Test
  public void testGetTotalByGoodsId_thenReturnIntValueIsOne() {
    // Arrange
    when(customerReturnListGoodsRepository.getTotalByGoodsId(Mockito.<Integer>any())).thenReturn(1);

    // Act
    Integer actualTotalByGoodsId = customerReturnListGoodsServiceImpl.getTotalByGoodsId(1);

    // Assert
    verify(customerReturnListGoodsRepository, atLeast(1)).getTotalByGoodsId(anyInt());
    assertEquals(1, actualTotalByGoodsId.intValue());
  }

  /**
   * Test {@link CustomerReturnListGoodsServiceImpl#getTotalByGoodsId(Integer)}.
   * <ul>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerReturnListGoodsServiceImpl#getTotalByGoodsId(Integer)}
   */
  @Test
  public void testGetTotalByGoodsId_thenReturnIntValueIsZero() {
    // Arrange
    when(customerReturnListGoodsRepository.getTotalByGoodsId(Mockito.<Integer>any())).thenReturn(null);

    // Act
    Integer actualTotalByGoodsId = customerReturnListGoodsServiceImpl.getTotalByGoodsId(1);

    // Assert
    verify(customerReturnListGoodsRepository).getTotalByGoodsId(anyInt());
    assertEquals(0, actualTotalByGoodsId.intValue());
  }

  /**
   * Test
   * {@link CustomerReturnListGoodsServiceImpl#list(CustomerReturnListGoods)}.
   * <p>
   * Method under test:
   * {@link CustomerReturnListGoodsServiceImpl#list(CustomerReturnListGoods)}
   */
  @Test
  public void testList() {
    // Arrange
    when(customerReturnListGoodsRepository.findAll(Mockito.<Specification<CustomerReturnListGoods>>any()))
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

    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    CustomerReturnListGoods customerReturnListGoods = new CustomerReturnListGoods();
    customerReturnListGoods.setCode("Code");
    customerReturnListGoods.setCodeOrName("Code Or Name");
    customerReturnListGoods.setCustomerReturnList(customerReturnList);
    customerReturnListGoods.setGoodsId(1);
    customerReturnListGoods.setId(1);
    customerReturnListGoods.setModel("Model");
    customerReturnListGoods.setName("Name");
    customerReturnListGoods.setNum(10);
    customerReturnListGoods.setPrice(10.0f);
    customerReturnListGoods.setTotal(10.0f);
    customerReturnListGoods.setType(type);
    customerReturnListGoods.setTypeId(1);
    customerReturnListGoods.setUnit("Unit");

    // Act
    List<CustomerReturnListGoods> actualListResult = customerReturnListGoodsServiceImpl.list(customerReturnListGoods);

    // Assert
    verify(customerReturnListGoodsRepository).findAll(isA(Specification.class));
    assertTrue(actualListResult.isEmpty());
  }
}
