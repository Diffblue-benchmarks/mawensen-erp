package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Customer}
   *   <li>{@link Customer#setAddress(String)}
   *   <li>{@link Customer#setContact(String)}
   *   <li>{@link Customer#setId(Integer)}
   *   <li>{@link Customer#setName(String)}
   *   <li>{@link Customer#setNumber(String)}
   *   <li>{@link Customer#setRemarks(String)}
   *   <li>{@link Customer#toString()}
   *   <li>{@link Customer#getAddress()}
   *   <li>{@link Customer#getContact()}
   *   <li>{@link Customer#getId()}
   *   <li>{@link Customer#getName()}
   *   <li>{@link Customer#getNumber()}
   *   <li>{@link Customer#getRemarks()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    Customer actualCustomer = new Customer();
    actualCustomer.setAddress("42 Main St");
    actualCustomer.setContact("Contact");
    actualCustomer.setId(1);
    actualCustomer.setName("Name");
    actualCustomer.setNumber("42");
    actualCustomer.setRemarks("Remarks");
    String actualToStringResult = actualCustomer.toString();
    String actualAddress = actualCustomer.getAddress();
    String actualContact = actualCustomer.getContact();
    Integer actualId = actualCustomer.getId();
    String actualName = actualCustomer.getName();
    String actualNumber = actualCustomer.getNumber();

    // Assert that nothing has changed
    assertEquals("42 Main St", actualAddress);
    assertEquals("42", actualNumber);
    assertEquals("Contact", actualContact);
    assertEquals("Name", actualName);
    assertEquals("Remarks", actualCustomer.getRemarks());
    assertEquals("[id=1, name=Name, contact=Contact, number=42, address=42 Main St, remarks=Remarks]",
        actualToStringResult);
    assertEquals(1, actualId.intValue());
  }
}
