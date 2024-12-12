package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MenuDiffblueTest {
  /**
   * Test {@link Menu#getpId()}.
   * <p>
   * Method under test: {@link Menu#getpId()}
   */
  @Test
  public void testGetpId() {
    // Arrange, Act and Assert
    assertNull((new Menu()).getpId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Menu}
   *   <li>{@link Menu#setIcon(String)}
   *   <li>{@link Menu#setId(Integer)}
   *   <li>{@link Menu#setName(String)}
   *   <li>{@link Menu#setState(Integer)}
   *   <li>{@link Menu#setUrl(String)}
   *   <li>{@link Menu#setpId(Integer)}
   *   <li>{@link Menu#toString()}
   *   <li>{@link Menu#getIcon()}
   *   <li>{@link Menu#getId()}
   *   <li>{@link Menu#getName()}
   *   <li>{@link Menu#getState()}
   *   <li>{@link Menu#getUrl()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Menu actualMenu = new Menu();
    actualMenu.setIcon("Icon");
    actualMenu.setId(1);
    actualMenu.setName("Name");
    actualMenu.setState(1);
    actualMenu.setUrl("https://example.org/example");
    actualMenu.setpId(1);
    String actualToStringResult = actualMenu.toString();
    String actualIcon = actualMenu.getIcon();
    Integer actualId = actualMenu.getId();
    String actualName = actualMenu.getName();
    Integer actualState = actualMenu.getState();

    // Assert that nothing has changed
    assertEquals("Icon", actualIcon);
    assertEquals("Name", actualName);
    assertEquals("[id=1, name=Name, url=https://example.org/example, state=1, icon=Icon, pId=1]", actualToStringResult);
    assertEquals("https://example.org/example", actualMenu.getUrl());
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualState.intValue());
  }
}
