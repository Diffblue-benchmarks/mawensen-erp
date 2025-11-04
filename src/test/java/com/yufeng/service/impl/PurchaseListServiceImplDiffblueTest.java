package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.Goods;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.PurchaseList;
import com.yufeng.entity.PurchaseListGoods;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
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
   * Method under test: {@link PurchaseListServiceImpl#getTodayMaxPurchaseNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String PurchaseListServiceImpl.getTodayMaxPurchaseNumber()"})
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
   * <ul>
   *   <li>Given {@link GoodsRepository}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PurchaseListServiceImpl#save(PurchaseList, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PurchaseListServiceImpl.save(PurchaseList, List)"})
  public void testSave_givenGoodsRepository_whenArrayList() {
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
   * Test {@link PurchaseListServiceImpl#save(PurchaseList, List)}.
   * <ul>
   *   <li>Given {@link GoodsType} (default constructor) Icon is {@code Icon}.</li>
   *   <li>Then calls {@link CrudRepository#findOne(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PurchaseListServiceImpl#save(PurchaseList, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PurchaseListServiceImpl.save(PurchaseList, List)"})
  public void testSave_givenGoodsTypeIconIsIcon_thenCallsFindOne() {
    // Arrange
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    Goods goods = new Goods();
    goods.setCode("Code");
    goods.setCodeOrName("Code Or Name");
    goods.setId(1);
    goods.setInventoryQuantity(1);
    goods.setLastPurchasingPrice(10.0f);
    goods.setMinNum(1);
    goods.setModel("Model");
    goods.setName("Name");
    goods.setProducer("Producer");
    goods.setPurchasingPrice(10.0f);
    goods.setRemarks("Remarks");
    goods.setSaleTotal(1);
    goods.setSellingPrice(10.0f);
    goods.setState(1);
    goods.setType(type);
    goods.setUnit("Unit");

    GoodsType type2 = new GoodsType();
    type2.setIcon("Icon");
    type2.setId(1);
    type2.setName("Name");
    type2.setState(1);
    type2.setpId(1);

    Goods goods2 = new Goods();
    goods2.setCode("Code");
    goods2.setCodeOrName("Code Or Name");
    goods2.setId(1);
    goods2.setInventoryQuantity(1);
    goods2.setLastPurchasingPrice(10.0f);
    goods2.setMinNum(1);
    goods2.setModel("Model");
    goods2.setName("Name");
    goods2.setProducer("Producer");
    goods2.setPurchasingPrice(10.0f);
    goods2.setRemarks("Remarks");
    goods2.setSaleTotal(1);
    goods2.setSellingPrice(10.0f);
    goods2.setState(1);
    goods2.setType(type2);
    goods2.setUnit("Unit");
    when(goodsRepository.save(Mockito.<Goods>any())).thenReturn(goods2);
    when(goodsRepository.findOne(Mockito.<Integer>any())).thenReturn(goods);

    GoodsType goodsType = new GoodsType();
    goodsType.setIcon("Icon");
    goodsType.setId(1);
    goodsType.setName("Name");
    goodsType.setState(1);
    goodsType.setpId(1);
    when(goodsTypeRepository.findOne(Mockito.<Integer>any())).thenReturn(goodsType);

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

    GoodsType type3 = new GoodsType();
    type3.setIcon("Icon");
    type3.setId(1);
    type3.setName("Name");
    type3.setState(1);
    type3.setpId(1);

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
    purchaseListGoods.setType(type3);
    purchaseListGoods.setTypeId(1);
    purchaseListGoods.setUnit("Unit");
    when(purchaseListGoodsRepository.save(Mockito.<PurchaseListGoods>any())).thenReturn(purchaseListGoods);

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
    when(purchaseListRepository.save(Mockito.<PurchaseList>any())).thenReturn(purchaseList2);

    Supplier supplier3 = new Supplier();
    supplier3.setAddress("42 Main St");
    supplier3.setContact("Contact");
    supplier3.setId(1);
    supplier3.setName("Name");
    supplier3.setNumber("42");
    supplier3.setRemarks("Remarks");

    User user3 = new User();
    user3.setId(1);
    user3.setPassword("iloveyou");
    user3.setRemarks("Remarks");
    user3.setRoles("Roles");
    user3.setTrueName("True Name");
    user3.setUserName("janedoe");

    PurchaseList purchaseList3 = new PurchaseList();
    purchaseList3.setAmountPaid(10.0f);
    purchaseList3.setAmountPayable(10.0f);
    purchaseList3.setId(1);
    purchaseList3
        .setPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList3.setPurchaseListGoodsList(new ArrayList<>());
    purchaseList3.setPurchaseNumber("42");
    purchaseList3.setRemarks("Remarks");
    purchaseList3.setState(1);
    purchaseList3.setSupplier(supplier3);
    purchaseList3.setUser(user3);
    purchaseList3
        .setbPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList3
        .setePurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Supplier supplier4 = new Supplier();
    supplier4.setAddress("42 Main St");
    supplier4.setContact("Contact");
    supplier4.setId(1);
    supplier4.setName("Name");
    supplier4.setNumber("42");
    supplier4.setRemarks("Remarks");

    User user4 = new User();
    user4.setId(1);
    user4.setPassword("iloveyou");
    user4.setRemarks("Remarks");
    user4.setRoles("Roles");
    user4.setTrueName("True Name");
    user4.setUserName("janedoe");

    PurchaseList purchaseList4 = new PurchaseList();
    purchaseList4.setAmountPaid(10.0f);
    purchaseList4.setAmountPayable(10.0f);
    purchaseList4.setId(1);
    purchaseList4
        .setPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList4.setPurchaseListGoodsList(new ArrayList<>());
    purchaseList4.setPurchaseNumber("42");
    purchaseList4.setRemarks("Remarks");
    purchaseList4.setState(1);
    purchaseList4.setSupplier(supplier4);
    purchaseList4.setUser(user4);
    purchaseList4
        .setbPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList4
        .setePurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type4 = new GoodsType();
    type4.setIcon("Icon");
    type4.setId(1);
    type4.setName("Name");
    type4.setState(1);
    type4.setpId(1);

    PurchaseListGoods purchaseListGoods2 = new PurchaseListGoods();
    purchaseListGoods2.setCode("Code");
    purchaseListGoods2.setCodeOrName("Code Or Name");
    purchaseListGoods2.setGoodsId(1);
    purchaseListGoods2.setId(1);
    purchaseListGoods2.setModel("Model");
    purchaseListGoods2.setName("Name");
    purchaseListGoods2.setNum(10);
    purchaseListGoods2.setPrice(10.0f);
    purchaseListGoods2.setPurchaseList(purchaseList4);
    purchaseListGoods2.setTotal(10.0f);
    purchaseListGoods2.setType(type4);
    purchaseListGoods2.setTypeId(1);
    purchaseListGoods2.setUnit("Unit");

    ArrayList<PurchaseListGoods> purchaseListGoodsList = new ArrayList<>();
    purchaseListGoodsList.add(purchaseListGoods2);

    // Act
    purchaseListServiceImpl.save(purchaseList3, purchaseListGoodsList);

    // Assert
    verify(goodsRepository).findOne(anyInt());
    verify(goodsTypeRepository).findOne(anyInt());
    verify(goodsRepository).save(isA(Goods.class));
    verify(purchaseListRepository).save(isA(PurchaseList.class));
    verify(purchaseListGoodsRepository).save(isA(PurchaseListGoods.class));
  }

  /**
   * Test {@link PurchaseListServiceImpl#list(PurchaseList, Direction, String[])}.
   * <ul>
   *   <li>Given {@link PurchaseListRepository} {@link JpaSpecificationExecutor#findAll(Specification, Sort)} return {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PurchaseListServiceImpl#list(PurchaseList, Direction, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List PurchaseListServiceImpl.list(PurchaseList, Direction, String[])"})
  public void testList_givenPurchaseListRepositoryFindAllReturnArrayList_thenReturnEmpty() {
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
    List<PurchaseList> actualListResult = purchaseListServiceImpl.list(purchaseList, Direction.ASC, "Properties");

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PurchaseListServiceImpl.delete(Integer)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PurchaseList PurchaseListServiceImpl.findById(Integer)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void PurchaseListServiceImpl.update(PurchaseList)"})
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
