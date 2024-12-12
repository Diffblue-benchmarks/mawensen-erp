package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

public class CustomerReturnListGoodsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerReturnListGoods}
   *   <li>{@link CustomerReturnListGoods#setCode(String)}
   *   <li>{@link CustomerReturnListGoods#setCodeOrName(String)}
   *   <li>{@link CustomerReturnListGoods#setCustomerReturnList(CustomerReturnList)}
   *   <li>{@link CustomerReturnListGoods#setGoodsId(Integer)}
   *   <li>{@link CustomerReturnListGoods#setId(Integer)}
   *   <li>{@link CustomerReturnListGoods#setModel(String)}
   *   <li>{@link CustomerReturnListGoods#setName(String)}
   *   <li>{@link CustomerReturnListGoods#setNum(int)}
   *   <li>{@link CustomerReturnListGoods#setPrice(float)}
   *   <li>{@link CustomerReturnListGoods#setTotal(float)}
   *   <li>{@link CustomerReturnListGoods#setType(GoodsType)}
   *   <li>{@link CustomerReturnListGoods#setTypeId(Integer)}
   *   <li>{@link CustomerReturnListGoods#setUnit(String)}
   *   <li>{@link CustomerReturnListGoods#toString()}
   *   <li>{@link CustomerReturnListGoods#getCode()}
   *   <li>{@link CustomerReturnListGoods#getCodeOrName()}
   *   <li>{@link CustomerReturnListGoods#getCustomerReturnList()}
   *   <li>{@link CustomerReturnListGoods#getGoodsId()}
   *   <li>{@link CustomerReturnListGoods#getId()}
   *   <li>{@link CustomerReturnListGoods#getModel()}
   *   <li>{@link CustomerReturnListGoods#getName()}
   *   <li>{@link CustomerReturnListGoods#getNum()}
   *   <li>{@link CustomerReturnListGoods#getPrice()}
   *   <li>{@link CustomerReturnListGoods#getTotal()}
   *   <li>{@link CustomerReturnListGoods#getType()}
   *   <li>{@link CustomerReturnListGoods#getTypeId()}
   *   <li>{@link CustomerReturnListGoods#getUnit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CustomerReturnListGoods actualCustomerReturnListGoods = new CustomerReturnListGoods();
    actualCustomerReturnListGoods.setCode("Code");
    actualCustomerReturnListGoods.setCodeOrName("Code Or Name");
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
    CustomerReturnList customerReturnList = new CustomerReturnList();
    customerReturnList.setAmountPaid(10.0f);
    customerReturnList.setAmountPayable(10.0f);
    customerReturnList.setCustomer(customer);
    customerReturnList
        .setCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList.setCustomerReturnListGoodsList(new ArrayList<>());
    customerReturnList.setCustomerReturnNumber("42");
    customerReturnList.setId(1);
    customerReturnList.setRemarks("Remarks");
    customerReturnList.setState(1);
    customerReturnList.setUser(user);
    customerReturnList
        .setbCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerReturnList
        .seteCustomerReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualCustomerReturnListGoods.setCustomerReturnList(customerReturnList);
    actualCustomerReturnListGoods.setGoodsId(1);
    actualCustomerReturnListGoods.setId(1);
    actualCustomerReturnListGoods.setModel("Model");
    actualCustomerReturnListGoods.setName("Name");
    actualCustomerReturnListGoods.setNum(10);
    actualCustomerReturnListGoods.setPrice(10.0f);
    actualCustomerReturnListGoods.setTotal(10.0f);
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);
    actualCustomerReturnListGoods.setType(type);
    actualCustomerReturnListGoods.setTypeId(1);
    actualCustomerReturnListGoods.setUnit("Unit");
    String actualToStringResult = actualCustomerReturnListGoods.toString();
    String actualCode = actualCustomerReturnListGoods.getCode();
    String actualCodeOrName = actualCustomerReturnListGoods.getCodeOrName();
    CustomerReturnList actualCustomerReturnList = actualCustomerReturnListGoods.getCustomerReturnList();
    Integer actualGoodsId = actualCustomerReturnListGoods.getGoodsId();
    Integer actualId = actualCustomerReturnListGoods.getId();
    String actualModel = actualCustomerReturnListGoods.getModel();
    String actualName = actualCustomerReturnListGoods.getName();
    int actualNum = actualCustomerReturnListGoods.getNum();
    float actualPrice = actualCustomerReturnListGoods.getPrice();
    float actualTotal = actualCustomerReturnListGoods.getTotal();
    GoodsType actualType = actualCustomerReturnListGoods.getType();
    Integer actualTypeId = actualCustomerReturnListGoods.getTypeId();

    // Assert that nothing has changed
    assertEquals("Code Or Name", actualCodeOrName);
    assertEquals("Code", actualCode);
    assertEquals("CustomerReturnListGoods [id=1, code=Code, name=Name, model=Model, type=[id=1, name=Name, state=1,"
        + " icon=Icon, pId=1], unit=Unit, price=10.0, num=10, total=10.0]", actualToStringResult);
    assertEquals("Model", actualModel);
    assertEquals("Name", actualName);
    assertEquals("Unit", actualCustomerReturnListGoods.getUnit());
    assertEquals(1, actualGoodsId.intValue());
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualTypeId.intValue());
    assertEquals(10, actualNum);
    assertEquals(10.0f, actualPrice, 0.0f);
    assertEquals(10.0f, actualTotal, 0.0f);
    assertSame(customerReturnList, actualCustomerReturnList);
    assertSame(type, actualType);
  }
}
