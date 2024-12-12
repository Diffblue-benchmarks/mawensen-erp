package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;

public class DamageListGoodsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DamageListGoods}
   *   <li>{@link DamageListGoods#setCode(String)}
   *   <li>{@link DamageListGoods#setDamageList(DamageList)}
   *   <li>{@link DamageListGoods#setGoodsId(Integer)}
   *   <li>{@link DamageListGoods#setId(Integer)}
   *   <li>{@link DamageListGoods#setModel(String)}
   *   <li>{@link DamageListGoods#setName(String)}
   *   <li>{@link DamageListGoods#setNum(int)}
   *   <li>{@link DamageListGoods#setPrice(float)}
   *   <li>{@link DamageListGoods#setTotal(float)}
   *   <li>{@link DamageListGoods#setType(GoodsType)}
   *   <li>{@link DamageListGoods#setTypeId(Integer)}
   *   <li>{@link DamageListGoods#setUnit(String)}
   *   <li>{@link DamageListGoods#toString()}
   *   <li>{@link DamageListGoods#getCode()}
   *   <li>{@link DamageListGoods#getDamageList()}
   *   <li>{@link DamageListGoods#getGoodsId()}
   *   <li>{@link DamageListGoods#getId()}
   *   <li>{@link DamageListGoods#getModel()}
   *   <li>{@link DamageListGoods#getName()}
   *   <li>{@link DamageListGoods#getNum()}
   *   <li>{@link DamageListGoods#getPrice()}
   *   <li>{@link DamageListGoods#getTotal()}
   *   <li>{@link DamageListGoods#getType()}
   *   <li>{@link DamageListGoods#getTypeId()}
   *   <li>{@link DamageListGoods#getUnit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DamageListGoods actualDamageListGoods = new DamageListGoods();
    actualDamageListGoods.setCode("Code");
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    DamageList damageList = new DamageList();
    damageList.setDamageDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.setDamageNumber("42");
    damageList.setId(1);
    damageList.setRemarks("Remarks");
    damageList.setUser(user);
    damageList.setbDamageDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    damageList.seteDamageDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    actualDamageListGoods.setDamageList(damageList);
    actualDamageListGoods.setGoodsId(1);
    actualDamageListGoods.setId(1);
    actualDamageListGoods.setModel("Model");
    actualDamageListGoods.setName("Name");
    actualDamageListGoods.setNum(10);
    actualDamageListGoods.setPrice(10.0f);
    actualDamageListGoods.setTotal(10.0f);
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);
    actualDamageListGoods.setType(type);
    actualDamageListGoods.setTypeId(1);
    actualDamageListGoods.setUnit("Unit");
    String actualToStringResult = actualDamageListGoods.toString();
    String actualCode = actualDamageListGoods.getCode();
    DamageList actualDamageList = actualDamageListGoods.getDamageList();
    Integer actualGoodsId = actualDamageListGoods.getGoodsId();
    Integer actualId = actualDamageListGoods.getId();
    String actualModel = actualDamageListGoods.getModel();
    String actualName = actualDamageListGoods.getName();
    int actualNum = actualDamageListGoods.getNum();
    float actualPrice = actualDamageListGoods.getPrice();
    float actualTotal = actualDamageListGoods.getTotal();
    GoodsType actualType = actualDamageListGoods.getType();
    Integer actualTypeId = actualDamageListGoods.getTypeId();

    // Assert that nothing has changed
    assertEquals("Code", actualCode);
    assertEquals("DamageListGoods [id=1, code=Code, name=Name, model=Model, type=[id=1, name=Name, state=1, icon=Icon,"
        + " pId=1], unit=Unit, price=10.0, num=10, total=10.0]", actualToStringResult);
    assertEquals("Model", actualModel);
    assertEquals("Name", actualName);
    assertEquals("Unit", actualDamageListGoods.getUnit());
    assertEquals(1, actualGoodsId.intValue());
    assertEquals(1, actualId.intValue());
    assertEquals(1, actualTypeId.intValue());
    assertEquals(10, actualNum);
    assertEquals(10.0f, actualPrice, 0.0f);
    assertEquals(10.0f, actualTotal, 0.0f);
    assertSame(damageList, actualDamageList);
    assertSame(type, actualType);
  }
}
