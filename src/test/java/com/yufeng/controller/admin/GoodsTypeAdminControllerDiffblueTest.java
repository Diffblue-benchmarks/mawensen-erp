package com.yufeng.controller.admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.Log;
import com.yufeng.service.GoodsTypeService;
import com.yufeng.service.LogService;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {GoodsTypeAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsTypeAdminControllerDiffblueTest {
  @Autowired private GoodsTypeAdminController goodsTypeAdminController;

  @MockBean private GoodsTypeService goodsTypeService;

  @MockBean private LogService logService;

  /**
   * Test {@link GoodsTypeAdminController#loadTreeInfo()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link GoodsTypeAdminController#loadTreeInfo()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String GoodsTypeAdminController.loadTreeInfo()"})
  public void testLoadTreeInfo_thenStatusIsOk() throws Exception {
    // Arrange
    when(goodsTypeService.findByParentId(anyInt())).thenReturn(new ArrayList<>());
    doNothing().when(logService).save(Mockito.<Log>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/admin/goodsType/loadTreeInfo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsTypeAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link GoodsTypeAdminController#save(String, Integer)}.
   *
   * <p>Method under test: {@link GoodsTypeAdminController#save(String, Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map GoodsTypeAdminController.save(String, Integer)"})
  public void testSave() throws Exception {
    // Arrange
    GoodsType goodsType = new GoodsType();
    goodsType.setIcon("Icon");
    goodsType.setId(1);
    goodsType.setName("Name");
    goodsType.setState(1);
    goodsType.setpId(1);
    when(goodsTypeService.findById(Mockito.<Integer>any())).thenReturn(goodsType);
    doNothing().when(goodsTypeService).save(Mockito.<GoodsType>any());
    doNothing().when(logService).save(Mockito.<Log>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/goodsType/save")
            .param("name", "foo")
            .param("parentId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsTypeAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"success\":true}"));
  }

  /**
   * Test {@link GoodsTypeAdminController#delete(Integer)}.
   *
   * <p>Method under test: {@link GoodsTypeAdminController#delete(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map GoodsTypeAdminController.delete(Integer)"})
  public void testDelete() throws Exception {
    // Arrange
    GoodsType goodsType = new GoodsType();
    goodsType.setIcon("Icon");
    goodsType.setId(1);
    goodsType.setName("Name");
    goodsType.setState(1);
    goodsType.setpId(1);
    when(goodsTypeService.findByParentId(anyInt())).thenReturn(new ArrayList<>());
    doNothing().when(goodsTypeService).delete(Mockito.<Integer>any());
    when(goodsTypeService.findById(Mockito.<Integer>any())).thenReturn(goodsType);
    doNothing().when(logService).save(Mockito.<Log>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/goodsType/delete").param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsTypeAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"success\":true}"));
  }

  /**
   * Test {@link GoodsTypeAdminController#delete(Integer)}.
   *
   * <ul>
   *   <li>Given {@link GoodsType} (default constructor) Icon is {@code admin}.
   * </ul>
   *
   * <p>Method under test: {@link GoodsTypeAdminController#delete(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map GoodsTypeAdminController.delete(Integer)"})
  public void testDelete_givenGoodsTypeIconIsAdmin() throws Exception {
    // Arrange
    GoodsType goodsType = new GoodsType();
    goodsType.setIcon("Icon");
    goodsType.setId(1);
    goodsType.setName("Name");
    goodsType.setState(1);
    goodsType.setpId(1);

    GoodsType goodsType2 = new GoodsType();
    goodsType2.setIcon("admin");
    goodsType2.setId(1);
    goodsType2.setName("admin");
    goodsType2.setState(1);
    goodsType2.setpId(1);

    ArrayList<GoodsType> goodsTypeList = new ArrayList<>();
    goodsTypeList.add(goodsType2);
    doNothing().when(goodsTypeService).save(Mockito.<GoodsType>any());
    when(goodsTypeService.findByParentId(anyInt())).thenReturn(goodsTypeList);
    doNothing().when(goodsTypeService).delete(Mockito.<Integer>any());
    when(goodsTypeService.findById(Mockito.<Integer>any())).thenReturn(goodsType);
    doNothing().when(logService).save(Mockito.<Log>any());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/admin/goodsType/delete").param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsTypeAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(content().string("{\"success\":true}"));
  }

  /**
   * Test {@link GoodsTypeAdminController#getAllByParentId(Integer)}.
   *
   * <ul>
   *   <li>Given {@link GoodsType} (default constructor) Id is {@code null}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link GoodsTypeAdminController#getAllByParentId(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonArray GoodsTypeAdminController.getAllByParentId(Integer)"})
  public void testGetAllByParentId_givenGoodsTypeIdIsNull_thenReturnSizeIsOne() {
    // Arrange
    GoodsType goodsType = new GoodsType();
    goodsType.setIcon("Icon");
    goodsType.setId(null);
    goodsType.setName("Name");
    goodsType.setState(0);
    goodsType.setpId(1);

    ArrayList<GoodsType> goodsTypeList = new ArrayList<>();
    goodsTypeList.add(goodsType);
    when(goodsTypeService.findByParentId(anyInt())).thenReturn(goodsTypeList);

    // Act
    JsonArray actualAllByParentId = goodsTypeAdminController.getAllByParentId(1);

    // Assert
    verify(goodsTypeService).findByParentId(anyInt());
    Iterator<JsonElement> iteratorResult = actualAllByParentId.iterator();
    JsonElement nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof JsonObject);
    assertEquals(1, actualAllByParentId.size());
    assertEquals(5, ((JsonObject) nextResult).size());
    assertFalse(nextResult.isJsonArray());
    assertFalse(nextResult.isJsonNull());
    assertFalse(nextResult.isJsonPrimitive());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isJsonObject());
    assertSame(nextResult, nextResult.getAsJsonObject());
  }

  /**
   * Test {@link GoodsTypeAdminController#getAllByParentId(Integer)}.
   *
   * <ul>
   *   <li>Then return size is zero.
   * </ul>
   *
   * <p>Method under test: {@link GoodsTypeAdminController#getAllByParentId(Integer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonArray GoodsTypeAdminController.getAllByParentId(Integer)"})
  public void testGetAllByParentId_thenReturnSizeIsZero() {
    // Arrange
    when(goodsTypeService.findByParentId(anyInt())).thenReturn(new ArrayList<>());

    // Act
    JsonArray actualAllByParentId = goodsTypeAdminController.getAllByParentId(1);

    // Assert
    verify(goodsTypeService).findByParentId(anyInt());
    assertEquals(0, actualAllByParentId.size());
    assertFalse(actualAllByParentId.isJsonNull());
    assertFalse(actualAllByParentId.isJsonObject());
    assertFalse(actualAllByParentId.isJsonPrimitive());
    assertFalse(actualAllByParentId.iterator().hasNext());
    assertTrue(actualAllByParentId.isJsonArray());
    JsonArray actualAsJsonArray = actualAllByParentId.getAsJsonArray();
    assertSame(actualAllByParentId, actualAsJsonArray);
  }
}
