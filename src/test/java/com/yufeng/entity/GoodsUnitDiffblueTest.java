package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GoodsUnitDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GoodsUnit.<init>()",
    "Integer GoodsUnit.getId()",
    "String GoodsUnit.getName()",
    "void GoodsUnit.setId(Integer)",
    "void GoodsUnit.setName(String)",
    "String GoodsUnit.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    GoodsUnit actualGoodsUnit = new GoodsUnit();
    actualGoodsUnit.setId(1);
    actualGoodsUnit.setName("Name");
    String actualToStringResult = actualGoodsUnit.toString();
    Integer actualId = actualGoodsUnit.getId();

    // Assert
    assertEquals("Name", actualGoodsUnit.getName());
    assertEquals("[id=1, name=Name]", actualToStringResult);
    assertEquals(1, actualId.intValue());
  }
}
