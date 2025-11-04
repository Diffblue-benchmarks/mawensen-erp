package com.yufeng.controller.admin;

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.yufeng.entity.Log;
import com.yufeng.service.LogService;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {LogAdminController.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LogAdminControllerDiffblueTest {
  @Autowired
  private LogAdminController logAdminController;

  @MockBean
  private LogService logService;

  /**
   * Test {@link LogAdminController#list(Log, Integer, Integer)}.
   * <p>
   * Method under test: {@link LogAdminController#list(Log, Integer, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.util.Map LogAdminController.list(Log, Integer, Integer)"})
  public void testList() throws Exception {
    // Arrange
    when(logService.getCount(Mockito.<Log>any())).thenReturn(3L);
    when(logService.list(Mockito.<Log>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Direction>any(),
        (String[]) Mockito.any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/log/list");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(logAdminController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
        .andExpect(MockMvcResultMatchers.content().string("{\"total\":3,\"rows\":[]}"));
  }
}
