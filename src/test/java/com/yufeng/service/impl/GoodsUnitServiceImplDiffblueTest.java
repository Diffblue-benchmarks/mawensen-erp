package com.yufeng.service.impl;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.GoodsUnit;
import com.yufeng.repository.GoodsUnitRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GoodsUnitServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsUnitServiceImplDiffblueTest {
  @MockBean
  private GoodsUnitRepository goodsUnitRepository;

  @Autowired
  private GoodsUnitServiceImpl goodsUnitServiceImpl;

  /**
   * Method under test: {@link GoodsUnitServiceImpl#listAll()}
   */
  @Test
  public void testListAll() {
    // Arrange
    ArrayList<GoodsUnit> goodsUnitList = new ArrayList<>();
    when(goodsUnitRepository.findAll()).thenReturn(goodsUnitList);

    // Act
    List<GoodsUnit> actualListAllResult = goodsUnitServiceImpl.listAll();

    // Assert
    verify(goodsUnitRepository).findAll();
    assertTrue(actualListAllResult.isEmpty());
    assertSame(goodsUnitList, actualListAllResult);
  }

  /**
   * Method under test: {@link GoodsUnitServiceImpl#save(GoodsUnit)}
   */
  @Test
  public void testSave() {
    // Arrange
    GoodsUnit goodsUnit = new GoodsUnit();
    goodsUnit.setId(1);
    goodsUnit.setName("Name");
    when(goodsUnitRepository.save(Mockito.<GoodsUnit>any())).thenReturn(goodsUnit);

    GoodsUnit goodsUnit2 = new GoodsUnit();
    goodsUnit2.setId(1);
    goodsUnit2.setName("Name");

    // Act
    goodsUnitServiceImpl.save(goodsUnit2);

    // Assert
    verify(goodsUnitRepository).save(isA(GoodsUnit.class));
  }

  /**
   * Method under test: {@link GoodsUnitServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(goodsUnitRepository).delete(Mockito.<Integer>any());

    // Act
    goodsUnitServiceImpl.delete(1);

    // Assert
    verify(goodsUnitRepository).delete(anyInt());
  }

  /**
   * Method under test: {@link GoodsUnitServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
    // Arrange
    GoodsUnit goodsUnit = new GoodsUnit();
    goodsUnit.setId(1);
    goodsUnit.setName("Name");
    when(goodsUnitRepository.findOne(Mockito.<Integer>any())).thenReturn(goodsUnit);

    // Act
    GoodsUnit actualFindByIdResult = goodsUnitServiceImpl.findById(1);

    // Assert
    verify(goodsUnitRepository).findOne(anyInt());
    assertSame(goodsUnit, actualFindByIdResult);
  }
}
