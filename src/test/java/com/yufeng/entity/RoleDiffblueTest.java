package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Role.<init>()", "Integer Role.getId()", "String Role.getName()", "String Role.getRemarks()",
      "void Role.setId(Integer)", "void Role.setName(String)", "void Role.setRemarks(String)",
      "String Role.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Role actualRole = new Role();
    actualRole.setId(1);
    actualRole.setName("Name");
    actualRole.setRemarks("Remarks");
    String actualToStringResult = actualRole.toString();
    Integer actualId = actualRole.getId();
    String actualName = actualRole.getName();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Remarks", actualRole.getRemarks());
    assertEquals("[id=1, name=Name, remarks=Remarks]", actualToStringResult);
    assertEquals(1, actualId.intValue());
  }
}
