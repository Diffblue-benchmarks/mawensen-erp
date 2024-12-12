package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

public class PurchaseListGoodsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PurchaseListGoods}
   *   <li>{@link PurchaseListGoods#setCode(String)}
   *   <li>{@link PurchaseListGoods#setCodeOrName(String)}
   *   <li>{@link PurchaseListGoods#setGoodsId(Integer)}
   *   <li>{@link PurchaseListGoods#setId(Integer)}
   *   <li>{@link PurchaseListGoods#setModel(String)}
   *   <li>{@link PurchaseListGoods#setName(String)}
   *   <li>{@link PurchaseListGoods#setNum(int)}
   *   <li>{@link PurchaseListGoods#setPrice(float)}
   *   <li>{@link PurchaseListGoods#setPurchaseList(PurchaseList)}
   *   <li>{@link PurchaseListGoods#setTotal(float)}
   *   <li>{@link PurchaseListGoods#setType(GoodsType)}
   *   <li>{@link PurchaseListGoods#setTypeId(Integer)}
   *   <li>{@link PurchaseListGoods#setUnit(String)}
   *   <li>{@link PurchaseListGoods#toString()}
   *   <li>{@link PurchaseListGoods#getCode()}
   *   <li>{@link PurchaseListGoods#getCodeOrName()}
   *   <li>{@link PurchaseListGoods#getGoodsId()}
   *   <li>{@link PurchaseListGoods#getId()}
   *   <li>{@link PurchaseListGoods#getModel()}
   *   <li>{@link PurchaseListGoods#getName()}
   *   <li>{@link PurchaseListGoods#getNum()}
   *   <li>{@link PurchaseListGoods#getPrice()}
   *   <li>{@link PurchaseListGoods#getPurchaseList()}
   *   <li>{@link PurchaseListGoods#getTotal()}
   *   <li>{@link PurchaseListGoods#getType()}
   *   <li>{@link PurchaseListGoods#getTypeId()}
   *   <li>{@link PurchaseListGoods#getUnit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PurchaseListGoods actualPurchaseListGoods = new PurchaseListGoods();
    actualPurchaseListGoods.setCode("Code");
    actualPurchaseListGoods.setCodeOrName("Code Or Name");
    actualPurchaseListGoods.setGoodsId(1);
    actualPurchaseListGoods.setId(1);
    actualPurchaseListGoods.setModel("Model");
    actualPurchaseListGoods.setName("Name");
    actualPurchaseListGoods.setNum(10);
    actualPurchaseListGoods.setPrice(10.0f);
    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    PurchaseList purchaseList = new PurchaseList();
    purchaseList.setAmountPaid(10.0f);
    purchaseList.setAmountPayable(10.0f);
    purchaseList.setId(1);
    purchaseList.setPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList.setPurchaseListGoodsList(new ArrayList<>());
    purchaseList.setPurchaseNumber("42");
    purchaseList.setRemarks("Remarks");
    purchaseList.setState(1);
    purchaseList.setSupplier(supplier);
    purchaseList.setUser(user);
    purchaseList
        .setbPurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    purchaseList
        .setePurchaseDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualPurchaseListGoods.setPurchaseList(purchaseList);
    actualPurchaseListGoods.setTotal(10.0f);
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);
    actualPurchaseListGoods.setType(type);
    actualPurchaseListGoods.setTypeId(1);
    actualPurchaseListGoods.setUnit("Unit");
    String actualToStringResult = actualPurchaseListGoods.toString();
    String actualCode = actualPurchaseListGoods.getCode();
    String actualCodeOrName = actualPurchaseListGoods.getCodeOrName();
    Integer actualGoodsId = actualPurchaseListGoods.getGoodsId();
    Integer actualId = actualPurchaseListGoods.getId();
    String actualModel = actualPurchaseListGoods.getModel();
    String actualName = actualPurchaseListGoods.getName();
    int actualNum = actualPurchaseListGoods.getNum();
    float actualPrice = actualPurchaseListGoods.getPrice();
    PurchaseList actualPurchaseList = actualPurchaseListGoods.getPurchaseList();
    float actualTotal = actualPurchaseListGoods.getTotal();
    GoodsType actualType = actualPurchaseListGoods.getType();
    Integer actualTypeId = actualPurchaseListGoods.getTypeId();

    // Assert that nothing has changed
    assertEquals("Code Or Name", actualCodeOrName);
    assertEquals("Code", actualCode);
    assertEquals("Model", actualModel);
    assertEquals("Name", actualName);
    assertEquals(
        "PurchaseListGoods [id=1, code=Code, name=Name, model=Model, type=[id=1, name=Name, state=1, icon=Icon,"
            + " pId=1], unit=Unit, price=10.0, num=10, total=10.0]",
        actualToStringResult);
    assertEquals("Unit", actualPurchaseListGoods.getUnit());
    assertEquals(1, actualGoodsId.intValue());
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualTypeId.intValue());
    assertEquals(10, actualNum);
    assertEquals(10.0f, actualPrice, 0.0f);
    assertEquals(10.0f, actualTotal, 0.0f);
    assertSame(type, actualType);
    assertSame(purchaseList, actualPurchaseList);
  }
}
