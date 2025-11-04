package com.yufeng;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ServletInitializerDiffblueTest {
  /**
   * Test {@link ServletInitializer#configure(SpringApplicationBuilder)}.
   * <ul>
   *   <li>Then return {@link SpringApplicationBuilder#SpringApplicationBuilder(Object[])} with {@code Sources}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServletInitializer#configure(SpringApplicationBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SpringApplicationBuilder ServletInitializer.configure(SpringApplicationBuilder)"})
  public void testConfigure_thenReturnSpringApplicationBuilderWithSources() {
    // Arrange
    ServletInitializer servletInitializer = new ServletInitializer();
    SpringApplicationBuilder application = new SpringApplicationBuilder("Sources");

    // Act and Assert
    assertSame(application, servletInitializer.configure(application));
  }
}
