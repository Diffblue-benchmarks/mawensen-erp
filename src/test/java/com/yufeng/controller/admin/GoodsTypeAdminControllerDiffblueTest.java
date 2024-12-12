package com.yufeng.controller.admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonArray;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.Log;
import com.yufeng.service.GoodsTypeService;
import com.yufeng.service.LogService;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {GoodsTypeAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsTypeAdminControllerDiffblueTest {
  @Autowired
  private GoodsTypeAdminController goodsTypeAdminController;

  @MockBean
  private GoodsTypeService goodsTypeService;

  @MockBean
  private LogService logService;

  /**
   * Test {@link GoodsTypeAdminController#loadTreeInfo()}.
   * <p>
   * Method under test: {@link GoodsTypeAdminController#loadTreeInfo()}
   */
  @Test
  public void testLoadTreeInfo() throws Exception {
    // Arrange
    when(goodsTypeService.findByParentId(anyInt())).thenReturn(new ArrayList<>());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/goodsType/loadTreeInfo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsTypeAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Test {@link GoodsTypeAdminController#save(String, Integer)}.
   * <p>
   * Method under test: {@link GoodsTypeAdminController#save(String, Integer)}
   */
  @Test
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
    MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.get("/admin/goodsType/save")
        .param("name", "foo");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("parentId", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsTypeAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link GoodsTypeAdminController#delete(Integer)}.
   * <p>
   * Method under test: {@link GoodsTypeAdminController#delete(Integer)}
   */
  @Test
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
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/goodsType/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsTypeAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link GoodsTypeAdminController#delete(Integer)}.
   * <ul>
   *   <li>Given {@link GoodsType} (default constructor) Icon is {@code admin}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoodsTypeAdminController#delete(Integer)}
   */
  @Test
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
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/goodsType/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsTypeAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link GoodsTypeAdminController#getAllByParentId(Integer)}.
   * <ul>
   *   <li>Then return size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoodsTypeAdminController#getAllByParentId(Integer)}
   */
  @Test
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
    assertSame(actualAllByParentId, actualAllByParentId.getAsJsonArray());
  }
}
