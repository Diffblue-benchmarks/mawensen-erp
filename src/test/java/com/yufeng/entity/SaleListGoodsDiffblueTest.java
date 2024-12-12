package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

public class SaleListGoodsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SaleListGoods}
   *   <li>{@link SaleListGoods#setCode(String)}
   *   <li>{@link SaleListGoods#setCodeOrName(String)}
   *   <li>{@link SaleListGoods#setGoodsId(Integer)}
   *   <li>{@link SaleListGoods#setId(Integer)}
   *   <li>{@link SaleListGoods#setModel(String)}
   *   <li>{@link SaleListGoods#setName(String)}
   *   <li>{@link SaleListGoods#setNum(int)}
   *   <li>{@link SaleListGoods#setPrice(float)}
   *   <li>{@link SaleListGoods#setSaleList(SaleList)}
   *   <li>{@link SaleListGoods#setTotal(float)}
   *   <li>{@link SaleListGoods#setType(GoodsType)}
   *   <li>{@link SaleListGoods#setTypeId(Integer)}
   *   <li>{@link SaleListGoods#setUnit(String)}
   *   <li>{@link SaleListGoods#toString()}
   *   <li>{@link SaleListGoods#getCode()}
   *   <li>{@link SaleListGoods#getCodeOrName()}
   *   <li>{@link SaleListGoods#getGoodsId()}
   *   <li>{@link SaleListGoods#getId()}
   *   <li>{@link SaleListGoods#getModel()}
   *   <li>{@link SaleListGoods#getName()}
   *   <li>{@link SaleListGoods#getNum()}
   *   <li>{@link SaleListGoods#getPrice()}
   *   <li>{@link SaleListGoods#getSaleList()}
   *   <li>{@link SaleListGoods#getTotal()}
   *   <li>{@link SaleListGoods#getType()}
   *   <li>{@link SaleListGoods#getTypeId()}
   *   <li>{@link SaleListGoods#getUnit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SaleListGoods actualSaleListGoods = new SaleListGoods();
    actualSaleListGoods.setCode("Code");
    actualSaleListGoods.setCodeOrName("Code Or Name");
    actualSaleListGoods.setGoodsId(1);
    actualSaleListGoods.setId(1);
    actualSaleListGoods.setModel("Model");
    actualSaleListGoods.setName("Name");
    actualSaleListGoods.setNum(10);
    actualSaleListGoods.setPrice(10.0f);
    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    SaleList saleList = new SaleList();
    saleList.setAmountPaid(10.0f);
    saleList.setAmountPayable(10.0f);
    saleList.setCustomer(customer);
    saleList.setId(1);
    saleList.setRemarks("Remarks");
    saleList.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.setSaleListGoodsList(new ArrayList<>());
    saleList.setSaleNumber("42");
    saleList.setState(1);
    saleList.setUser(user);
    saleList.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualSaleListGoods.setSaleList(saleList);
    actualSaleListGoods.setTotal(10.0f);
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);
    actualSaleListGoods.setType(type);
    actualSaleListGoods.setTypeId(1);
    actualSaleListGoods.setUnit("Unit");
    String actualToStringResult = actualSaleListGoods.toString();
    String actualCode = actualSaleListGoods.getCode();
    String actualCodeOrName = actualSaleListGoods.getCodeOrName();
    Integer actualGoodsId = actualSaleListGoods.getGoodsId();
    Integer actualId = actualSaleListGoods.getId();
    String actualModel = actualSaleListGoods.getModel();
    String actualName = actualSaleListGoods.getName();
    int actualNum = actualSaleListGoods.getNum();
    float actualPrice = actualSaleListGoods.getPrice();
    SaleList actualSaleList = actualSaleListGoods.getSaleList();
    float actualTotal = actualSaleListGoods.getTotal();
    GoodsType actualType = actualSaleListGoods.getType();
    Integer actualTypeId = actualSaleListGoods.getTypeId();

    // Assert that nothing has changed
    assertEquals("Code Or Name", actualCodeOrName);
    assertEquals("Code", actualCode);
    assertEquals("Model", actualModel);
    assertEquals("Name", actualName);
    assertEquals("SaleListGoods [id=1, code=Code, name=Name, model=Model, type=[id=1, name=Name, state=1, icon=Icon,"
        + " pId=1], unit=Unit, price=10.0, num=10, total=10.0]", actualToStringResult);
    assertEquals("Unit", actualSaleListGoods.getUnit());
    assertEquals(1, actualGoodsId.intValue());
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualTypeId.intValue());
    assertEquals(10, actualNum);
    assertEquals(10.0f, actualPrice, 0.0f);
    assertEquals(10.0f, actualTotal, 0.0f);
    assertSame(type, actualType);
    assertSame(saleList, actualSaleList);
  }
}
