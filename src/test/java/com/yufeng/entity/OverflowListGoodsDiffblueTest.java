package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class OverflowListGoodsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OverflowListGoods}
   *   <li>{@link OverflowListGoods#setCode(String)}
   *   <li>{@link OverflowListGoods#setGoodsId(Integer)}
   *   <li>{@link OverflowListGoods#setId(Integer)}
   *   <li>{@link OverflowListGoods#setModel(String)}
   *   <li>{@link OverflowListGoods#setName(String)}
   *   <li>{@link OverflowListGoods#setNum(int)}
   *   <li>{@link OverflowListGoods#setOverflowList(OverflowList)}
   *   <li>{@link OverflowListGoods#setPrice(float)}
   *   <li>{@link OverflowListGoods#setTotal(float)}
   *   <li>{@link OverflowListGoods#setType(GoodsType)}
   *   <li>{@link OverflowListGoods#setTypeId(Integer)}
   *   <li>{@link OverflowListGoods#setUnit(String)}
   *   <li>{@link OverflowListGoods#toString()}
   *   <li>{@link OverflowListGoods#getCode()}
   *   <li>{@link OverflowListGoods#getGoodsId()}
   *   <li>{@link OverflowListGoods#getId()}
   *   <li>{@link OverflowListGoods#getModel()}
   *   <li>{@link OverflowListGoods#getName()}
   *   <li>{@link OverflowListGoods#getNum()}
   *   <li>{@link OverflowListGoods#getOverflowList()}
   *   <li>{@link OverflowListGoods#getPrice()}
   *   <li>{@link OverflowListGoods#getTotal()}
   *   <li>{@link OverflowListGoods#getType()}
   *   <li>{@link OverflowListGoods#getTypeId()}
   *   <li>{@link OverflowListGoods#getUnit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OverflowListGoods actualOverflowListGoods = new OverflowListGoods();
    actualOverflowListGoods.setCode("Code");
    actualOverflowListGoods.setGoodsId(1);
    actualOverflowListGoods.setId(1);
    actualOverflowListGoods.setModel("Model");
    actualOverflowListGoods.setName("Name");
    actualOverflowListGoods.setNum(10);
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    OverflowList overflowList = new OverflowList();
    overflowList.setId(1);
    overflowList.setOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList.setOverflowNumber("42");
    overflowList.setRemarks("Remarks");
    overflowList.setUser(user);
    overflowList
        .setbOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    overflowList
        .seteOverflowDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualOverflowListGoods.setOverflowList(overflowList);
    actualOverflowListGoods.setPrice(10.0f);
    actualOverflowListGoods.setTotal(10.0f);
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);
    actualOverflowListGoods.setType(type);
    actualOverflowListGoods.setTypeId(1);
    actualOverflowListGoods.setUnit("Unit");
    String actualToStringResult = actualOverflowListGoods.toString();
    String actualCode = actualOverflowListGoods.getCode();
    Integer actualGoodsId = actualOverflowListGoods.getGoodsId();
    Integer actualId = actualOverflowListGoods.getId();
    String actualModel = actualOverflowListGoods.getModel();
    String actualName = actualOverflowListGoods.getName();
    int actualNum = actualOverflowListGoods.getNum();
    OverflowList actualOverflowList = actualOverflowListGoods.getOverflowList();
    float actualPrice = actualOverflowListGoods.getPrice();
    float actualTotal = actualOverflowListGoods.getTotal();
    GoodsType actualType = actualOverflowListGoods.getType();
    Integer actualTypeId = actualOverflowListGoods.getTypeId();

    // Assert that nothing has changed
    assertEquals("Code", actualCode);
    assertEquals("Model", actualModel);
    assertEquals("Name", actualName);
    assertEquals(
        "OverflowListGoods [id=1, code=Code, name=Name, model=Model, type=[id=1, name=Name, state=1, icon=Icon,"
            + " pId=1], unit=Unit, price=10.0, num=10, total=10.0]",
        actualToStringResult);
    assertEquals("Unit", actualOverflowListGoods.getUnit());
    assertEquals(1, actualGoodsId.intValue());
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualTypeId.intValue());
    assertEquals(10, actualNum);
    assertEquals(10.0f, actualPrice, 0.0f);
    assertEquals(10.0f, actualTotal, 0.0f);
    assertSame(type, actualType);
    assertSame(overflowList, actualOverflowList);
  }
}
