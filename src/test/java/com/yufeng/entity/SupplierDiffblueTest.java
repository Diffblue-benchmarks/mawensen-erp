package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SupplierDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Supplier}
   *   <li>{@link Supplier#setAddress(String)}
   *   <li>{@link Supplier#setContact(String)}
   *   <li>{@link Supplier#setId(Integer)}
   *   <li>{@link Supplier#setName(String)}
   *   <li>{@link Supplier#setNumber(String)}
   *   <li>{@link Supplier#setRemarks(String)}
   *   <li>{@link Supplier#toString()}
   *   <li>{@link Supplier#getAddress()}
   *   <li>{@link Supplier#getContact()}
   *   <li>{@link Supplier#getId()}
   *   <li>{@link Supplier#getName()}
   *   <li>{@link Supplier#getNumber()}
   *   <li>{@link Supplier#getRemarks()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Supplier actualSupplier = new Supplier();
    actualSupplier.setAddress("42 Main St");
    actualSupplier.setContact("Contact");
    actualSupplier.setId(1);
    actualSupplier.setName("Name");
    actualSupplier.setNumber("42");
    actualSupplier.setRemarks("Remarks");
    String actualToStringResult = actualSupplier.toString();
    String actualAddress = actualSupplier.getAddress();
    String actualContact = actualSupplier.getContact();
    Integer actualId = actualSupplier.getId();
    String actualName = actualSupplier.getName();
    String actualNumber = actualSupplier.getNumber();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddress);
    assertEquals("42", actualNumber);
    assertEquals("Contact", actualContact);
    assertEquals("Name", actualName);
    assertEquals("Remarks", actualSupplier.getRemarks());
    assertEquals("[id=1, name=Name, contact=Contact, number=42, address=42 Main St, remarks=Remarks]",
        actualToStringResult);
    assertEquals(1, actualId.intValue());
  }
}
