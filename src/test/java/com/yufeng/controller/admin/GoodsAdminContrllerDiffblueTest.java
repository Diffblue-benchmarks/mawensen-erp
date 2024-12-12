package com.yufeng.controller.admin;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Goods;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.Log;
import com.yufeng.service.CustomerReturnListGoodsService;
import com.yufeng.service.GoodsService;
import com.yufeng.service.LogService;
import com.yufeng.service.SaleListGoodsService;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {GoodsAdminContrller.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class GoodsAdminContrllerDiffblueTest {
  @MockBean
  private CustomerReturnListGoodsService customerReturnListGoodsService;

  @Autowired
  private GoodsAdminContrller goodsAdminContrller;

  @MockBean
  private GoodsService goodsService;

  @MockBean
  private LogService logService;

  @MockBean
  private SaleListGoodsService saleListGoodsService;

  /**
   * Test {@link GoodsAdminContrller#list(Goods, Integer, Integer)}.
   * <p>
   * Method under test: {@link GoodsAdminContrller#list(Goods, Integer, Integer)}
   */
  @Test
  public void testList() throws Exception {
    // Arrange
    when(goodsService.getCount(Mockito.<Goods>any())).thenReturn(3L);
    when(goodsService.list(Mockito.<Goods>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Sort.Direction>any(), (String[]) any())).thenReturn(new ArrayList<>());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goods/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"total\":3,\"rows\":[]}"));
  }

  /**
   * Test {@link GoodsAdminContrller#listInventory(Goods, Integer, Integer)}.
   * <p>
   * Method under test:
   * {@link GoodsAdminContrller#listInventory(Goods, Integer, Integer)}
   */
  @Test
  public void testListInventory() throws Exception {
    // Arrange
    when(goodsService.getCount(Mockito.<Goods>any())).thenReturn(3L);
    when(goodsService.list(Mockito.<Goods>any(), Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Sort.Direction>any(), (String[]) any())).thenReturn(new ArrayList<>());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goods/listInventory");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"total\":3,\"rows\":[]}"));
  }

  /**
   * Test {@link GoodsAdminContrller#listAlart()}.
   * <p>
   * Method under test: {@link GoodsAdminContrller#listAlart()}
   */
  @Test
  public void testListAlart() throws Exception {
    // Arrange
    when(goodsService.listAlarm()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goods/listAlarm");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"rows\":[]}"));
  }

  /**
   * Test
   * {@link GoodsAdminContrller#listNoInventoryQuantity(String, Integer, Integer)}.
   * <p>
   * Method under test:
   * {@link GoodsAdminContrller#listNoInventoryQuantity(String, Integer, Integer)}
   */
  @Test
  public void testListNoInventoryQuantity() throws Exception {
    // Arrange
    when(goodsService.getCountNoInventoryQuantityByCodeOrName(Mockito.<String>any())).thenReturn(3L);
    when(goodsService.listNoInventoryQuantityByCodeOrName(Mockito.<String>any(), Mockito.<Integer>any(),
        Mockito.<Integer>any(), Mockito.<Sort.Direction>any(), (String[]) any())).thenReturn(new ArrayList<>());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goods/listNoInventoryQuantity");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"total\":3,\"rows\":[]}"));
  }

  /**
   * Test {@link GoodsAdminContrller#listHasInventoryQuantity(Integer, Integer)}.
   * <p>
   * Method under test:
   * {@link GoodsAdminContrller#listHasInventoryQuantity(Integer, Integer)}
   */
  @Test
  public void testListHasInventoryQuantity() throws Exception {
    // Arrange
    when(goodsService.getCountHasInventoryQuantity()).thenReturn(3L);
    when(goodsService.listHasInventoryQuantity(Mockito.<Integer>any(), Mockito.<Integer>any(),
        Mockito.<Sort.Direction>any(), (String[]) any())).thenReturn(new ArrayList<>());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goods/listHasInventoryQuantity");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"total\":3,\"rows\":[]}"));
  }

  /**
   * Test {@link GoodsAdminContrller#deleteStock(Integer)}.
   * <ul>
   *   <li>Given {@link Goods} (default constructor) State is one.</li>
   *   <li>Then content string {@code {"success":true}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoodsAdminContrller#deleteStock(Integer)}
   */
  @Test
  public void testDeleteStock_givenGoodsStateIsOne_thenContentStringSuccessTrue() throws Exception {
    // Arrange
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    Goods goods = new Goods();
    goods.setCode("Code");
    goods.setCodeOrName("Code Or Name");
    goods.setId(1);
    goods.setInventoryQuantity(1);
    goods.setLastPurchasingPrice(10.0f);
    goods.setMinNum(1);
    goods.setModel("Model");
    goods.setName("Name");
    goods.setProducer("Producer");
    goods.setPurchasingPrice(10.0f);
    goods.setRemarks("Remarks");
    goods.setSaleTotal(1);
    goods.setSellingPrice(10.0f);
    goods.setState(1);
    goods.setType(type);
    goods.setUnit("Unit");
    doNothing().when(goodsService).save(Mockito.<Goods>any());
    when(goodsService.findById(Mockito.<Integer>any())).thenReturn(goods);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/goods/deleteStock");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link GoodsAdminContrller#deleteStock(Integer)}.
   * <ul>
   *   <li>Given {@link Goods} (default constructor) State is two.</li>
   *   <li>Then content string
   * {@code {"success":false,"errorInfo":"该商品已经发生单据，不能删除！"}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoodsAdminContrller#deleteStock(Integer)}
   */
  @Test
  public void testDeleteStock_givenGoodsStateIsTwo_thenContentStringSuccessFalseErrorInfo() throws Exception {
    // Arrange
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    Goods goods = new Goods();
    goods.setCode("Code");
    goods.setCodeOrName("Code Or Name");
    goods.setId(1);
    goods.setInventoryQuantity(1);
    goods.setLastPurchasingPrice(10.0f);
    goods.setMinNum(1);
    goods.setModel("Model");
    goods.setName("Name");
    goods.setProducer("Producer");
    goods.setPurchasingPrice(10.0f);
    goods.setRemarks("Remarks");
    goods.setSaleTotal(1);
    goods.setSellingPrice(10.0f);
    goods.setState(2);
    goods.setType(type);
    goods.setUnit("Unit");
    doNothing().when(goodsService).save(Mockito.<Goods>any());
    when(goodsService.findById(Mockito.<Integer>any())).thenReturn(goods);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/goods/deleteStock");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":false,\"errorInfo\":\"该商品已经发生单据，不能删除！\"}"));
  }

  /**
   * Test {@link GoodsAdminContrller#genGoodsCode()}.
   * <ul>
   *   <li>Given {@link GoodsService} {@link GoodsService#getMaxGoodsCode()} return
   * {@code 42}.</li>
   *   <li>Then content string {@code 0043}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoodsAdminContrller#genGoodsCode()}
   */
  @Test
  public void testGenGoodsCode_givenGoodsServiceGetMaxGoodsCodeReturn42_thenContentString0043() throws Exception {
    // Arrange
    when(goodsService.getMaxGoodsCode()).thenReturn("42");
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goods/genGoodsCode");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("0043"));
  }

  /**
   * Test {@link GoodsAdminContrller#genGoodsCode()}.
   * <ul>
   *   <li>Then content string {@code 0001}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoodsAdminContrller#genGoodsCode()}
   */
  @Test
  public void testGenGoodsCode_thenContentString0001() throws Exception {
    // Arrange
    when(goodsService.getMaxGoodsCode()).thenReturn("");
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goods/genGoodsCode");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("0001"));
  }

  /**
   * Test {@link GoodsAdminContrller#save(Goods)}.
   * <p>
   * Method under test: {@link GoodsAdminContrller#save(Goods)}
   */
  @Test
  public void testSave() throws Exception {
    // Arrange
    doNothing().when(goodsService).save(Mockito.<Goods>any());
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/goods/save");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link GoodsAdminContrller#saveStore(Integer, Integer, Float)}.
   * <p>
   * Method under test:
   * {@link GoodsAdminContrller#saveStore(Integer, Integer, Float)}
   */
  @Test
  public void testSaveStore() throws Exception {
    // Arrange
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    Goods goods = new Goods();
    goods.setCode("Code");
    goods.setCodeOrName("Code Or Name");
    goods.setId(1);
    goods.setInventoryQuantity(1);
    goods.setLastPurchasingPrice(10.0f);
    goods.setMinNum(1);
    goods.setModel("Model");
    goods.setName("Name");
    goods.setProducer("Producer");
    goods.setPurchasingPrice(10.0f);
    goods.setRemarks("Remarks");
    goods.setSaleTotal(1);
    goods.setSellingPrice(10.0f);
    goods.setState(1);
    goods.setType(type);
    goods.setUnit("Unit");
    doNothing().when(goodsService).save(Mockito.<Goods>any());
    when(goodsService.findById(Mockito.<Integer>any())).thenReturn(goods);
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/goods/saveStore");
    MockHttpServletRequestBuilder paramResult = getResult.param("id", String.valueOf(1));
    MockHttpServletRequestBuilder paramResult2 = paramResult.param("num", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder = paramResult2.param("price", String.valueOf(10.0f));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }

  /**
   * Test {@link GoodsAdminContrller#delete(Integer)}.
   * <ul>
   *   <li>Given {@link Goods} (default constructor) State is one.</li>
   *   <li>Then content string
   * {@code {"success":false,"errorInfo":"该商品已经期初入库，不能删除！"}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoodsAdminContrller#delete(Integer)}
   */
  @Test
  public void testDelete_givenGoodsStateIsOne_thenContentStringSuccessFalseErrorInfo() throws Exception {
    // Arrange
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    Goods goods = new Goods();
    goods.setCode("Code");
    goods.setCodeOrName("Code Or Name");
    goods.setId(1);
    goods.setInventoryQuantity(1);
    goods.setLastPurchasingPrice(10.0f);
    goods.setMinNum(1);
    goods.setModel("Model");
    goods.setName("Name");
    goods.setProducer("Producer");
    goods.setPurchasingPrice(10.0f);
    goods.setRemarks("Remarks");
    goods.setSaleTotal(1);
    goods.setSellingPrice(10.0f);
    goods.setState(1);
    goods.setType(type);
    goods.setUnit("Unit");
    when(goodsService.findById(Mockito.<Integer>any())).thenReturn(goods);
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/goods/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":false,\"errorInfo\":\"该商品已经期初入库，不能删除！\"}"));
  }

  /**
   * Test {@link GoodsAdminContrller#delete(Integer)}.
   * <ul>
   *   <li>Given {@link Goods} (default constructor) State is two.</li>
   *   <li>Then content string
   * {@code {"success":false,"errorInfo":"该商品已经发生单据，不能删除！"}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoodsAdminContrller#delete(Integer)}
   */
  @Test
  public void testDelete_givenGoodsStateIsTwo_thenContentStringSuccessFalseErrorInfo() throws Exception {
    // Arrange
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    Goods goods = new Goods();
    goods.setCode("Code");
    goods.setCodeOrName("Code Or Name");
    goods.setId(1);
    goods.setInventoryQuantity(1);
    goods.setLastPurchasingPrice(10.0f);
    goods.setMinNum(1);
    goods.setModel("Model");
    goods.setName("Name");
    goods.setProducer("Producer");
    goods.setPurchasingPrice(10.0f);
    goods.setRemarks("Remarks");
    goods.setSaleTotal(1);
    goods.setSellingPrice(10.0f);
    goods.setState(2);
    goods.setType(type);
    goods.setUnit("Unit");
    doNothing().when(goodsService).delete(Mockito.<Integer>any());
    when(goodsService.findById(Mockito.<Integer>any())).thenReturn(goods);
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/goods/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":false,\"errorInfo\":\"该商品已经发生单据，不能删除！\"}"));
  }

  /**
   * Test {@link GoodsAdminContrller#delete(Integer)}.
   * <ul>
   *   <li>Given {@link Goods} (default constructor) State is zero.</li>
   *   <li>Then content string {@code {"success":true}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GoodsAdminContrller#delete(Integer)}
   */
  @Test
  public void testDelete_givenGoodsStateIsZero_thenContentStringSuccessTrue() throws Exception {
    // Arrange
    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    Goods goods = new Goods();
    goods.setCode("Code");
    goods.setCodeOrName("Code Or Name");
    goods.setId(1);
    goods.setInventoryQuantity(1);
    goods.setLastPurchasingPrice(10.0f);
    goods.setMinNum(1);
    goods.setModel("Model");
    goods.setName("Name");
    goods.setProducer("Producer");
    goods.setPurchasingPrice(10.0f);
    goods.setRemarks("Remarks");
    goods.setSaleTotal(1);
    goods.setSellingPrice(10.0f);
    goods.setState(0);
    goods.setType(type);
    goods.setUnit("Unit");
    doNothing().when(goodsService).delete(Mockito.<Integer>any());
    when(goodsService.findById(Mockito.<Integer>any())).thenReturn(goods);
    doNothing().when(logService).save(Mockito.<Log>any());
    MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admin/goods/delete");
    MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(goodsAdminContrller)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"success\":true}"));
  }
}
