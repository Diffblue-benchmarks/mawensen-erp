package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class CustomerReturnListDiffblueTest {
  /**
   * Test {@link CustomerReturnList#getbCustomerReturnDate()}.
   * <p>
   * Method under test: {@link CustomerReturnList#getbCustomerReturnDate()}
   */
  @Test
  public void testGetbCustomerReturnDate() {
    // Arrange, Act and Assert
    assertNull((new CustomerReturnList()).getbCustomerReturnDate());
  }

  /**
   * Test {@link CustomerReturnList#geteCustomerReturnDate()}.
   * <p>
   * Method under test: {@link CustomerReturnList#geteCustomerReturnDate()}
   */
  @Test
  public void testGeteCustomerReturnDate() {
    // Arrange, Act and Assert
    assertNull((new CustomerReturnList()).geteCustomerReturnDate());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerReturnList}
   *   <li>{@link CustomerReturnList#setAmountPaid(float)}
   *   <li>{@link CustomerReturnList#setAmountPayable(float)}
   *   <li>{@link CustomerReturnList#setCustomer(Customer)}
   *   <li>{@link CustomerReturnList#setCustomerReturnDate(Date)}
   *   <li>{@link CustomerReturnList#setCustomerReturnListGoodsList(List)}
   *   <li>{@link CustomerReturnList#setCustomerReturnNumber(String)}
   *   <li>{@link CustomerReturnList#setId(Integer)}
   *   <li>{@link CustomerReturnList#setRemarks(String)}
   *   <li>{@link CustomerReturnList#setState(Integer)}
   *   <li>{@link CustomerReturnList#setUser(User)}
   *   <li>{@link CustomerReturnList#setbCustomerReturnDate(Date)}
   *   <li>{@link CustomerReturnList#seteCustomerReturnDate(Date)}
   *   <li>{@link CustomerReturnList#toString()}
   *   <li>{@link CustomerReturnList#getAmountPaid()}
   *   <li>{@link CustomerReturnList#getAmountPayable()}
   *   <li>{@link CustomerReturnList#getCustomer()}
   *   <li>{@link CustomerReturnList#getCustomerReturnDate()}
   *   <li>{@link CustomerReturnList#getCustomerReturnListGoodsList()}
   *   <li>{@link CustomerReturnList#getCustomerReturnNumber()}
   *   <li>{@link CustomerReturnList#getId()}
   *   <li>{@link CustomerReturnList#getRemarks()}
   *   <li>{@link CustomerReturnList#getState()}
   *   <li>{@link CustomerReturnList#getUser()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerReturnList actualCustomerReturnList = new CustomerReturnList();
    actualCustomerReturnList.setAmountPaid(10.0f);
    actualCustomerReturnList.setAmountPayable(10.0f);
    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");
    actualCustomerReturnList.setCustomer(customer);
    Date customerReturnDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualCustomerReturnList.setCustomerReturnDate(customerReturnDate);
    ArrayList<CustomerReturnListGoods> customerReturnListGoodsList = new ArrayList<>();
    actualCustomerReturnList.setCustomerReturnListGoodsList(customerReturnListGoodsList);
    actualCustomerReturnList.setCustomerReturnNumber("42");
    actualCustomerReturnList.setId(1);
    actualCustomerReturnList.setRemarks("Remarks");
    actualCustomerReturnList.setState(1);
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    actualCustomerReturnList.setUser(user);
    actualCustomerReturnList
        .setbCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualCustomerReturnList
        .seteCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualCustomerReturnList.toString();
    float actualAmountPaid = actualCustomerReturnList.getAmountPaid();
    float actualAmountPayable = actualCustomerReturnList.getAmountPayable();
    Customer actualCustomer = actualCustomerReturnList.getCustomer();
    Date actualCustomerReturnDate = actualCustomerReturnList.getCustomerReturnDate();
    List<CustomerReturnListGoods> actualCustomerReturnListGoodsList = actualCustomerReturnList
        .getCustomerReturnListGoodsList();
    String actualCustomerReturnNumber = actualCustomerReturnList.getCustomerReturnNumber();
    Integer actualId = actualCustomerReturnList.getId();
    String actualRemarks = actualCustomerReturnList.getRemarks();
    Integer actualState = actualCustomerReturnList.getState();
    User actualUser = actualCustomerReturnList.getUser();

    // Assert that nothing has changed
    assertEquals("42", actualCustomerReturnNumber);
    assertEquals("Remarks", actualRemarks);
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualState.intValue());
    assertEquals(10.0f, actualAmountPaid, 0.0f);
    assertEquals(10.0f, actualAmountPayable, 0.0f);
    assertTrue(actualCustomerReturnListGoodsList.isEmpty());
    assertSame(customer, actualCustomer);
    assertSame(user, actualUser);
    assertSame(customerReturnListGoodsList, actualCustomerReturnListGoodsList);
    assertSame(customerReturnDate, actualCustomerReturnDate);
  }
}
