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

public class SaleListDiffblueTest {
  /**
   * Test {@link SaleList#getbSaleDate()}.
   * <p>
   * Method under test: {@link SaleList#getbSaleDate()}
   */
  @Test
  public void testGetbSaleDate() {
    // Arrange, Act and Assert
    assertNull((new SaleList()).getbSaleDate());
  }

  /**
   * Test {@link SaleList#geteSaleDate()}.
   * <p>
   * Method under test: {@link SaleList#geteSaleDate()}
   */
  @Test
  public void testGeteSaleDate() {
    // Arrange, Act and Assert
    assertNull((new SaleList()).geteSaleDate());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SaleList}
   *   <li>{@link SaleList#setAmountPaid(float)}
   *   <li>{@link SaleList#setAmountPayable(float)}
   *   <li>{@link SaleList#setCustomer(Customer)}
   *   <li>{@link SaleList#setId(Integer)}
   *   <li>{@link SaleList#setRemarks(String)}
   *   <li>{@link SaleList#setSaleDate(Date)}
   *   <li>{@link SaleList#setSaleListGoodsList(List)}
   *   <li>{@link SaleList#setSaleNumber(String)}
   *   <li>{@link SaleList#setState(Integer)}
   *   <li>{@link SaleList#setUser(User)}
   *   <li>{@link SaleList#setbSaleDate(Date)}
   *   <li>{@link SaleList#seteSaleDate(Date)}
   *   <li>{@link SaleList#toString()}
   *   <li>{@link SaleList#getAmountPaid()}
   *   <li>{@link SaleList#getAmountPayable()}
   *   <li>{@link SaleList#getCustomer()}
   *   <li>{@link SaleList#getId()}
   *   <li>{@link SaleList#getRemarks()}
   *   <li>{@link SaleList#getSaleDate()}
   *   <li>{@link SaleList#getSaleListGoodsList()}
   *   <li>{@link SaleList#getSaleNumber()}
   *   <li>{@link SaleList#getState()}
   *   <li>{@link SaleList#getUser()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SaleList actualSaleList = new SaleList();
    actualSaleList.setAmountPaid(10.0f);
    actualSaleList.setAmountPayable(10.0f);
    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");
    actualSaleList.setCustomer(customer);
    actualSaleList.setId(1);
    actualSaleList.setRemarks("Remarks");
    Date saleDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualSaleList.setSaleDate(saleDate);
    ArrayList<SaleListGoods> saleListGoodsList = new ArrayList<>();
    actualSaleList.setSaleListGoodsList(saleListGoodsList);
    actualSaleList.setSaleNumber("42");
    actualSaleList.setState(1);
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    actualSaleList.setUser(user);
    actualSaleList.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualSaleList.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualSaleList.toString();
    float actualAmountPaid = actualSaleList.getAmountPaid();
    float actualAmountPayable = actualSaleList.getAmountPayable();
    Customer actualCustomer = actualSaleList.getCustomer();
    Integer actualId = actualSaleList.getId();
    String actualRemarks = actualSaleList.getRemarks();
    Date actualSaleDate = actualSaleList.getSaleDate();
    List<SaleListGoods> actualSaleListGoodsList = actualSaleList.getSaleListGoodsList();
    String actualSaleNumber = actualSaleList.getSaleNumber();
    Integer actualState = actualSaleList.getState();
    User actualUser = actualSaleList.getUser();

    // Assert that nothing has changed
    assertEquals("42", actualSaleNumber);
    assertEquals("Remarks", actualRemarks);
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualState.intValue());
    assertEquals(10.0f, actualAmountPaid, 0.0f);
    assertEquals(10.0f, actualAmountPayable, 0.0f);
    assertTrue(actualSaleListGoodsList.isEmpty());
    assertSame(customer, actualCustomer);
    assertSame(user, actualUser);
    assertSame(saleListGoodsList, actualSaleListGoodsList);
    assertSame(saleDate, actualSaleDate);
  }
}
