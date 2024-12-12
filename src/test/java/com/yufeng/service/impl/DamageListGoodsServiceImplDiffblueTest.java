package com.yufeng.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.DamageListGoods;
import com.yufeng.repository.DamageListGoodsRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DamageListGoodsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DamageListGoodsServiceImplDiffblueTest {
  @MockBean
  private DamageListGoodsRepository damageListGoodsRepository;

  @Autowired
  private DamageListGoodsServiceImpl damageListGoodsServiceImpl;

  /**
   * Test {@link DamageListGoodsServiceImpl#listByDamageListId(Integer)}.
   * <p>
   * Method under test:
   * {@link DamageListGoodsServiceImpl#listByDamageListId(Integer)}
   */
  @Test
  public void testListByDamageListId() {
    // Arrange
    when(damageListGoodsRepository.listByDamageListId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

    // Act
    List<DamageListGoods> actualListByDamageListIdResult = damageListGoodsServiceImpl.listByDamageListId(1);

    // Assert
    verify(damageListGoodsRepository).listByDamageListId(anyInt());
    assertTrue(actualListByDamageListIdResult.isEmpty());
  }
}
