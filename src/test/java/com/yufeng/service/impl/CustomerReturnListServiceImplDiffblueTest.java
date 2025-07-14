package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.Customer;
import com.yufeng.entity.CustomerReturnList;
import com.yufeng.entity.CustomerReturnListGoods;
import com.yufeng.entity.Goods;
import com.yufeng.entity.GoodsType;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {CustomerReturnListServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerReturnListServiceImplDiffblueTest {
  @MockBean private CustomerReturnListGoodsRepository customerReturnListGoodsRepository;

  @MockBean private CustomerReturnListRepository customerReturnListRepository;

  @Autowired private CustomerReturnListServiceImpl customerReturnListServiceImpl;

  @MockBean private GoodsRepository goodsRepository;

  @MockBean private GoodsTypeRepository goodsTypeRepository;

  /**
   * Test {@link CustomerReturnListServiceImpl#getTodayMaxCustomerReturnNumber()}.
   *
   * <p>Method under test: {@link CustomerReturnListServiceImpl#getTodayMaxCustomerReturnNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CustomerReturnListServiceImpl.getTodayMaxCustomerReturnNumber()"})
  public void testGetTodayMaxCustomerReturnNumber() {
    // Arrange
    when(customerReturnListRepository.getTodayMaxCustomerReturnNumber()).thenReturn("42");

    // Act
    String actualTodayMaxCustomerReturnNumber =
        customerReturnListServiceImpl.getTodayMaxCustomerReturnNumber();

    // Assert
    verify(customerReturnListRepository).getTodayMaxCustomerReturnNumber();
    assertEquals("42", actualTodayMaxCustomerReturnNumber);
  }

  /**
   * Test {@link CustomerReturnListServiceImpl#save(CustomerReturnList, List)}.
   *
   * <ul>
   *   <li>Given {@link CustomerReturnListGoodsRepository}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerReturnListServiceImpl#save(CustomerReturnList, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerReturnListServiceImpl.save(CustomerReturnList, List)"})
  public void testSave_givenCustomerReturnListGoodsRepository_whenArrayList() {
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
    customerReturnList.setCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList.setCustomerReturnNumber("42");
    customerReturnList.setId(1);
    customerReturnList.setRemarks("Remarks");
    customerReturnList.setState(1);
    customerReturnList.setUser(user);
    customerReturnList.setbCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.seteCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(customerReturnListRepository.save(Mockito.<CustomerReturnList>any()))
        .thenReturn(customerReturnList);

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
    customerReturnList2.setCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList2.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList2.setCustomerReturnNumber("42");
    customerReturnList2.setId(1);
    customerReturnList2.setRemarks("Remarks");
    customerReturnList2.setState(1);
    customerReturnList2.setUser(user2);
    customerReturnList2.setbCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList2.seteCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    customerReturnListServiceImpl.save(customerReturnList2, new ArrayList<>());

    // Assert
    verify(customerReturnListRepository).save(isA(CustomerReturnList.class));
  }

  /**
   * Test {@link CustomerReturnListServiceImpl#save(CustomerReturnList, List)}.
   *
   * <ul>
   *   <li>Given {@link GoodsType} (default constructor) Icon is {@code Icon}.
   *   <li>Then calls {@link GoodsRepository#findOne(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerReturnListServiceImpl#save(CustomerReturnList, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerReturnListServiceImpl.save(CustomerReturnList, List)"})
  public void testSave_givenGoodsTypeIconIsIcon_thenCallsFindOne() {
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
    customerReturnList.setCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList.setCustomerReturnNumber("42");
    customerReturnList.setId(1);
    customerReturnList.setRemarks("Remarks");
    customerReturnList.setState(1);
    customerReturnList.setUser(user);
    customerReturnList.setbCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.seteCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

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
    when(customerReturnListGoodsRepository.save(Mockito.<CustomerReturnListGoods>any()))
        .thenReturn(customerReturnListGoods);

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
    customerReturnList2.setCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList2.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList2.setCustomerReturnNumber("42");
    customerReturnList2.setId(1);
    customerReturnList2.setRemarks("Remarks");
    customerReturnList2.setState(1);
    customerReturnList2.setUser(user2);
    customerReturnList2.setbCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList2.seteCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(customerReturnListRepository.save(Mockito.<CustomerReturnList>any()))
        .thenReturn(customerReturnList2);

    GoodsType type2 = new GoodsType();
    type2.setIcon("Icon");
    type2.setId(1);
    type2.setName("Name");
    type2.setState(1);
    type2.setpId(1);

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
    goods.setType(type2);
    goods.setUnit("Unit");

    GoodsType type3 = new GoodsType();
    type3.setIcon("Icon");
    type3.setId(1);
    type3.setName("Name");
    type3.setState(1);
    type3.setpId(1);

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
    goods2.setType(type3);
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

    CustomerReturnList customerReturnList3 = new CustomerReturnList();
    customerReturnList3.setAmountPaid(10.0f);
    customerReturnList3.setAmountPayable(10.0f);
    customerReturnList3.setCustomer(customer3);
    customerReturnList3.setCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList3.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList3.setCustomerReturnNumber("42");
    customerReturnList3.setId(1);
    customerReturnList3.setRemarks("Remarks");
    customerReturnList3.setState(1);
    customerReturnList3.setUser(user3);
    customerReturnList3.setbCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList3.seteCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

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

    CustomerReturnList customerReturnList4 = new CustomerReturnList();
    customerReturnList4.setAmountPaid(10.0f);
    customerReturnList4.setAmountPayable(10.0f);
    customerReturnList4.setCustomer(customer4);
    customerReturnList4.setCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList4.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList4.setCustomerReturnNumber("42");
    customerReturnList4.setId(1);
    customerReturnList4.setRemarks("Remarks");
    customerReturnList4.setState(1);
    customerReturnList4.setUser(user4);
    customerReturnList4.setbCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList4.seteCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type4 = new GoodsType();
    type4.setIcon("Icon");
    type4.setId(1);
    type4.setName("Name");
    type4.setState(1);
    type4.setpId(1);

    CustomerReturnListGoods customerReturnListGoods2 = new CustomerReturnListGoods();
    customerReturnListGoods2.setCode("Code");
    customerReturnListGoods2.setCodeOrName("Code Or Name");
    customerReturnListGoods2.setCustomerReturnList(customerReturnList4);
    customerReturnListGoods2.setGoodsId(1);
    customerReturnListGoods2.setId(1);
    customerReturnListGoods2.setModel("Model");
    customerReturnListGoods2.setName("Name");
    customerReturnListGoods2.setNum(10);
    customerReturnListGoods2.setPrice(10.0f);
    customerReturnListGoods2.setTotal(10.0f);
    customerReturnListGoods2.setType(type4);
    customerReturnListGoods2.setTypeId(1);
    customerReturnListGoods2.setUnit("Unit");

    ArrayList<CustomerReturnListGoods> customerReturnListGoodsList = new ArrayList<>();
    customerReturnListGoodsList.add(customerReturnListGoods2);

    // Act
    customerReturnListServiceImpl.save(customerReturnList3, customerReturnListGoodsList);

    // Assert
    verify(goodsRepository).findOne(anyInt());
    verify(goodsTypeRepository).findOne(anyInt());
    verify(customerReturnListRepository).save(isA(CustomerReturnList.class));
    verify(customerReturnListGoodsRepository).save(isA(CustomerReturnListGoods.class));
    verify(goodsRepository).save(isA(Goods.class));
  }

  /**
   * Test {@link CustomerReturnListServiceImpl#list(CustomerReturnList, Direction, String[])}.
   *
   * <ul>
   *   <li>Given {@link CustomerReturnListRepository} {@link
   *       CustomerReturnListRepository#findAll(Specification, Sort)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CustomerReturnListServiceImpl#list(CustomerReturnList, Direction,
   * String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CustomerReturnListServiceImpl.list(CustomerReturnList, Direction, String[])"
  })
  public void testList_givenCustomerReturnListRepositoryFindAllReturnArrayList_thenReturnEmpty() {
    // Arrange
    when(customerReturnListRepository.findAll(
            Mockito.<Specification<CustomerReturnList>>any(), Mockito.<Sort>any()))
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
    customerReturnList.setCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList.setCustomerReturnNumber("42");
    customerReturnList.setId(1);
    customerReturnList.setRemarks("Remarks");
    customerReturnList.setState(1);
    customerReturnList.setUser(user);
    customerReturnList.setbCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.seteCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    List<CustomerReturnList> actualListResult =
        customerReturnListServiceImpl.list(customerReturnList, Direction.ASC, "Properties");

    // Assert
    verify(customerReturnListRepository).findAll(isA(Specification.class), isA(Sort.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link CustomerReturnListServiceImpl#delete(Integer)}.
   *
   * <p>Method under test: {@link CustomerReturnListServiceImpl#delete(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerReturnListServiceImpl.delete(Integer)"})
  public void testDelete() {
    // Arrange
    doNothing()
        .when(customerReturnListGoodsRepository)
        .deleteByCustomerReturnListId(Mockito.<Integer>any());
    doNothing().when(customerReturnListRepository).delete(Mockito.<Integer>any());

    // Act
    customerReturnListServiceImpl.delete(1);

    // Assert
    verify(customerReturnListGoodsRepository).deleteByCustomerReturnListId(anyInt());
    verify(customerReturnListRepository).delete(anyInt());
  }

  /**
   * Test {@link CustomerReturnListServiceImpl#findById(Integer)}.
   *
   * <p>Method under test: {@link CustomerReturnListServiceImpl#findById(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerReturnList CustomerReturnListServiceImpl.findById(Integer)"})
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
    customerReturnList.setCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList.setCustomerReturnNumber("42");
    customerReturnList.setId(1);
    customerReturnList.setRemarks("Remarks");
    customerReturnList.setState(1);
    customerReturnList.setUser(user);
    customerReturnList.setbCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.seteCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(customerReturnListRepository.findOne(Mockito.<Integer>any()))
        .thenReturn(customerReturnList);

    // Act
    CustomerReturnList actualFindByIdResult = customerReturnListServiceImpl.findById(1);

    // Assert
    verify(customerReturnListRepository).findOne(anyInt());
    assertSame(customerReturnList, actualFindByIdResult);
  }

  /**
   * Test {@link CustomerReturnListServiceImpl#update(CustomerReturnList)}.
   *
   * <p>Method under test: {@link CustomerReturnListServiceImpl#update(CustomerReturnList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerReturnListServiceImpl.update(CustomerReturnList)"})
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
    customerReturnList.setCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList.setCustomerReturnNumber("42");
    customerReturnList.setId(1);
    customerReturnList.setRemarks("Remarks");
    customerReturnList.setState(1);
    customerReturnList.setUser(user);
    customerReturnList.setbCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.seteCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(customerReturnListRepository.save(Mockito.<CustomerReturnList>any()))
        .thenReturn(customerReturnList);

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
    customerReturnList2.setCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList2.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList2.setCustomerReturnNumber("42");
    customerReturnList2.setId(1);
    customerReturnList2.setRemarks("Remarks");
    customerReturnList2.setState(1);
    customerReturnList2.setUser(user2);
    customerReturnList2.setbCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList2.seteCustomerReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    customerReturnListServiceImpl.update(customerReturnList2);

    // Assert
    verify(customerReturnListRepository).save(isA(CustomerReturnList.class));
  }
}
