package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class GoodsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Goods}
   *   <li>{@link Goods#setCode(String)}
   *   <li>{@link Goods#setCodeOrName(String)}
   *   <li>{@link Goods#setId(Integer)}
   *   <li>{@link Goods#setInventoryQuantity(int)}
   *   <li>{@link Goods#setLastPurchasingPrice(float)}
   *   <li>{@link Goods#setMinNum(int)}
   *   <li>{@link Goods#setModel(String)}
   *   <li>{@link Goods#setName(String)}
   *   <li>{@link Goods#setProducer(String)}
   *   <li>{@link Goods#setPurchasingPrice(float)}
   *   <li>{@link Goods#setRemarks(String)}
   *   <li>{@link Goods#setSaleTotal(int)}
   *   <li>{@link Goods#setSellingPrice(float)}
   *   <li>{@link Goods#setState(int)}
   *   <li>{@link Goods#setType(GoodsType)}
   *   <li>{@link Goods#setUnit(String)}
   *   <li>{@link Goods#toString()}
   *   <li>{@link Goods#getCode()}
   *   <li>{@link Goods#getCodeOrName()}
   *   <li>{@link Goods#getId()}
   *   <li>{@link Goods#getInventoryQuantity()}
   *   <li>{@link Goods#getLastPurchasingPrice()}
   *   <li>{@link Goods#getMinNum()}
   *   <li>{@link Goods#getModel()}
   *   <li>{@link Goods#getName()}
   *   <li>{@link Goods#getProducer()}
   *   <li>{@link Goods#getPurchasingPrice()}
   *   <li>{@link Goods#getRemarks()}
   *   <li>{@link Goods#getSaleTotal()}
   *   <li>{@link Goods#getSellingPrice()}
   *   <li>{@link Goods#getState()}
   *   <li>{@link Goods#getType()}
   *   <li>{@link Goods#getUnit()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Goods.<init>()", "String Goods.getCode()", "String Goods.getCodeOrName()",
      "Integer Goods.getId()", "int Goods.getInventoryQuantity()", "float Goods.getLastPurchasingPrice()",
      "int Goods.getMinNum()", "String Goods.getModel()", "String Goods.getName()", "String Goods.getProducer()",
      "float Goods.getPurchasingPrice()", "String Goods.getRemarks()", "int Goods.getSaleTotal()",
      "float Goods.getSellingPrice()", "int Goods.getState()", "GoodsType Goods.getType()", "String Goods.getUnit()",
      "void Goods.setCode(String)", "void Goods.setCodeOrName(String)", "void Goods.setId(Integer)",
      "void Goods.setInventoryQuantity(int)", "void Goods.setLastPurchasingPrice(float)", "void Goods.setMinNum(int)",
      "void Goods.setModel(String)", "void Goods.setName(String)", "void Goods.setProducer(String)",
      "void Goods.setPurchasingPrice(float)", "void Goods.setRemarks(String)", "void Goods.setSaleTotal(int)",
      "void Goods.setSellingPrice(float)", "void Goods.setState(int)", "void Goods.setType(GoodsType)",
      "void Goods.setUnit(String)", "String Goods.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Goods actualGoods = new Goods();
    actualGoods.setCode("Code");
    actualGoods.setCodeOrName("Code Or Name");
    actualGoods.setId(1);
    actualGoods.setInventoryQuantity(1);
    actualGoods.setLastPurchasingPrice(10.0f);
    actualGoods.setMinNum(1);
    actualGoods.setModel("Model");
    actualGoods.setName("Name");
    actualGoods.setProducer("Producer");
    actualGoods.setPurchasingPrice(10.0f);
    actualGoods.setRemarks("Remarks");
    actualGoods.setSaleTotal(1);
    actualGoods.setSellingPrice(10.0f);
    actualGoods.setState(1);
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);
    actualGoods.setType(type);
    actualGoods.setUnit("Unit");
    String actualToStringResult = actualGoods.toString();
    String actualCode = actualGoods.getCode();
    String actualCodeOrName = actualGoods.getCodeOrName();
    Integer actualId = actualGoods.getId();
    int actualInventoryQuantity = actualGoods.getInventoryQuantity();
    float actualLastPurchasingPrice = actualGoods.getLastPurchasingPrice();
    int actualMinNum = actualGoods.getMinNum();
    String actualModel = actualGoods.getModel();
    String actualName = actualGoods.getName();
    String actualProducer = actualGoods.getProducer();
    float actualPurchasingPrice = actualGoods.getPurchasingPrice();
    String actualRemarks = actualGoods.getRemarks();
    int actualSaleTotal = actualGoods.getSaleTotal();
    float actualSellingPrice = actualGoods.getSellingPrice();
    int actualState = actualGoods.getState();
    GoodsType actualType = actualGoods.getType();

    // Assert
    assertEquals("Code Or Name", actualCodeOrName);
    assertEquals("Code", actualCode);
    assertEquals("Model", actualModel);
    assertEquals("Name", actualName);
    assertEquals("Producer", actualProducer);
    assertEquals("Remarks", actualRemarks);
    assertEquals("Unit", actualGoods.getUnit());
    assertEquals("[id=1, code=Code, name=Name, model=Model, unit=Unit, purchasingPrice=10.0, sellingPrice=10.0,"
        + " inventoryQuantity=1, minNum=1, producer=Producer, remarks=Remarks]", actualToStringResult);
    assertEquals(1, actualInventoryQuantity);
    assertEquals(1, actualMinNum);
    assertEquals(1, actualSaleTotal);
    assertEquals(1, actualState);
    assertEquals(1, actualId.intValue());
    assertEquals(10.0f, actualLastPurchasingPrice, 0.0f);
    assertEquals(10.0f, actualPurchasingPrice, 0.0f);
    assertEquals(10.0f, actualSellingPrice, 0.0f);
    assertSame(type, actualType);
  }
}
