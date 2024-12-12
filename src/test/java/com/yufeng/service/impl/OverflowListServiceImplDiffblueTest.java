package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Goods;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.OverflowList;
import com.yufeng.entity.OverflowListGoods;
import com.yufeng.entity.User;
import com.yufeng.repository.GoodsRepository;
import com.yufeng.repository.GoodsTypeRepository;
import com.yufeng.repository.OverflowListGoodsRepository;
import com.yufeng.repository.OverflowListRepository;
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
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OverflowListServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OverflowListServiceImplDiffblueTest {
  @MockBean
  private GoodsRepository goodsRepository;

  @MockBean
  private GoodsTypeRepository goodsTypeRepository;

  @MockBean
  private OverflowListGoodsRepository overflowListGoodsRepository;

  @MockBean
  private OverflowListRepository overflowListRepository;

  @Autowired
  private OverflowListServiceImpl overflowListServiceImpl;

  /**
   * Test {@link OverflowListServiceImpl#getTodayMaxOverflowNumber()}.
   * <p>
   * Method under test:
   * {@link OverflowListServiceImpl#getTodayMaxOverflowNumber()}
   */
  @Test
  public void testGetTodayMaxOverflowNumber() {
    // Arrange
    when(overflowListRepository.getTodayMaxOverflowNumber()).thenReturn("42");

    // Act
    String actualTodayMaxOverflowNumber = overflowListServiceImpl.getTodayMaxOverflowNumber();

    // Assert
    verify(overflowListRepository).getTodayMaxOverflowNumber();
    assertEquals("42", actualTodayMaxOverflowNumber);
  }

  /**
   * Test {@link OverflowListServiceImpl#save(OverflowList, List)}.
   * <ul>
   *   <li>Given {@link GoodsRepository}.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OverflowListServiceImpl#save(OverflowList, List)}
   */
  @Test
  public void testSave_givenGoodsRepository_whenArrayList() {
    // Arrange
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    OverflowList overflowList = new OverflowList();
    overflowList.setId(1);
    overflowList.setOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList.setOverflowNumber("42");
    overflowList.setRemarks("Remarks");
    overflowList.setUser(user);
    overflowList
        .setbOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList
        .seteOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(overflowListRepository.save(Mockito.<OverflowList>any())).thenReturn(overflowList);

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    OverflowList overflowList2 = new OverflowList();
    overflowList2.setId(1);
    overflowList2
        .setOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList2.setOverflowNumber("42");
    overflowList2.setRemarks("Remarks");
    overflowList2.setUser(user2);
    overflowList2
        .setbOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList2
        .seteOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    overflowListServiceImpl.save(overflowList2, new ArrayList<>());

    // Assert
    verify(overflowListRepository).save(isA(OverflowList.class));
  }

  /**
   * Test {@link OverflowListServiceImpl#save(OverflowList, List)}.
   * <ul>
   *   <li>Given {@link GoodsType} (default constructor) Icon is {@code Icon}.</li>
   *   <li>Then calls {@link CrudRepository#findOne(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OverflowListServiceImpl#save(OverflowList, List)}
   */
  @Test
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

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    OverflowList overflowList = new OverflowList();
    overflowList.setId(1);
    overflowList.setOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList.setOverflowNumber("42");
    overflowList.setRemarks("Remarks");
    overflowList.setUser(user);
    overflowList
        .setbOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList
        .seteOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type3 = new GoodsType();
    type3.setIcon("Icon");
    type3.setId(1);
    type3.setName("Name");
    type3.setState(1);
    type3.setpId(1);

    OverflowListGoods overflowListGoods = new OverflowListGoods();
    overflowListGoods.setCode("Code");
    overflowListGoods.setGoodsId(1);
    overflowListGoods.setId(1);
    overflowListGoods.setModel("Model");
    overflowListGoods.setName("Name");
    overflowListGoods.setNum(10);
    overflowListGoods.setOverflowList(overflowList);
    overflowListGoods.setPrice(10.0f);
    overflowListGoods.setTotal(10.0f);
    overflowListGoods.setType(type3);
    overflowListGoods.setTypeId(1);
    overflowListGoods.setUnit("Unit");
    when(overflowListGoodsRepository.save(Mockito.<OverflowListGoods>any())).thenReturn(overflowListGoods);

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    OverflowList overflowList2 = new OverflowList();
    overflowList2.setId(1);
    overflowList2
        .setOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList2.setOverflowNumber("42");
    overflowList2.setRemarks("Remarks");
    overflowList2.setUser(user2);
    overflowList2
        .setbOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList2
        .seteOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(overflowListRepository.save(Mockito.<OverflowList>any())).thenReturn(overflowList2);

    User user3 = new User();
    user3.setId(1);
    user3.setPassword("iloveyou");
    user3.setRemarks("Remarks");
    user3.setRoles("Roles");
    user3.setTrueName("True Name");
    user3.setUserName("janedoe");

    OverflowList overflowList3 = new OverflowList();
    overflowList3.setId(1);
    overflowList3
        .setOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList3.setOverflowNumber("42");
    overflowList3.setRemarks("Remarks");
    overflowList3.setUser(user3);
    overflowList3
        .setbOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList3
        .seteOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    User user4 = new User();
    user4.setId(1);
    user4.setPassword("iloveyou");
    user4.setRemarks("Remarks");
    user4.setRoles("Roles");
    user4.setTrueName("True Name");
    user4.setUserName("janedoe");

    OverflowList overflowList4 = new OverflowList();
    overflowList4.setId(1);
    overflowList4
        .setOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList4.setOverflowNumber("42");
    overflowList4.setRemarks("Remarks");
    overflowList4.setUser(user4);
    overflowList4
        .setbOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList4
        .seteOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    GoodsType type4 = new GoodsType();
    type4.setIcon("Icon");
    type4.setId(1);
    type4.setName("Name");
    type4.setState(1);
    type4.setpId(1);

    OverflowListGoods overflowListGoods2 = new OverflowListGoods();
    overflowListGoods2.setCode("Code");
    overflowListGoods2.setGoodsId(1);
    overflowListGoods2.setId(1);
    overflowListGoods2.setModel("Model");
    overflowListGoods2.setName("Name");
    overflowListGoods2.setNum(10);
    overflowListGoods2.setOverflowList(overflowList4);
    overflowListGoods2.setPrice(10.0f);
    overflowListGoods2.setTotal(10.0f);
    overflowListGoods2.setType(type4);
    overflowListGoods2.setTypeId(1);
    overflowListGoods2.setUnit("Unit");

    ArrayList<OverflowListGoods> overflowListGoodsList = new ArrayList<>();
    overflowListGoodsList.add(overflowListGoods2);

    // Act
    overflowListServiceImpl.save(overflowList3, overflowListGoodsList);

    // Assert
    verify(goodsRepository).findOne(anyInt());
    verify(goodsTypeRepository).findOne(anyInt());
    verify(goodsRepository).save(isA(Goods.class));
    verify(overflowListRepository).save(isA(OverflowList.class));
    verify(overflowListGoodsRepository).save(isA(OverflowListGoods.class));
  }

  /**
   * Test {@link OverflowListServiceImpl#list(OverflowList, Direction, String[])}.
   * <ul>
   *   <li>When {@code Properties}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OverflowListServiceImpl#list(OverflowList, Sort.Direction, String[])}
   */
  @Test
  public void testList_whenProperties_thenReturnEmpty() {
    // Arrange
    when(overflowListRepository.findAll(Mockito.<Specification<OverflowList>>any(), Mockito.<Sort>any()))
        .thenReturn(new ArrayList<>());

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    OverflowList overflowList = new OverflowList();
    overflowList.setId(1);
    overflowList.setOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList.setOverflowNumber("42");
    overflowList.setRemarks("Remarks");
    overflowList.setUser(user);
    overflowList
        .setbOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList
        .seteOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    List<OverflowList> actualListResult = overflowListServiceImpl.list(overflowList, Sort.Direction.ASC, "Properties");

    // Assert
    verify(overflowListRepository).findAll(isA(Specification.class), isA(Sort.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link OverflowListServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link OverflowListServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(overflowListGoodsRepository).deleteByOverflowListId(Mockito.<Integer>any());
    doNothing().when(overflowListRepository).delete(Mockito.<Integer>any());

    // Act
    overflowListServiceImpl.delete(1);

    // Assert
    verify(overflowListGoodsRepository).deleteByOverflowListId(anyInt());
    verify(overflowListRepository).delete(anyInt());
  }

  /**
   * Test {@link OverflowListServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link OverflowListServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
    // Arrange
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    OverflowList overflowList = new OverflowList();
    overflowList.setId(1);
    overflowList.setOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList.setOverflowNumber("42");
    overflowList.setRemarks("Remarks");
    overflowList.setUser(user);
    overflowList
        .setbOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList
        .seteOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(overflowListRepository.findOne(Mockito.<Integer>any())).thenReturn(overflowList);

    // Act
    OverflowList actualFindByIdResult = overflowListServiceImpl.findById(1);

    // Assert
    verify(overflowListRepository).findOne(anyInt());
    assertSame(overflowList, actualFindByIdResult);
  }
}
