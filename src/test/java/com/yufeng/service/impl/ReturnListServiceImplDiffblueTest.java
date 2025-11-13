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
import com.yufeng.entity.Goods;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.ReturnList;
import com.yufeng.entity.ReturnListGoods;
import com.yufeng.entity.Supplier;
import com.yufeng.entity.User;
import com.yufeng.repository.GoodsRepository;
import com.yufeng.repository.GoodsTypeRepository;
import com.yufeng.repository.ReturnListGoodsRepository;
import com.yufeng.repository.ReturnListRepository;
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

@ContextConfiguration(classes = {ReturnListServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ReturnListServiceImplDiffblueTest {
  @MockBean private GoodsRepository goodsRepository;

  @MockBean private GoodsTypeRepository goodsTypeRepository;

  @MockBean private ReturnListGoodsRepository returnListGoodsRepository;

  @MockBean private ReturnListRepository returnListRepository;

  @Autowired private ReturnListServiceImpl returnListServiceImpl;

  /**
   * Test {@link ReturnListServiceImpl#getTodayMaxReturnNumber()}.
   *
   * <p>Method under test: {@link ReturnListServiceImpl#getTodayMaxReturnNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ReturnListServiceImpl.getTodayMaxReturnNumber()"})
  public void testGetTodayMaxReturnNumber() {
    // Arrange
    when(returnListRepository.getTodayMaxReturnNumber()).thenReturn("42");

    // Act
    String actualTodayMaxReturnNumber = returnListServiceImpl.getTodayMaxReturnNumber();

    // Assert
    verify(returnListRepository).getTodayMaxReturnNumber();
    assertEquals("42", actualTodayMaxReturnNumber);
  }

  /**
   * Test {@link ReturnListServiceImpl#save(ReturnList, List)}.
   *
   * <ul>
   *   <li>Given {@link GoodsRepository}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ReturnListServiceImpl#save(ReturnList, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReturnListServiceImpl.save(ReturnList, List)"})
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

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(returnListRepository.save(Mockito.<ReturnList>any())).thenReturn(returnList);

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

    ReturnList returnList2 = new ReturnList();
    returnList2.setAmountPaid(10.0f);
    returnList2.setAmountPayable(10.0f);
    returnList2.setId(1);
    returnList2.setRemarks("Remarks");
    returnList2.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList2.setReturnListGoodsList(new ArrayList<>());
    returnList2.setReturnNumber("42");
    returnList2.setState(1);
    returnList2.setSupplier(supplier2);
    returnList2.setUser(user2);
    returnList2.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList2.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    returnListServiceImpl.save(returnList2, new ArrayList<>());

    // Assert
    verify(returnListRepository).save(isA(ReturnList.class));
  }

  /**
   * Test {@link ReturnListServiceImpl#save(ReturnList, List)}.
   *
   * <ul>
   *   <li>Given {@link GoodsType} (default constructor) Icon is {@code Icon}.
   *   <li>Then calls {@link GoodsRepository#findOne(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link ReturnListServiceImpl#save(ReturnList, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReturnListServiceImpl.save(ReturnList, List)"})
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

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type3 = new GoodsType();
    type3.setIcon("Icon");
    type3.setId(1);
    type3.setName("Name");
    type3.setState(1);
    type3.setpId(1);

    ReturnListGoods returnListGoods = new ReturnListGoods();
    returnListGoods.setCode("Code");
    returnListGoods.setCodeOrName("Code Or Name");
    returnListGoods.setGoodsId(1);
    returnListGoods.setId(1);
    returnListGoods.setModel("Model");
    returnListGoods.setName("Name");
    returnListGoods.setNum(10);
    returnListGoods.setPrice(10.0f);
    returnListGoods.setReturnList(returnList);
    returnListGoods.setTotal(10.0f);
    returnListGoods.setType(type3);
    returnListGoods.setTypeId(1);
    returnListGoods.setUnit("Unit");
    when(returnListGoodsRepository.save(Mockito.<ReturnListGoods>any()))
        .thenReturn(returnListGoods);

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

    ReturnList returnList2 = new ReturnList();
    returnList2.setAmountPaid(10.0f);
    returnList2.setAmountPayable(10.0f);
    returnList2.setId(1);
    returnList2.setRemarks("Remarks");
    returnList2.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList2.setReturnListGoodsList(new ArrayList<>());
    returnList2.setReturnNumber("42");
    returnList2.setState(1);
    returnList2.setSupplier(supplier2);
    returnList2.setUser(user2);
    returnList2.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList2.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(returnListRepository.save(Mockito.<ReturnList>any())).thenReturn(returnList2);

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

    ReturnList returnList3 = new ReturnList();
    returnList3.setAmountPaid(10.0f);
    returnList3.setAmountPayable(10.0f);
    returnList3.setId(1);
    returnList3.setRemarks("Remarks");
    returnList3.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList3.setReturnListGoodsList(new ArrayList<>());
    returnList3.setReturnNumber("42");
    returnList3.setState(1);
    returnList3.setSupplier(supplier3);
    returnList3.setUser(user3);
    returnList3.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList3.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

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

    ReturnList returnList4 = new ReturnList();
    returnList4.setAmountPaid(10.0f);
    returnList4.setAmountPayable(10.0f);
    returnList4.setId(1);
    returnList4.setRemarks("Remarks");
    returnList4.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList4.setReturnListGoodsList(new ArrayList<>());
    returnList4.setReturnNumber("42");
    returnList4.setState(1);
    returnList4.setSupplier(supplier4);
    returnList4.setUser(user4);
    returnList4.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList4.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type4 = new GoodsType();
    type4.setIcon("Icon");
    type4.setId(1);
    type4.setName("Name");
    type4.setState(1);
    type4.setpId(1);

    ReturnListGoods returnListGoods2 = new ReturnListGoods();
    returnListGoods2.setCode("Code");
    returnListGoods2.setCodeOrName("Code Or Name");
    returnListGoods2.setGoodsId(1);
    returnListGoods2.setId(1);
    returnListGoods2.setModel("Model");
    returnListGoods2.setName("Name");
    returnListGoods2.setNum(10);
    returnListGoods2.setPrice(10.0f);
    returnListGoods2.setReturnList(returnList4);
    returnListGoods2.setTotal(10.0f);
    returnListGoods2.setType(type4);
    returnListGoods2.setTypeId(1);
    returnListGoods2.setUnit("Unit");

    ArrayList<ReturnListGoods> returnListGoodsList = new ArrayList<>();
    returnListGoodsList.add(returnListGoods2);

    // Act
    returnListServiceImpl.save(returnList3, returnListGoodsList);

    // Assert
    verify(goodsRepository).findOne(anyInt());
    verify(goodsTypeRepository).findOne(anyInt());
    verify(goodsRepository).save(isA(Goods.class));
    verify(returnListRepository).save(isA(ReturnList.class));
    verify(returnListGoodsRepository).save(isA(ReturnListGoods.class));
  }

  /**
   * Test {@link ReturnListServiceImpl#findById(Integer)}.
   *
   * <p>Method under test: {@link ReturnListServiceImpl#findById(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReturnList ReturnListServiceImpl.findById(Integer)"})
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

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(returnListRepository.findOne(Mockito.<Integer>any())).thenReturn(returnList);

    // Act
    ReturnList actualFindByIdResult = returnListServiceImpl.findById(1);

    // Assert
    verify(returnListRepository).findOne(anyInt());
    assertSame(returnList, actualFindByIdResult);
  }

  /**
   * Test {@link ReturnListServiceImpl#list(ReturnList, Direction, String[])}.
   *
   * <ul>
   *   <li>Given {@link ReturnListRepository} {@link ReturnListRepository#findAll(Specification,
   *       Sort)} return {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ReturnListServiceImpl#list(ReturnList, Direction, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ReturnListServiceImpl.list(ReturnList, Direction, String[])"})
  public void testList_givenReturnListRepositoryFindAllReturnArrayList_thenReturnEmpty() {
    // Arrange
    when(returnListRepository.findAll(
            Mockito.<Specification<ReturnList>>any(), Mockito.<Sort>any()))
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

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    List<ReturnList> actualListResult =
        returnListServiceImpl.list(returnList, Direction.ASC, "Properties");

    // Assert
    verify(returnListRepository).findAll(isA(Specification.class), isA(Sort.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link ReturnListServiceImpl#delete(Integer)}.
   *
   * <p>Method under test: {@link ReturnListServiceImpl#delete(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReturnListServiceImpl.delete(Integer)"})
  public void testDelete() {
    // Arrange
    doNothing().when(returnListGoodsRepository).deleteByReturnListId(Mockito.<Integer>any());
    doNothing().when(returnListRepository).delete(Mockito.<Integer>any());

    // Act
    returnListServiceImpl.delete(1);

    // Assert
    verify(returnListGoodsRepository).deleteByReturnListId(anyInt());
    verify(returnListRepository).delete(anyInt());
  }

  /**
   * Test {@link ReturnListServiceImpl#update(ReturnList)}.
   *
   * <p>Method under test: {@link ReturnListServiceImpl#update(ReturnList)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ReturnListServiceImpl.update(ReturnList)"})
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

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(returnListRepository.save(Mockito.<ReturnList>any())).thenReturn(returnList);

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

    ReturnList returnList2 = new ReturnList();
    returnList2.setAmountPaid(10.0f);
    returnList2.setAmountPayable(10.0f);
    returnList2.setId(1);
    returnList2.setRemarks("Remarks");
    returnList2.setReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList2.setReturnListGoodsList(new ArrayList<>());
    returnList2.setReturnNumber("42");
    returnList2.setState(1);
    returnList2.setSupplier(supplier2);
    returnList2.setUser(user2);
    returnList2.setbReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList2.seteReturnDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    returnListServiceImpl.update(returnList2);

    // Assert
    verify(returnListRepository).save(isA(ReturnList.class));
  }
}
