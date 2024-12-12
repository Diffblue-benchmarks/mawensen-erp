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
import com.yufeng.repository.GoodsRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GoodsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsServiceImplDiffblueTest {
  @MockBean
  private GoodsRepository goodsRepository;

  @Autowired
  private GoodsServiceImpl goodsServiceImpl;

  /**
   * Test {@link GoodsServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link GoodsServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
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
    when(goodsRepository.findOne(Mockito.<Integer>any())).thenReturn(goods);

    // Act
    Goods actualFindByIdResult = goodsServiceImpl.findById(1);

    // Assert
    verify(goodsRepository).findOne(anyInt());
    assertSame(goods, actualFindByIdResult);
  }

  /**
   * Test {@link GoodsServiceImpl#save(Goods)}.
   * <p>
   * Method under test: {@link GoodsServiceImpl#save(Goods)}
   */
  @Test
  public void testSave() {
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
    when(goodsRepository.save(Mockito.<Goods>any())).thenReturn(goods);

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

    // Act
    goodsServiceImpl.save(goods2);

    // Assert
    verify(goodsRepository).save(isA(Goods.class));
  }

  /**
   * Test
   * {@link GoodsServiceImpl#list(Goods, Integer, Integer, Direction, String[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoodsServiceImpl#list(Goods, Integer, Integer, Sort.Direction, String[])}
   */
  @Test
  public void testList_thenReturnEmpty() {
    // Arrange
    when(goodsRepository.findAll(Mockito.<Specification<Goods>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

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

    // Act
    List<Goods> actualListResult = goodsServiceImpl.list(goods, 1, 3, Sort.Direction.ASC, "Properties");

    // Assert
    verify(goodsRepository).findAll(isA(Specification.class), isA(Pageable.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link GoodsServiceImpl#getCount(Goods)}.
   * <p>
   * Method under test: {@link GoodsServiceImpl#getCount(Goods)}
   */
  @Test
  public void testGetCount() {
    // Arrange
    when(goodsRepository.count(Mockito.<Specification<Goods>>any())).thenReturn(3L);

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

    // Act
    Long actualCount = goodsServiceImpl.getCount(goods);

    // Assert
    verify(goodsRepository).count(isA(Specification.class));
    assertEquals(3L, actualCount.longValue());
  }

  /**
   * Test {@link GoodsServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link GoodsServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(goodsRepository).delete(Mockito.<Integer>any());

    // Act
    goodsServiceImpl.delete(1);

    // Assert
    verify(goodsRepository).delete(anyInt());
  }

  /**
   * Test {@link GoodsServiceImpl#getMaxGoodsCode()}.
   * <p>
   * Method under test: {@link GoodsServiceImpl#getMaxGoodsCode()}
   */
  @Test
  public void testGetMaxGoodsCode() {
    // Arrange
    when(goodsRepository.getMaxGoodsCode()).thenReturn("Max Goods Code");

    // Act
    String actualMaxGoodsCode = goodsServiceImpl.getMaxGoodsCode();

    // Assert
    verify(goodsRepository).getMaxGoodsCode();
    assertEquals("Max Goods Code", actualMaxGoodsCode);
  }

  /**
   * Test
   * {@link GoodsServiceImpl#listNoInventoryQuantityByCodeOrName(String, Integer, Integer, Direction, String[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoodsServiceImpl#listNoInventoryQuantityByCodeOrName(String, Integer, Integer, Sort.Direction, String[])}
   */
  @Test
  public void testListNoInventoryQuantityByCodeOrName_thenReturnEmpty() {
    // Arrange
    when(goodsRepository.findAll(Mockito.<Specification<Goods>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    List<Goods> actualListNoInventoryQuantityByCodeOrNameResult = goodsServiceImpl
        .listNoInventoryQuantityByCodeOrName("Code Or Name", 1, 3, Sort.Direction.ASC, "Properties");

    // Assert
    verify(goodsRepository).findAll(isA(Specification.class), isA(Pageable.class));
    assertTrue(actualListNoInventoryQuantityByCodeOrNameResult.isEmpty());
  }

  /**
   * Test
   * {@link GoodsServiceImpl#getCountNoInventoryQuantityByCodeOrName(String)}.
   * <p>
   * Method under test:
   * {@link GoodsServiceImpl#getCountNoInventoryQuantityByCodeOrName(String)}
   */
  @Test
  public void testGetCountNoInventoryQuantityByCodeOrName() {
    // Arrange
    when(goodsRepository.count(Mockito.<Specification<Goods>>any())).thenReturn(3L);

    // Act
    Long actualCountNoInventoryQuantityByCodeOrName = goodsServiceImpl
        .getCountNoInventoryQuantityByCodeOrName("Code Or Name");

    // Assert
    verify(goodsRepository).count(isA(Specification.class));
    assertEquals(3L, actualCountNoInventoryQuantityByCodeOrName.longValue());
  }

  /**
   * Test
   * {@link GoodsServiceImpl#listHasInventoryQuantity(Integer, Integer, Direction, String[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GoodsServiceImpl#listHasInventoryQuantity(Integer, Integer, Sort.Direction, String[])}
   */
  @Test
  public void testListHasInventoryQuantity_thenReturnEmpty() {
    // Arrange
    when(goodsRepository.findAll(Mockito.<Specification<Goods>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    List<Goods> actualListHasInventoryQuantityResult = goodsServiceImpl.listHasInventoryQuantity(1, 3,
        Sort.Direction.ASC, "Properties");

    // Assert
    verify(goodsRepository).findAll(isA(Specification.class), isA(Pageable.class));
    assertTrue(actualListHasInventoryQuantityResult.isEmpty());
  }

  /**
   * Test {@link GoodsServiceImpl#getCountHasInventoryQuantity()}.
   * <p>
   * Method under test: {@link GoodsServiceImpl#getCountHasInventoryQuantity()}
   */
  @Test
  public void testGetCountHasInventoryQuantity() {
    // Arrange
    when(goodsRepository.count(Mockito.<Specification<Goods>>any())).thenReturn(3L);

    // Act
    Long actualCountHasInventoryQuantity = goodsServiceImpl.getCountHasInventoryQuantity();

    // Assert
    verify(goodsRepository).count(isA(Specification.class));
    assertEquals(3L, actualCountHasInventoryQuantity.longValue());
  }

  /**
   * Test {@link GoodsServiceImpl#listAlarm()}.
   * <p>
   * Method under test: {@link GoodsServiceImpl#listAlarm()}
   */
  @Test
  public void testListAlarm() {
    // Arrange
    when(goodsRepository.listAlarm()).thenReturn(new ArrayList<>());

    // Act
    List<Goods> actualListAlarmResult = goodsServiceImpl.listAlarm();

    // Assert
    verify(goodsRepository).listAlarm();
    assertTrue(actualListAlarmResult.isEmpty());
  }
}
