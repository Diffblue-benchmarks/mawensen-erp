package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.DamageList;
import com.yufeng.entity.DamageListGoods;
import com.yufeng.entity.Goods;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.User;
import com.yufeng.repository.DamageListGoodsRepository;
import com.yufeng.repository.DamageListRepository;
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

@ContextConfiguration(classes = {DamageListServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DamageListServiceImplDiffblueTest {
  @MockBean private DamageListGoodsRepository damageListGoodsRepository;

  @MockBean private DamageListRepository damageListRepository;

  @Autowired private DamageListServiceImpl damageListServiceImpl;

  @MockBean private GoodsRepository goodsRepository;

  @MockBean private GoodsTypeRepository goodsTypeRepository;

  /**
   * Test {@link DamageListServiceImpl#getTodayMaxDamageNumber()}.
   *
   * <p>Method under test: {@link DamageListServiceImpl#getTodayMaxDamageNumber()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DamageListServiceImpl.getTodayMaxDamageNumber()"})
  public void testGetTodayMaxDamageNumber() {
    // Arrange
    when(damageListRepository.getTodayMaxDamageNumber()).thenReturn("42");

    // Act
    String actualTodayMaxDamageNumber = damageListServiceImpl.getTodayMaxDamageNumber();

    // Assert
    verify(damageListRepository).getTodayMaxDamageNumber();
    assertEquals("42", actualTodayMaxDamageNumber);
  }

  /**
   * Test {@link DamageListServiceImpl#save(DamageList, List)}.
   *
   * <ul>
   *   <li>Given {@link DamageListGoodsRepository}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DamageListServiceImpl#save(DamageList, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DamageListServiceImpl.save(DamageList, List)"})
  public void testSave_givenDamageListGoodsRepository_whenArrayList() {
    // Arrange
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    DamageList damageList = new DamageList();
    damageList.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.setDamageNumber("42");
    damageList.setId(1);
    damageList.setRemarks("Remarks");
    damageList.setUser(user);
    damageList.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(damageListRepository.save(Mockito.<DamageList>any())).thenReturn(damageList);

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    DamageList damageList2 = new DamageList();
    damageList2.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList2.setDamageNumber("42");
    damageList2.setId(1);
    damageList2.setRemarks("Remarks");
    damageList2.setUser(user2);
    damageList2.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList2.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    damageListServiceImpl.save(damageList2, new ArrayList<>());

    // Assert
    verify(damageListRepository).save(isA(DamageList.class));
  }

  /**
   * Test {@link DamageListServiceImpl#save(DamageList, List)}.
   *
   * <ul>
   *   <li>Given {@link GoodsType} (default constructor) Icon is {@code Icon}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DamageListServiceImpl#save(DamageList, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DamageListServiceImpl.save(DamageList, List)"})
  public void testSave_givenGoodsTypeIconIsIcon_thenArrayListSizeIsOne() {
    // Arrange
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    DamageList damageList = new DamageList();
    damageList.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.setDamageNumber("42");
    damageList.setId(1);
    damageList.setRemarks("Remarks");
    damageList.setUser(user);
    damageList.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    DamageListGoods damageListGoods = new DamageListGoods();
    damageListGoods.setCode("Code");
    damageListGoods.setDamageList(damageList);
    damageListGoods.setGoodsId(1);
    damageListGoods.setId(1);
    damageListGoods.setModel("Model");
    damageListGoods.setName("Name");
    damageListGoods.setNum(10);
    damageListGoods.setPrice(10.0f);
    damageListGoods.setTotal(10.0f);
    damageListGoods.setType(type);
    damageListGoods.setTypeId(1);
    damageListGoods.setUnit("Unit");
    when(damageListGoodsRepository.save(Mockito.<DamageListGoods>any()))
        .thenReturn(damageListGoods);

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    DamageList damageList2 = new DamageList();
    damageList2.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList2.setDamageNumber("42");
    damageList2.setId(1);
    damageList2.setRemarks("Remarks");
    damageList2.setUser(user2);
    damageList2.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList2.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(damageListRepository.save(Mockito.<DamageList>any())).thenReturn(damageList2);

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

    User user3 = new User();
    user3.setId(1);
    user3.setPassword("iloveyou");
    user3.setRemarks("Remarks");
    user3.setRoles("Roles");
    user3.setTrueName("True Name");
    user3.setUserName("janedoe");

    DamageList damageList3 = new DamageList();
    damageList3.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList3.setDamageNumber("42");
    damageList3.setId(1);
    damageList3.setRemarks("Remarks");
    damageList3.setUser(user3);
    damageList3.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList3.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User user4 = new User();
    user4.setId(1);
    user4.setPassword("iloveyou");
    user4.setRemarks("Remarks");
    user4.setRoles("Roles");
    user4.setTrueName("True Name");
    user4.setUserName("janedoe");

    DamageList damageList4 = new DamageList();
    damageList4.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList4.setDamageNumber("42");
    damageList4.setId(1);
    damageList4.setRemarks("Remarks");
    damageList4.setUser(user4);
    damageList4.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList4.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type4 = new GoodsType();
    type4.setIcon("Icon");
    type4.setId(1);
    type4.setName("Name");
    type4.setState(1);
    type4.setpId(1);

    DamageListGoods damageListGoods2 = new DamageListGoods();
    damageListGoods2.setCode("Code");
    damageListGoods2.setDamageList(damageList4);
    damageListGoods2.setGoodsId(1);
    damageListGoods2.setId(1);
    damageListGoods2.setModel("Model");
    damageListGoods2.setName("Name");
    damageListGoods2.setNum(10);
    damageListGoods2.setPrice(10.0f);
    damageListGoods2.setTotal(10.0f);
    damageListGoods2.setType(type4);
    damageListGoods2.setTypeId(1);
    damageListGoods2.setUnit("Unit");

    ArrayList<DamageListGoods> damageListGoodsList = new ArrayList<>();
    damageListGoodsList.add(damageListGoods2);

    // Act
    damageListServiceImpl.save(damageList3, damageListGoodsList);

    // Assert that nothing has changed
    verify(goodsRepository).findOne(anyInt());
    verify(goodsTypeRepository).findOne(anyInt());
    verify(damageListRepository).save(isA(DamageList.class));
    verify(damageListGoodsRepository).save(isA(DamageListGoods.class));
    verify(goodsRepository).save(isA(Goods.class));
    assertEquals(1, damageListGoodsList.size());
    GoodsType type5 = damageListGoodsList.get(0).getType();
    assertEquals("Icon", type5.getIcon());
    assertEquals("Name", type5.getName());
    assertEquals(1, type5.getId().intValue());
    assertEquals(1, type5.getState().intValue());
  }

  /**
   * Test {@link DamageListServiceImpl#save(DamageList, List)}.
   *
   * <ul>
   *   <li>Given {@link User} (default constructor) Id is two.
   *   <li>When {@link ArrayList#ArrayList()} add {@link DamageListGoods} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link DamageListServiceImpl#save(DamageList, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DamageListServiceImpl.save(DamageList, List)"})
  public void testSave_givenUserIdIsTwo_whenArrayListAddDamageListGoods_thenArrayListSizeIsTwo() {
    // Arrange
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    DamageList damageList = new DamageList();
    damageList.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.setDamageNumber("42");
    damageList.setId(1);
    damageList.setRemarks("Remarks");
    damageList.setUser(user);
    damageList.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    DamageListGoods damageListGoods = new DamageListGoods();
    damageListGoods.setCode("Code");
    damageListGoods.setDamageList(damageList);
    damageListGoods.setGoodsId(1);
    damageListGoods.setId(1);
    damageListGoods.setModel("Model");
    damageListGoods.setName("Name");
    damageListGoods.setNum(10);
    damageListGoods.setPrice(10.0f);
    damageListGoods.setTotal(10.0f);
    damageListGoods.setType(type);
    damageListGoods.setTypeId(1);
    damageListGoods.setUnit("Unit");
    when(damageListGoodsRepository.save(Mockito.<DamageListGoods>any()))
        .thenReturn(damageListGoods);

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    DamageList damageList2 = new DamageList();
    damageList2.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList2.setDamageNumber("42");
    damageList2.setId(1);
    damageList2.setRemarks("Remarks");
    damageList2.setUser(user2);
    damageList2.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList2.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(damageListRepository.save(Mockito.<DamageList>any())).thenReturn(damageList2);

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

    User user3 = new User();
    user3.setId(1);
    user3.setPassword("iloveyou");
    user3.setRemarks("Remarks");
    user3.setRoles("Roles");
    user3.setTrueName("True Name");
    user3.setUserName("janedoe");

    DamageList damageList3 = new DamageList();
    damageList3.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList3.setDamageNumber("42");
    damageList3.setId(1);
    damageList3.setRemarks("Remarks");
    damageList3.setUser(user3);
    damageList3.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList3.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User user4 = new User();
    user4.setId(1);
    user4.setPassword("iloveyou");
    user4.setRemarks("Remarks");
    user4.setRoles("Roles");
    user4.setTrueName("True Name");
    user4.setUserName("janedoe");

    DamageList damageList4 = new DamageList();
    damageList4.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList4.setDamageNumber("42");
    damageList4.setId(1);
    damageList4.setRemarks("Remarks");
    damageList4.setUser(user4);
    damageList4.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList4.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type4 = new GoodsType();
    type4.setIcon("Icon");
    type4.setId(1);
    type4.setName("Name");
    type4.setState(1);
    type4.setpId(1);

    DamageListGoods damageListGoods2 = new DamageListGoods();
    damageListGoods2.setCode("Code");
    damageListGoods2.setDamageList(damageList4);
    damageListGoods2.setGoodsId(1);
    damageListGoods2.setId(1);
    damageListGoods2.setModel("Model");
    damageListGoods2.setName("Name");
    damageListGoods2.setNum(10);
    damageListGoods2.setPrice(10.0f);
    damageListGoods2.setTotal(10.0f);
    damageListGoods2.setType(type4);
    damageListGoods2.setTypeId(1);
    damageListGoods2.setUnit("Unit");

    User user5 = new User();
    user5.setId(2);
    user5.setPassword("Password");
    user5.setRemarks("42");
    user5.setRoles("42");
    user5.setTrueName("42");
    user5.setUserName("User Name");

    DamageList damageList5 = new DamageList();
    damageList5.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList5.setDamageNumber("Damage Number");
    damageList5.setId(2);
    damageList5.setRemarks("42");
    damageList5.setUser(user5);
    damageList5.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList5.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type5 = new GoodsType();
    type5.setIcon("42");
    type5.setId(2);
    type5.setName("42");
    type5.setState(2);
    type5.setpId(2);

    DamageListGoods damageListGoods3 = new DamageListGoods();
    damageListGoods3.setCode("42");
    damageListGoods3.setDamageList(damageList5);
    damageListGoods3.setGoodsId(2);
    damageListGoods3.setId(2);
    damageListGoods3.setModel("42");
    damageListGoods3.setName("42");
    damageListGoods3.setNum(1);
    damageListGoods3.setPrice(0.5f);
    damageListGoods3.setTotal(0.5f);
    damageListGoods3.setType(type5);
    damageListGoods3.setTypeId(2);
    damageListGoods3.setUnit("42");

    ArrayList<DamageListGoods> damageListGoodsList = new ArrayList<>();
    damageListGoodsList.add(damageListGoods3);
    damageListGoodsList.add(damageListGoods2);

    // Act
    damageListServiceImpl.save(damageList3, damageListGoodsList);

    // Assert
    verify(goodsRepository, atLeast(1)).findOne(Mockito.<Integer>any());
    verify(goodsTypeRepository, atLeast(1)).findOne(Mockito.<Integer>any());
    verify(damageListRepository).save(isA(DamageList.class));
    verify(damageListGoodsRepository, atLeast(1)).save(Mockito.<DamageListGoods>any());
    verify(goodsRepository, atLeast(1)).save(isA(Goods.class));
    assertEquals(2, damageListGoodsList.size());
    GoodsType type6 = damageListGoodsList.get(0).getType();
    assertEquals("Icon", type6.getIcon());
    assertEquals("Name", type6.getName());
    assertEquals(1, type6.getId().intValue());
    assertEquals(1, type6.getState().intValue());
    assertSame(goodsType, damageListGoodsList.get(1).getType());
  }

  /**
   * Test {@link DamageListServiceImpl#list(DamageList, Direction, String[])}.
   *
   * <ul>
   *   <li>Given {@link DamageListRepository} {@link DamageListRepository#findAll(Specification,
   *       Sort)} return {@link ArrayList#ArrayList()}.
   *   <li>When {@code ASC}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DamageListServiceImpl#list(DamageList, Direction, String[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DamageListServiceImpl.list(DamageList, Direction, String[])"})
  public void testList_givenDamageListRepositoryFindAllReturnArrayList_whenAsc_thenReturnEmpty() {
    // Arrange
    when(damageListRepository.findAll(
            Mockito.<Specification<DamageList>>any(), Mockito.<Sort>any()))
        .thenReturn(new ArrayList<>());

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    DamageList damageList = new DamageList();
    damageList.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.setDamageNumber("42");
    damageList.setId(1);
    damageList.setRemarks("Remarks");
    damageList.setUser(user);
    damageList.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    List<DamageList> actualListResult =
        damageListServiceImpl.list(damageList, Direction.ASC, "Properties");

    // Assert
    verify(damageListRepository).findAll(isA(Specification.class), isA(Sort.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link DamageListServiceImpl#delete(Integer)}.
   *
   * <p>Method under test: {@link DamageListServiceImpl#delete(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DamageListServiceImpl.delete(Integer)"})
  public void testDelete() {
    // Arrange
    doNothing().when(damageListGoodsRepository).deleteByDamageListId(Mockito.<Integer>any());
    doNothing().when(damageListRepository).delete(Mockito.<Integer>any());

    // Act
    damageListServiceImpl.delete(1);

    // Assert
    verify(damageListGoodsRepository).deleteByDamageListId(anyInt());
    verify(damageListRepository).delete(anyInt());
  }

  /**
   * Test {@link DamageListServiceImpl#findById(Integer)}.
   *
   * <p>Method under test: {@link DamageListServiceImpl#findById(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DamageList DamageListServiceImpl.findById(Integer)"})
  public void testFindById() {
    // Arrange
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    DamageList damageList = new DamageList();
    damageList.setDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.setDamageNumber("42");
    damageList.setId(1);
    damageList.setRemarks("Remarks");
    damageList.setUser(user);
    damageList.setbDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.seteDamageDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(damageListRepository.findOne(Mockito.<Integer>any())).thenReturn(damageList);

    // Act
    DamageList actualFindByIdResult = damageListServiceImpl.findById(1);

    // Assert
    verify(damageListRepository).findOne(anyInt());
    assertSame(damageList, actualFindByIdResult);
  }
}
