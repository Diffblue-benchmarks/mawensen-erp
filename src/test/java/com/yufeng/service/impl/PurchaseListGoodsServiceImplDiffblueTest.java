package com.yufeng.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.PurchaseList;
import com.yufeng.entity.PurchaseListGoods;
import com.yufeng.entity.Supplier;
import com.yufeng.entity.User;
import com.yufeng.repository.PurchaseListGoodsRepository;
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

@ContextConfiguration(classes = {PurchaseListGoodsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PurchaseListGoodsServiceImplDiffblueTest {
  @MockBean
  private PurchaseListGoodsRepository purchaseListGoodsRepository;

  @Autowired
  private PurchaseListGoodsServiceImpl purchaseListGoodsServiceImpl;

  /**
   * Test {@link PurchaseListGoodsServiceImpl#listByPurchaseListId(Integer)}.
   * <p>
   * Method under test:
   * {@link PurchaseListGoodsServiceImpl#listByPurchaseListId(Integer)}
   */
  @Test
  public void testListByPurchaseListId() {
    // Arrange
    when(purchaseListGoodsRepository.listByPurchaseListId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

    // Act
    List<PurchaseListGoods> actualListByPurchaseListIdResult = purchaseListGoodsServiceImpl.listByPurchaseListId(1);

    // Assert
    verify(purchaseListGoodsRepository).listByPurchaseListId(anyInt());
    assertTrue(actualListByPurchaseListIdResult.isEmpty());
  }

  /**
   * Test {@link PurchaseListGoodsServiceImpl#list(PurchaseListGoods)}.
   * <p>
   * Method under test:
   * {@link PurchaseListGoodsServiceImpl#list(PurchaseListGoods)}
   */
  @Test
  public void testList() {
    // Arrange
    when(purchaseListGoodsRepository.findAll(Mockito.<Specification<PurchaseListGoods>>any()))
        .thenReturn(new ArrayList<>());

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

    PurchaseList purchaseList = new PurchaseList();
    purchaseList.setAmountPaid(10.0f);
    purchaseList.setAmountPayable(10.0f);
    purchaseList.setId(1);
    purchaseList.setPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList.setPurchaseListGoodsList(new ArrayList<>());
    purchaseList.setPurchaseNumber("42");
    purchaseList.setRemarks("Remarks");
    purchaseList.setState(1);
    purchaseList.setSupplier(supplier);
    purchaseList.setUser(user);
    purchaseList
        .setbPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList
        .setePurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    PurchaseListGoods purchaseListGoods = new PurchaseListGoods();
    purchaseListGoods.setCode("Code");
    purchaseListGoods.setCodeOrName("Code Or Name");
    purchaseListGoods.setGoodsId(1);
    purchaseListGoods.setId(1);
    purchaseListGoods.setModel("Model");
    purchaseListGoods.setName("Name");
    purchaseListGoods.setNum(10);
    purchaseListGoods.setPrice(10.0f);
    purchaseListGoods.setPurchaseList(purchaseList);
    purchaseListGoods.setTotal(10.0f);
    purchaseListGoods.setType(type);
    purchaseListGoods.setTypeId(1);
    purchaseListGoods.setUnit("Unit");

    // Act
    List<PurchaseListGoods> actualListResult = purchaseListGoodsServiceImpl.list(purchaseListGoods);

    // Assert
    verify(purchaseListGoodsRepository).findAll(isA(Specification.class));
    assertTrue(actualListResult.isEmpty());
  }
}
