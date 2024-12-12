package com.yufeng.controller.admin;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.yufeng.entity.GoodsUnit;
import com.yufeng.entity.Log;
import com.yufeng.service.GoodsUnitService;
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

@ContextConfiguration(classes = {GoodsUnitAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsUnitAdminControllerDiffblueTest {
  @Autowired
  private GoodsUnitAdminController goodsUnitAdminController;

  @MockBean
  private GoodsUnitService goodsUnitService;

  @MockBean
  private LogService logService;

  /**
   * Test {@link GoodsUnitAdminController#comboList()}.
   * <p>
   * Method under test: {@link GoodsUnitAdminController#comboList()}
   */
  @Test
  public void testComboList() throws Exception {
    // Arrange
    when(goodsUnitService.listAll()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goodsUnit/comboList");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsUnitAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Test {@link GoodsUnitAdminController#listAll()}.
   * <p>
   * Method under test: {@link GoodsUnitAdminController#listAll()}
   */
  @Test
  public void testListAll() throws Exception {
    // Arrange
    when(goodsUnitService.listAll()).thenReturn(new ArrayList<>());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goodsUnit/listAll");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsUnitAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test {@link GoodsUnitAdminController#save(GoodsUnit)}.
   * <p>
   * Method under test: {@link GoodsUnitAdminController#save(GoodsUnit)}
   */
  @Test
  public void testSave() throws Exception {
    // Arrange
    doNothing().when(goodsUnitService).save(Mockito.<GoodsUnit>any());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goodsUnit/save");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsUnitAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link GoodsUnitAdminController#delete(Integer)}.
   * <p>
   * Method under test: {@link GoodsUnitAdminController#delete(Integer)}
   */
  @Test
  public void testDelete() throws Exception {
    // Arrange
    GoodsUnit goodsUnit = new GoodsUnit();
    goodsUnit.setId(1);
    goodsUnit.setName("Name");
    when(goodsUnitService.findById(Mockito.<Integer>any())).thenReturn(goodsUnit);
    doNothing().when(goodsUnitService).delete(Mockito.<Integer>any());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/goodsUnit/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsUnitAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }
}
