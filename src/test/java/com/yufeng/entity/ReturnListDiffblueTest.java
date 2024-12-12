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

public class ReturnListDiffblueTest {
  /**
   * Test {@link ReturnList#getbReturnDate()}.
   * <p>
   * Method under test: {@link ReturnList#getbReturnDate()}
   */
  @Test
  public void testGetbReturnDate() {
    // Arrange, Act and Assert
    assertNull((new ReturnList()).getbReturnDate());
  }

  /**
   * Test {@link ReturnList#geteReturnDate()}.
   * <p>
   * Method under test: {@link ReturnList#geteReturnDate()}
   */
  @Test
  public void testGeteReturnDate() {
    // Arrange, Act and Assert
    assertNull((new ReturnList()).geteReturnDate());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ReturnList}
   *   <li>{@link ReturnList#setAmountPaid(float)}
   *   <li>{@link ReturnList#setAmountPayable(float)}
   *   <li>{@link ReturnList#setId(Integer)}
   *   <li>{@link ReturnList#setRemarks(String)}
   *   <li>{@link ReturnList#setReturnDate(Date)}
   *   <li>{@link ReturnList#setReturnListGoodsList(List)}
   *   <li>{@link ReturnList#setReturnNumber(String)}
   *   <li>{@link ReturnList#setState(Integer)}
   *   <li>{@link ReturnList#setSupplier(Supplier)}
   *   <li>{@link ReturnList#setUser(User)}
   *   <li>{@link ReturnList#setbReturnDate(Date)}
   *   <li>{@link ReturnList#seteReturnDate(Date)}
   *   <li>{@link ReturnList#toString()}
   *   <li>{@link ReturnList#getAmountPaid()}
   *   <li>{@link ReturnList#getAmountPayable()}
   *   <li>{@link ReturnList#getId()}
   *   <li>{@link ReturnList#getRemarks()}
   *   <li>{@link ReturnList#getReturnDate()}
   *   <li>{@link ReturnList#getReturnListGoodsList()}
   *   <li>{@link ReturnList#getReturnNumber()}
   *   <li>{@link ReturnList#getState()}
   *   <li>{@link ReturnList#getSupplier()}
   *   <li>{@link ReturnList#getUser()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReturnList actualReturnList = new ReturnList();
    actualReturnList.setAmountPaid(10.0f);
    actualReturnList.setAmountPayable(10.0f);
    actualReturnList.setId(1);
    actualReturnList.setRemarks("Remarks");
    Date returnDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualReturnList.setReturnDate(returnDate);
    ArrayList<ReturnListGoods> returnListGoodsList = new ArrayList<>();
    actualReturnList.setReturnListGoodsList(returnListGoodsList);
    actualReturnList.setReturnNumber("42");
    actualReturnList.setState(1);
    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");
    actualReturnList.setSupplier(supplier);
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    actualReturnList.setUser(user);
    actualReturnList
        .setbReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualReturnList
        .seteReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualReturnList.toString();
    float actualAmountPaid = actualReturnList.getAmountPaid();
    float actualAmountPayable = actualReturnList.getAmountPayable();
    Integer actualId = actualReturnList.getId();
    String actualRemarks = actualReturnList.getRemarks();
    Date actualReturnDate = actualReturnList.getReturnDate();
    List<ReturnListGoods> actualReturnListGoodsList = actualReturnList.getReturnListGoodsList();
    String actualReturnNumber = actualReturnList.getReturnNumber();
    Integer actualState = actualReturnList.getState();
    Supplier actualSupplier = actualReturnList.getSupplier();
    User actualUser = actualReturnList.getUser();

    // Assert that nothing has changed
    assertEquals("42", actualReturnNumber);
    assertEquals("Remarks", actualRemarks);
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualState.intValue());
    assertEquals(10.0f, actualAmountPaid, 0.0f);
    assertEquals(10.0f, actualAmountPayable, 0.0f);
    assertTrue(actualReturnListGoodsList.isEmpty());
    assertSame(supplier, actualSupplier);
    assertSame(user, actualUser);
    assertSame(returnListGoodsList, actualReturnListGoodsList);
    assertSame(returnDate, actualReturnDate);
  }
}
