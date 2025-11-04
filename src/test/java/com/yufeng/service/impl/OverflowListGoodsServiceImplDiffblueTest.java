package com.yufeng.service.impl;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.OverflowListGoods;
import com.yufeng.repository.OverflowListGoodsRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OverflowListGoodsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OverflowListGoodsServiceImplDiffblueTest {
  @MockBean
  private OverflowListGoodsRepository overflowListGoodsRepository;

  @Autowired
  private OverflowListGoodsServiceImpl overflowListGoodsServiceImpl;

  /**
   * Method under test:
   * {@link OverflowListGoodsServiceImpl#listByOverflowListId(Integer)}
   */
  @Test
  public void testListByOverflowListId() {
    // Arrange
    ArrayList<OverflowListGoods> overflowListGoodsList = new ArrayList<>();
    when(overflowListGoodsRepository.listByOverflowListId(Mockito.<Integer>any())).thenReturn(overflowListGoodsList);

    // Act
    List<OverflowListGoods> actualListByOverflowListIdResult = overflowListGoodsServiceImpl.listByOverflowListId(1);

    // Assert
    verify(overflowListGoodsRepository).listByOverflowListId(anyInt());
    assertTrue(actualListByOverflowListIdResult.isEmpty());
    assertSame(overflowListGoodsList, actualListByOverflowListIdResult);
  }
}
