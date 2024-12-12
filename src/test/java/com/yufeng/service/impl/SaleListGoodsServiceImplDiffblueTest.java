package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Customer;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.SaleList;
import com.yufeng.entity.SaleListGoods;
import com.yufeng.entity.User;
import com.yufeng.repository.SaleListGoodsRepository;
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

@ContextConfiguration(classes = {SaleListGoodsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SaleListGoodsServiceImplDiffblueTest {
  @MockBean
  private SaleListGoodsRepository saleListGoodsRepository;

  @Autowired
  private SaleListGoodsServiceImpl saleListGoodsServiceImpl;

  /**
   * Test {@link SaleListGoodsServiceImpl#listBySaleListId(Integer)}.
   * <p>
   * Method under test: {@link SaleListGoodsServiceImpl#listBySaleListId(Integer)}
   */
  @Test
  public void testListBySaleListId() {
    // Arrange
    when(saleListGoodsRepository.listBySaleListId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

    // Act
    List<SaleListGoods> actualListBySaleListIdResult = saleListGoodsServiceImpl.listBySaleListId(1);

    // Assert
    verify(saleListGoodsRepository).listBySaleListId(anyInt());
    assertTrue(actualListBySaleListIdResult.isEmpty());
  }

  /**
   * Test {@link SaleListGoodsServiceImpl#getTotalByGoodsId(Integer)}.
   * <ul>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SaleListGoodsServiceImpl#getTotalByGoodsId(Integer)}
   */
  @Test
  public void testGetTotalByGoodsId_thenReturnIntValueIsOne() {
    // Arrange
    when(saleListGoodsRepository.getTotalByGoodsId(Mockito.<Integer>any())).thenReturn(1);

    // Act
    Integer actualTotalByGoodsId = saleListGoodsServiceImpl.getTotalByGoodsId(1);

    // Assert
    verify(saleListGoodsRepository, atLeast(1)).getTotalByGoodsId(anyInt());
    assertEquals(1, actualTotalByGoodsId.intValue());
  }

  /**
   * Test {@link SaleListGoodsServiceImpl#getTotalByGoodsId(Integer)}.
   * <ul>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SaleListGoodsServiceImpl#getTotalByGoodsId(Integer)}
   */
  @Test
  public void testGetTotalByGoodsId_thenReturnIntValueIsZero() {
    // Arrange
    when(saleListGoodsRepository.getTotalByGoodsId(Mockito.<Integer>any())).thenReturn(null);

    // Act
    Integer actualTotalByGoodsId = saleListGoodsServiceImpl.getTotalByGoodsId(1);

    // Assert
    verify(saleListGoodsRepository).getTotalByGoodsId(anyInt());
    assertEquals(0, actualTotalByGoodsId.intValue());
  }

  /**
   * Test {@link SaleListGoodsServiceImpl#list(SaleListGoods)}.
   * <p>
   * Method under test: {@link SaleListGoodsServiceImpl#list(SaleListGoods)}
   */
  @Test
  public void testList() {
    // Arrange
    when(saleListGoodsRepository.findAll(Mockito.<Specification<SaleListGoods>>any())).thenReturn(new ArrayList<>());

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

    SaleList saleList = new SaleList();
    saleList.setAmountPaid(10.0f);
    saleList.setAmountPayable(10.0f);
    saleList.setCustomer(customer);
    saleList.setId(1);
    saleList.setRemarks("Remarks");
    saleList.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.setSaleListGoodsList(new ArrayList<>());
    saleList.setSaleNumber("42");
    saleList.setState(1);
    saleList.setUser(user);
    saleList.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    SaleListGoods saleListGoods = new SaleListGoods();
    saleListGoods.setCode("Code");
    saleListGoods.setCodeOrName("Code Or Name");
    saleListGoods.setGoodsId(1);
    saleListGoods.setId(1);
    saleListGoods.setModel("Model");
    saleListGoods.setName("Name");
    saleListGoods.setNum(10);
    saleListGoods.setPrice(10.0f);
    saleListGoods.setSaleList(saleList);
    saleListGoods.setTotal(10.0f);
    saleListGoods.setType(type);
    saleListGoods.setTypeId(1);
    saleListGoods.setUnit("Unit");

    // Act
    List<SaleListGoods> actualListResult = saleListGoodsServiceImpl.list(saleListGoods);

    // Assert
    verify(saleListGoodsRepository).findAll(isA(Specification.class));
    assertTrue(actualListResult.isEmpty());
  }
}
