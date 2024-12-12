package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RoleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Role}
   *   <li>{@link Role#setId(Integer)}
   *   <li>{@link Role#setName(String)}
   *   <li>{@link Role#setRemarks(String)}
   *   <li>{@link Role#toString()}
   *   <li>{@link Role#getId()}
   *   <li>{@link Role#getName()}
   *   <li>{@link Role#getRemarks()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Role actualRole = new Role();
    actualRole.setId(1);
    actualRole.setName("Name");
    actualRole.setRemarks("Remarks");
    String actualToStringResult = actualRole.toString();
    Integer actualId = actualRole.getId();
    String actualName = actualRole.getName();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Remarks", actualRole.getRemarks());
    assertEquals("[id=1, name=Name, remarks=Remarks]", actualToStringResult);
    assertEquals(1, actualId.intValue());
  }
}
