package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SaleCountDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SaleCount}
   *   <li>{@link SaleCount#setAmountCost(float)}
   *   <li>{@link SaleCount#setAmountProfit(float)}
   *   <li>{@link SaleCount#setAmountSale(float)}
   *   <li>{@link SaleCount#setDate(String)}
   *   <li>{@link SaleCount#getAmountCost()}
   *   <li>{@link SaleCount#getAmountProfit()}
   *   <li>{@link SaleCount#getAmountSale()}
   *   <li>{@link SaleCount#getDate()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SaleCount actualSaleCount = new SaleCount();
    actualSaleCount.setAmountCost(10.0f);
    actualSaleCount.setAmountProfit(10.0f);
    actualSaleCount.setAmountSale(10.0f);
    actualSaleCount.setDate("2020-03-01");
    float actualAmountCost = actualSaleCount.getAmountCost();
    float actualAmountProfit = actualSaleCount.getAmountProfit();
    float actualAmountSale = actualSaleCount.getAmountSale();

    // Assert that nothing has changed
    assertEquals("2020-03-01", actualSaleCount.getDate());
    assertEquals(10.0f, actualAmountCost, 0.0f);
    assertEquals(10.0f, actualAmountProfit, 0.0f);
    assertEquals(10.0f, actualAmountSale, 0.0f);
  }
}
