package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GoodsUnitDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GoodsUnit}
   *   <li>{@link GoodsUnit#setId(Integer)}
   *   <li>{@link GoodsUnit#setName(String)}
   *   <li>{@link GoodsUnit#toString()}
   *   <li>{@link GoodsUnit#getId()}
   *   <li>{@link GoodsUnit#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    GoodsUnit actualGoodsUnit = new GoodsUnit();
    actualGoodsUnit.setId(1);
    actualGoodsUnit.setName("Name");
    String actualToStringResult = actualGoodsUnit.toString();
    Integer actualId = actualGoodsUnit.getId();

    // Assert that nothing has changed
    assertEquals("Name", actualGoodsUnit.getName());
    assertEquals("[id=1, name=Name]", actualToStringResult);
    assertEquals(1, actualId.intValue());
  }
}
