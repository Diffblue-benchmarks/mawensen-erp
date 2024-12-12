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

public class PurchaseListDiffblueTest {
  /**
   * Test {@link PurchaseList#getbPurchaseDate()}.
   * <p>
   * Method under test: {@link PurchaseList#getbPurchaseDate()}
   */
  @Test
  public void testGetbPurchaseDate() {
    // Arrange, Act and Assert
    assertNull((new PurchaseList()).getbPurchaseDate());
  }

  /**
   * Test {@link PurchaseList#getePurchaseDate()}.
   * <p>
   * Method under test: {@link PurchaseList#getePurchaseDate()}
   */
  @Test
  public void testGetePurchaseDate() {
    // Arrange, Act and Assert
    assertNull((new PurchaseList()).getePurchaseDate());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PurchaseList}
   *   <li>{@link PurchaseList#setAmountPaid(float)}
   *   <li>{@link PurchaseList#setAmountPayable(float)}
   *   <li>{@link PurchaseList#setId(Integer)}
   *   <li>{@link PurchaseList#setPurchaseDate(Date)}
   *   <li>{@link PurchaseList#setPurchaseListGoodsList(List)}
   *   <li>{@link PurchaseList#setPurchaseNumber(String)}
   *   <li>{@link PurchaseList#setRemarks(String)}
   *   <li>{@link PurchaseList#setState(Integer)}
   *   <li>{@link PurchaseList#setSupplier(Supplier)}
   *   <li>{@link PurchaseList#setUser(User)}
   *   <li>{@link PurchaseList#setbPurchaseDate(Date)}
   *   <li>{@link PurchaseList#setePurchaseDate(Date)}
   *   <li>{@link PurchaseList#toString()}
   *   <li>{@link PurchaseList#getAmountPaid()}
   *   <li>{@link PurchaseList#getAmountPayable()}
   *   <li>{@link PurchaseList#getId()}
   *   <li>{@link PurchaseList#getPurchaseDate()}
   *   <li>{@link PurchaseList#getPurchaseListGoodsList()}
   *   <li>{@link PurchaseList#getPurchaseNumber()}
   *   <li>{@link PurchaseList#getRemarks()}
   *   <li>{@link PurchaseList#getState()}
   *   <li>{@link PurchaseList#getSupplier()}
   *   <li>{@link PurchaseList#getUser()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PurchaseList actualPurchaseList = new PurchaseList();
    actualPurchaseList.setAmountPaid(10.0f);
    actualPurchaseList.setAmountPayable(10.0f);
    actualPurchaseList.setId(1);
    Date purchaseDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualPurchaseList.setPurchaseDate(purchaseDate);
    ArrayList<PurchaseListGoods> purchaseListGoodsList = new ArrayList<>();
    actualPurchaseList.setPurchaseListGoodsList(purchaseListGoodsList);
    actualPurchaseList.setPurchaseNumber("42");
    actualPurchaseList.setRemarks("Remarks");
    actualPurchaseList.setState(1);
    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");
    actualPurchaseList.setSupplier(supplier);
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    actualPurchaseList.setUser(user);
    actualPurchaseList
        .setbPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualPurchaseList
        .setePurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualPurchaseList.toString();
    float actualAmountPaid = actualPurchaseList.getAmountPaid();
    float actualAmountPayable = actualPurchaseList.getAmountPayable();
    Integer actualId = actualPurchaseList.getId();
    Date actualPurchaseDate = actualPurchaseList.getPurchaseDate();
    List<PurchaseListGoods> actualPurchaseListGoodsList = actualPurchaseList.getPurchaseListGoodsList();
    String actualPurchaseNumber = actualPurchaseList.getPurchaseNumber();
    String actualRemarks = actualPurchaseList.getRemarks();
    Integer actualState = actualPurchaseList.getState();
    Supplier actualSupplier = actualPurchaseList.getSupplier();
    User actualUser = actualPurchaseList.getUser();

    // Assert that nothing has changed
    assertEquals("42", actualPurchaseNumber);
    assertEquals("Remarks", actualRemarks);
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualState.intValue());
    assertEquals(10.0f, actualAmountPaid, 0.0f);
    assertEquals(10.0f, actualAmountPayable, 0.0f);
    assertTrue(actualPurchaseListGoodsList.isEmpty());
    assertSame(supplier, actualSupplier);
    assertSame(user, actualUser);
    assertSame(purchaseListGoodsList, actualPurchaseListGoodsList);
    assertSame(purchaseDate, actualPurchaseDate);
  }
}
