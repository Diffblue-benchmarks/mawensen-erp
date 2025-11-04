package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GoodsTypeDiffblueTest {
  /**
   * Test {@link GoodsType#getpId()}.
   * <p>
   * Method under test: {@link GoodsType#getpId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Integer GoodsType.getpId()"})
  public void testGetpId() {
    // Arrange, Act and Assert
    assertNull((new GoodsType()).getpId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GoodsType}
   *   <li>{@link GoodsType#setIcon(String)}
   *   <li>{@link GoodsType#setId(Integer)}
   *   <li>{@link GoodsType#setName(String)}
   *   <li>{@link GoodsType#setState(Integer)}
   *   <li>{@link GoodsType#setpId(Integer)}
   *   <li>{@link GoodsType#toString()}
   *   <li>{@link GoodsType#getIcon()}
   *   <li>{@link GoodsType#getId()}
   *   <li>{@link GoodsType#getName()}
   *   <li>{@link GoodsType#getState()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void GoodsType.<init>()", "String GoodsType.getIcon()", "Integer GoodsType.getId()",
      "String GoodsType.getName()", "Integer GoodsType.getState()", "void GoodsType.setIcon(String)",
      "void GoodsType.setId(Integer)", "void GoodsType.setName(String)", "void GoodsType.setState(Integer)",
      "void GoodsType.setpId(Integer)", "String GoodsType.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    GoodsType actualGoodsType = new GoodsType();
    actualGoodsType.setIcon("Icon");
    actualGoodsType.setId(1);
    actualGoodsType.setName("Name");
    actualGoodsType.setState(1);
    actualGoodsType.setpId(1);
    String actualToStringResult = actualGoodsType.toString();
    String actualIcon = actualGoodsType.getIcon();
    Integer actualId = actualGoodsType.getId();
    String actualName = actualGoodsType.getName();
    Integer actualState = actualGoodsType.getState();

    // Assert
    assertEquals("Icon", actualIcon);
    assertEquals("Name", actualName);
    assertEquals("[id=1, name=Name, state=1, icon=Icon, pId=1]", actualToStringResult);
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualState.intValue());
  }
}
