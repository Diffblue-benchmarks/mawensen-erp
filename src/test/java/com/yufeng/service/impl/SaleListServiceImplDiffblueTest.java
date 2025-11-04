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
import com.yufeng.entity.Customer;
import com.yufeng.entity.Goods;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.SaleList;
import com.yufeng.entity.SaleListGoods;
import com.yufeng.entity.User;
import com.yufeng.repository.GoodsRepository;
import com.yufeng.repository.GoodsTypeRepository;
import com.yufeng.repository.SaleListGoodsRepository;
import com.yufeng.repository.SaleListRepository;
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

@ContextConfiguration(classes = {SaleListServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SaleListServiceImplDiffblueTest {
  @MockBean
  private GoodsRepository goodsRepository;

  @MockBean
  private GoodsTypeRepository goodsTypeRepository;

  @MockBean
  private SaleListGoodsRepository saleListGoodsRepository;

  @MockBean
  private SaleListRepository saleListRepository;

  @Autowired
  private SaleListServiceImpl saleListServiceImpl;

  /**
   * Test {@link SaleListServiceImpl#getTodayMaxSaleNumber()}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#getTodayMaxSaleNumber()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SaleListServiceImpl.getTodayMaxSaleNumber()"})
  public void testGetTodayMaxSaleNumber() {
    // Arrange
    when(saleListRepository.getTodayMaxSaleNumber()).thenReturn("42");

    // Act
    String actualTodayMaxSaleNumber = saleListServiceImpl.getTodayMaxSaleNumber();

    // Assert
    verify(saleListRepository).getTodayMaxSaleNumber();
    assertEquals("42", actualTodayMaxSaleNumber);
  }

  /**
   * Test {@link SaleListServiceImpl#save(SaleList, List)}.
   * <ul>
   *   <li>Given {@link GoodsRepository}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaleListServiceImpl#save(SaleList, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SaleListServiceImpl.save(SaleList, List)"})
  public void testSave_givenGoodsRepository_whenArrayList() {
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
    when(saleListRepository.save(Mockito.<SaleList>any())).thenReturn(saleList);

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

    SaleList saleList2 = new SaleList();
    saleList2.setAmountPaid(10.0f);
    saleList2.setAmountPayable(10.0f);
    saleList2.setCustomer(customer2);
    saleList2.setId(1);
    saleList2.setRemarks("Remarks");
    saleList2.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList2.setSaleListGoodsList(new ArrayList<>());
    saleList2.setSaleNumber("42");
    saleList2.setState(1);
    saleList2.setUser(user2);
    saleList2.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList2.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    saleListServiceImpl.save(saleList2, new ArrayList<>());

    // Assert
    verify(saleListRepository).save(isA(SaleList.class));
  }

  /**
   * Test {@link SaleListServiceImpl#save(SaleList, List)}.
   * <ul>
   *   <li>Given {@link GoodsType} (default constructor) Icon is {@code Icon}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SaleListGoods} (default constructor).</li>
   *   <li>Then calls {@link CrudRepository#findOne(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaleListServiceImpl#save(SaleList, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SaleListServiceImpl.save(SaleList, List)"})
  public void testSave_givenGoodsTypeIconIsIcon_whenArrayListAddSaleListGoods_thenCallsFindOne() {
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

    GoodsType type3 = new GoodsType();
    type3.setIcon("Icon");
    type3.setId(1);
    type3.setName("Name");
    type3.setState(1);
    type3.setpId(1);

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
    saleListGoods.setType(type3);
    saleListGoods.setTypeId(1);
    saleListGoods.setUnit("Unit");
    when(saleListGoodsRepository.save(Mockito.<SaleListGoods>any())).thenReturn(saleListGoods);

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

    SaleList saleList2 = new SaleList();
    saleList2.setAmountPaid(10.0f);
    saleList2.setAmountPayable(10.0f);
    saleList2.setCustomer(customer2);
    saleList2.setId(1);
    saleList2.setRemarks("Remarks");
    saleList2.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList2.setSaleListGoodsList(new ArrayList<>());
    saleList2.setSaleNumber("42");
    saleList2.setState(1);
    saleList2.setUser(user2);
    saleList2.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList2.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(saleListRepository.save(Mockito.<SaleList>any())).thenReturn(saleList2);

    Customer customer3 = new Customer();
    customer3.setAddress("42 Main St");
    customer3.setContact("Contact");
    customer3.setId(1);
    customer3.setName("Name");
    customer3.setNumber("42");
    customer3.setRemarks("Remarks");

    User user3 = new User();
    user3.setId(1);
    user3.setPassword("iloveyou");
    user3.setRemarks("Remarks");
    user3.setRoles("Roles");
    user3.setTrueName("True Name");
    user3.setUserName("janedoe");

    SaleList saleList3 = new SaleList();
    saleList3.setAmountPaid(10.0f);
    saleList3.setAmountPayable(10.0f);
    saleList3.setCustomer(customer3);
    saleList3.setId(1);
    saleList3.setRemarks("Remarks");
    saleList3.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList3.setSaleListGoodsList(new ArrayList<>());
    saleList3.setSaleNumber("42");
    saleList3.setState(1);
    saleList3.setUser(user3);
    saleList3.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList3.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    Customer customer4 = new Customer();
    customer4.setAddress("42 Main St");
    customer4.setContact("Contact");
    customer4.setId(1);
    customer4.setName("Name");
    customer4.setNumber("42");
    customer4.setRemarks("Remarks");

    User user4 = new User();
    user4.setId(1);
    user4.setPassword("iloveyou");
    user4.setRemarks("Remarks");
    user4.setRoles("Roles");
    user4.setTrueName("True Name");
    user4.setUserName("janedoe");

    SaleList saleList4 = new SaleList();
    saleList4.setAmountPaid(10.0f);
    saleList4.setAmountPayable(10.0f);
    saleList4.setCustomer(customer4);
    saleList4.setId(1);
    saleList4.setRemarks("Remarks");
    saleList4.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList4.setSaleListGoodsList(new ArrayList<>());
    saleList4.setSaleNumber("42");
    saleList4.setState(1);
    saleList4.setUser(user4);
    saleList4.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList4.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type4 = new GoodsType();
    type4.setIcon("Icon");
    type4.setId(1);
    type4.setName("Name");
    type4.setState(1);
    type4.setpId(1);

    SaleListGoods saleListGoods2 = new SaleListGoods();
    saleListGoods2.setCode("Code");
    saleListGoods2.setCodeOrName("Code Or Name");
    saleListGoods2.setGoodsId(1);
    saleListGoods2.setId(1);
    saleListGoods2.setModel("Model");
    saleListGoods2.setName("Name");
    saleListGoods2.setNum(10);
    saleListGoods2.setPrice(10.0f);
    saleListGoods2.setSaleList(saleList4);
    saleListGoods2.setTotal(10.0f);
    saleListGoods2.setType(type4);
    saleListGoods2.setTypeId(1);
    saleListGoods2.setUnit("Unit");

    ArrayList<SaleListGoods> saleListGoodsList = new ArrayList<>();
    saleListGoodsList.add(saleListGoods2);

    // Act
    saleListServiceImpl.save(saleList3, saleListGoodsList);

    // Assert
    verify(goodsRepository).findOne(anyInt());
    verify(goodsTypeRepository).findOne(anyInt());
    verify(goodsRepository).save(isA(Goods.class));
    verify(saleListRepository).save(isA(SaleList.class));
    verify(saleListGoodsRepository).save(isA(SaleListGoods.class));
  }

  /**
   * Test {@link SaleListServiceImpl#list(SaleList, Direction, String[])}.
   * <ul>
   *   <li>Given {@link SaleListRepository} {@link JpaSpecificationExecutor#findAll(Specification, Sort)} return {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@code ASC}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaleListServiceImpl#list(SaleList, Direction, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SaleListServiceImpl.list(SaleList, Direction, String[])"})
  public void testList_givenSaleListRepositoryFindAllReturnArrayList_whenAsc_thenReturnEmpty() {
    // Arrange
    when(saleListRepository.findAll(Mockito.<Specification<SaleList>>any(), Mockito.<Sort>any()))
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

    // Act
    List<SaleList> actualListResult = saleListServiceImpl.list(saleList, Direction.ASC, "Properties");

    // Assert
    verify(saleListRepository).findAll(isA(Specification.class), isA(Sort.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link SaleListServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#delete(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SaleListServiceImpl.delete(Integer)"})
  public void testDelete() {
    // Arrange
    doNothing().when(saleListGoodsRepository).deleteBySaleListId(Mockito.<Integer>any());
    doNothing().when(saleListRepository).delete(Mockito.<Integer>any());

    // Act
    saleListServiceImpl.delete(1);

    // Assert
    verify(saleListGoodsRepository).deleteBySaleListId(anyInt());
    verify(saleListRepository).delete(anyInt());
  }

  /**
   * Test {@link SaleListServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#findById(Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SaleList SaleListServiceImpl.findById(Integer)"})
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
    when(saleListRepository.findOne(Mockito.<Integer>any())).thenReturn(saleList);

    // Act
    SaleList actualFindByIdResult = saleListServiceImpl.findById(1);

    // Assert
    verify(saleListRepository).findOne(anyInt());
    assertSame(saleList, actualFindByIdResult);
  }

  /**
   * Test {@link SaleListServiceImpl#update(SaleList)}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#update(SaleList)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SaleListServiceImpl.update(SaleList)"})
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
    when(saleListRepository.save(Mockito.<SaleList>any())).thenReturn(saleList);

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

    SaleList saleList2 = new SaleList();
    saleList2.setAmountPaid(10.0f);
    saleList2.setAmountPayable(10.0f);
    saleList2.setCustomer(customer2);
    saleList2.setId(1);
    saleList2.setRemarks("Remarks");
    saleList2.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList2.setSaleListGoodsList(new ArrayList<>());
    saleList2.setSaleNumber("42");
    saleList2.setState(1);
    saleList2.setUser(user2);
    saleList2.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList2.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    saleListServiceImpl.update(saleList2);

    // Assert
    verify(saleListRepository).save(isA(SaleList.class));
  }

  /**
   * Test {@link SaleListServiceImpl#countSaleByDay(String, String)}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#countSaleByDay(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SaleListServiceImpl.countSaleByDay(String, String)"})
  public void testCountSaleByDay() {
    // Arrange
    when(saleListRepository.countSaleByDay(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Object> actualCountSaleByDayResult = saleListServiceImpl.countSaleByDay("Begin", "End");

    // Assert
    verify(saleListRepository).countSaleByDay(Mockito.<String>any(), Mockito.<String>any());
    assertTrue(actualCountSaleByDayResult.isEmpty());
  }

  /**
   * Test {@link SaleListServiceImpl#countSaleByMonth(String, String)}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#countSaleByMonth(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SaleListServiceImpl.countSaleByMonth(String, String)"})
  public void testCountSaleByMonth() {
    // Arrange
    when(saleListRepository.countSaleByMonth(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Object> actualCountSaleByMonthResult = saleListServiceImpl.countSaleByMonth("Begin", "End");

    // Assert
    verify(saleListRepository).countSaleByMonth(Mockito.<String>any(), Mockito.<String>any());
    assertTrue(actualCountSaleByMonthResult.isEmpty());
  }
}
