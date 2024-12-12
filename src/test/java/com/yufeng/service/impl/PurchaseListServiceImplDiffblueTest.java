package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.PurchaseList;
import com.yufeng.entity.Supplier;
import com.yufeng.entity.User;
import com.yufeng.repository.GoodsRepository;
import com.yufeng.repository.GoodsTypeRepository;
import com.yufeng.repository.PurchaseListGoodsRepository;
import com.yufeng.repository.PurchaseListRepository;
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

@ContextConfiguration(classes = {PurchaseListServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PurchaseListServiceImplDiffblueTest {
  @MockBean
  private GoodsRepository goodsRepository;

  @MockBean
  private GoodsTypeRepository goodsTypeRepository;

  @MockBean
  private PurchaseListGoodsRepository purchaseListGoodsRepository;

  @MockBean
  private PurchaseListRepository purchaseListRepository;

  @Autowired
  private PurchaseListServiceImpl purchaseListServiceImpl;

  /**
   * Test {@link PurchaseListServiceImpl#getTodayMaxPurchaseNumber()}.
   * <p>
   * Method under test:
   * {@link PurchaseListServiceImpl#getTodayMaxPurchaseNumber()}
   */
  @Test
  public void testGetTodayMaxPurchaseNumber() {
    // Arrange
    when(purchaseListRepository.getTodayMaxPurchaseNumber()).thenReturn("42");

    // Act
    String actualTodayMaxPurchaseNumber = purchaseListServiceImpl.getTodayMaxPurchaseNumber();

    // Assert
    verify(purchaseListRepository).getTodayMaxPurchaseNumber();
    assertEquals("42", actualTodayMaxPurchaseNumber);
  }

  /**
   * Test {@link PurchaseListServiceImpl#save(PurchaseList, List)}.
   * <p>
   * Method under test: {@link PurchaseListServiceImpl#save(PurchaseList, List)}
   */
  @Test
  public void testSave() {
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
    when(purchaseListRepository.save(Mockito.<PurchaseList>any())).thenReturn(purchaseList);

    Supplier supplier2 = new Supplier();
    supplier2.setAddress("42 Main St");
    supplier2.setContact("Contact");
    supplier2.setId(1);
    supplier2.setName("Name");
    supplier2.setNumber("42");
    supplier2.setRemarks("Remarks");

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    PurchaseList purchaseList2 = new PurchaseList();
    purchaseList2.setAmountPaid(10.0f);
    purchaseList2.setAmountPayable(10.0f);
    purchaseList2.setId(1);
    purchaseList2
        .setPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList2.setPurchaseListGoodsList(new ArrayList<>());
    purchaseList2.setPurchaseNumber("42");
    purchaseList2.setRemarks("Remarks");
    purchaseList2.setState(1);
    purchaseList2.setSupplier(supplier2);
    purchaseList2.setUser(user2);
    purchaseList2
        .setbPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList2
        .setePurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    purchaseListServiceImpl.save(purchaseList2, new ArrayList<>());

    // Assert
    verify(purchaseListRepository).save(isA(PurchaseList.class));
  }

  /**
   * Test {@link PurchaseListServiceImpl#list(PurchaseList, Direction, String[])}.
   * <ul>
   *   <li>When {@code Properties}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PurchaseListServiceImpl#list(PurchaseList, Sort.Direction, String[])}
   */
  @Test
  public void testList_whenProperties_thenReturnEmpty() {
    // Arrange
    when(purchaseListRepository.findAll(Mockito.<Specification<PurchaseList>>any(), Mockito.<Sort>any()))
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

    // Act
    List<PurchaseList> actualListResult = purchaseListServiceImpl.list(purchaseList, Sort.Direction.ASC, "Properties");

    // Assert
    verify(purchaseListRepository).findAll(isA(Specification.class), isA(Sort.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link PurchaseListServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link PurchaseListServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(purchaseListGoodsRepository).deleteByPurchaseListId(Mockito.<Integer>any());
    doNothing().when(purchaseListRepository).delete(Mockito.<Integer>any());

    // Act
    purchaseListServiceImpl.delete(1);

    // Assert
    verify(purchaseListGoodsRepository).deleteByPurchaseListId(anyInt());
    verify(purchaseListRepository).delete(anyInt());
  }

  /**
   * Test {@link PurchaseListServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link PurchaseListServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
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
    when(purchaseListRepository.findOne(Mockito.<Integer>any())).thenReturn(purchaseList);

    // Act
    PurchaseList actualFindByIdResult = purchaseListServiceImpl.findById(1);

    // Assert
    verify(purchaseListRepository).findOne(anyInt());
    assertSame(purchaseList, actualFindByIdResult);
  }

  /**
   * Test {@link PurchaseListServiceImpl#update(PurchaseList)}.
   * <p>
   * Method under test: {@link PurchaseListServiceImpl#update(PurchaseList)}
   */
  @Test
  public void testUpdate() {
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
    when(purchaseListRepository.save(Mockito.<PurchaseList>any())).thenReturn(purchaseList);

    Supplier supplier2 = new Supplier();
    supplier2.setAddress("42 Main St");
    supplier2.setContact("Contact");
    supplier2.setId(1);
    supplier2.setName("Name");
    supplier2.setNumber("42");
    supplier2.setRemarks("Remarks");

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    PurchaseList purchaseList2 = new PurchaseList();
    purchaseList2.setAmountPaid(10.0f);
    purchaseList2.setAmountPayable(10.0f);
    purchaseList2.setId(1);
    purchaseList2
        .setPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList2.setPurchaseListGoodsList(new ArrayList<>());
    purchaseList2.setPurchaseNumber("42");
    purchaseList2.setRemarks("Remarks");
    purchaseList2.setState(1);
    purchaseList2.setSupplier(supplier2);
    purchaseList2.setUser(user2);
    purchaseList2
        .setbPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList2
        .setePurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    purchaseListServiceImpl.update(purchaseList2);

    // Assert
    verify(purchaseListRepository).save(isA(PurchaseList.class));
  }
}
