package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

public class ReturnListGoodsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ReturnListGoods}
   *   <li>{@link ReturnListGoods#setCode(String)}
   *   <li>{@link ReturnListGoods#setCodeOrName(String)}
   *   <li>{@link ReturnListGoods#setGoodsId(Integer)}
   *   <li>{@link ReturnListGoods#setId(Integer)}
   *   <li>{@link ReturnListGoods#setModel(String)}
   *   <li>{@link ReturnListGoods#setName(String)}
   *   <li>{@link ReturnListGoods#setNum(int)}
   *   <li>{@link ReturnListGoods#setPrice(float)}
   *   <li>{@link ReturnListGoods#setReturnList(ReturnList)}
   *   <li>{@link ReturnListGoods#setTotal(float)}
   *   <li>{@link ReturnListGoods#setType(GoodsType)}
   *   <li>{@link ReturnListGoods#setTypeId(Integer)}
   *   <li>{@link ReturnListGoods#setUnit(String)}
   *   <li>{@link ReturnListGoods#toString()}
   *   <li>{@link ReturnListGoods#getCode()}
   *   <li>{@link ReturnListGoods#getCodeOrName()}
   *   <li>{@link ReturnListGoods#getGoodsId()}
   *   <li>{@link ReturnListGoods#getId()}
   *   <li>{@link ReturnListGoods#getModel()}
   *   <li>{@link ReturnListGoods#getName()}
   *   <li>{@link ReturnListGoods#getNum()}
   *   <li>{@link ReturnListGoods#getPrice()}
   *   <li>{@link ReturnListGoods#getReturnList()}
   *   <li>{@link ReturnListGoods#getTotal()}
   *   <li>{@link ReturnListGoods#getType()}
   *   <li>{@link ReturnListGoods#getTypeId()}
   *   <li>{@link ReturnListGoods#getUnit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReturnListGoods actualReturnListGoods = new ReturnListGoods();
    actualReturnListGoods.setCode("Code");
    actualReturnListGoods.setCodeOrName("Code Or Name");
    actualReturnListGoods.setGoodsId(1);
    actualReturnListGoods.setId(1);
    actualReturnListGoods.setModel("Model");
    actualReturnListGoods.setName("Name");
    actualReturnListGoods.setNum(10);
    actualReturnListGoods.setPrice(10.0f);
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
    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualReturnListGoods.setReturnList(returnList);
    actualReturnListGoods.setTotal(10.0f);
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);
    actualReturnListGoods.setType(type);
    actualReturnListGoods.setTypeId(1);
    actualReturnListGoods.setUnit("Unit");
    String actualToStringResult = actualReturnListGoods.toString();
    String actualCode = actualReturnListGoods.getCode();
    String actualCodeOrName = actualReturnListGoods.getCodeOrName();
    Integer actualGoodsId = actualReturnListGoods.getGoodsId();
    Integer actualId = actualReturnListGoods.getId();
    String actualModel = actualReturnListGoods.getModel();
    String actualName = actualReturnListGoods.getName();
    int actualNum = actualReturnListGoods.getNum();
    float actualPrice = actualReturnListGoods.getPrice();
    ReturnList actualReturnList = actualReturnListGoods.getReturnList();
    float actualTotal = actualReturnListGoods.getTotal();
    GoodsType actualType = actualReturnListGoods.getType();
    Integer actualTypeId = actualReturnListGoods.getTypeId();

    // Assert that nothing has changed
    assertEquals("Code Or Name", actualCodeOrName);
    assertEquals("Code", actualCode);
    assertEquals("Model", actualModel);
    assertEquals("Name", actualName);
    assertEquals("ReturnListGoods [id=1, code=Code, name=Name, model=Model, type=[id=1, name=Name, state=1, icon=Icon,"
        + " pId=1], unit=Unit, price=10.0, num=10, total=10.0]", actualToStringResult);
    assertEquals("Unit", actualReturnListGoods.getUnit());
    assertEquals(1, actualGoodsId.intValue());
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualTypeId.intValue());
    assertEquals(10, actualNum);
    assertEquals(10.0f, actualPrice, 0.0f);
    assertEquals(10.0f, actualTotal, 0.0f);
    assertSame(type, actualType);
    assertSame(returnList, actualReturnList);
  }
}
