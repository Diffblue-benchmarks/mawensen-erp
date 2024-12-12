package com.yufeng.service.impl;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.GoodsType;
import com.yufeng.repository.GoodsTypeRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {GoodsTypeServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsTypeServiceImplDiffblueTest {
  @MockBean
  private GoodsTypeRepository goodsTypeRepository;

  @Autowired
  private GoodsTypeServiceImpl goodsTypeServiceImpl;

  /**
   * Test {@link GoodsTypeServiceImpl#save(GoodsType)}.
   * <p>
   * Method under test: {@link GoodsTypeServiceImpl#save(GoodsType)}
   */
  @Test
  public void testSave() {
    // Arrange
    GoodsType goodsType = new GoodsType();
    goodsType.setIcon("Icon");
    goodsType.setId(1);
    goodsType.setName("Name");
    goodsType.setState(1);
    goodsType.setpId(1);
    when(goodsTypeRepository.save(Mockito.<GoodsType>any())).thenReturn(goodsType);

    GoodsType goodsType2 = new GoodsType();
    goodsType2.setIcon("Icon");
    goodsType2.setId(1);
    goodsType2.setName("Name");
    goodsType2.setState(1);
    goodsType2.setpId(1);

    // Act
    goodsTypeServiceImpl.save(goodsType2);

    // Assert
    verify(goodsTypeRepository).save(isA(GoodsType.class));
  }

  /**
   * Test {@link GoodsTypeServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link GoodsTypeServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(goodsTypeRepository).delete(Mockito.<Integer>any());

    // Act
    goodsTypeServiceImpl.delete(1);

    // Assert
    verify(goodsTypeRepository).delete(anyInt());
  }

  /**
   * Test {@link GoodsTypeServiceImpl#findByParentId(int)}.
   * <p>
   * Method under test: {@link GoodsTypeServiceImpl#findByParentId(int)}
   */
  @Test
  public void testFindByParentId() {
    // Arrange
    when(goodsTypeRepository.findByParentId(anyInt())).thenReturn(new ArrayList<>());

    // Act
    List<GoodsType> actualFindByParentIdResult = goodsTypeServiceImpl.findByParentId(1);

    // Assert
    verify(goodsTypeRepository).findByParentId(anyInt());
    assertTrue(actualFindByParentIdResult.isEmpty());
  }

  /**
   * Test {@link GoodsTypeServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link GoodsTypeServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
    // Arrange
    GoodsType goodsType = new GoodsType();
    goodsType.setIcon("Icon");
    goodsType.setId(1);
    goodsType.setName("Name");
    goodsType.setState(1);
    goodsType.setpId(1);
    when(goodsTypeRepository.findOne(Mockito.<Integer>any())).thenReturn(goodsType);

    // Act
    GoodsType actualFindByIdResult = goodsTypeServiceImpl.findById(1);

    // Assert
    verify(goodsTypeRepository).findOne(anyInt());
    assertSame(goodsType, actualFindByIdResult);
  }
}
