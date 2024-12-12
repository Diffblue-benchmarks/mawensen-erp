package com.yufeng;

import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ServletInitializerDiffblueTest {
  /**
   * Test {@link ServletInitializer#configure(SpringApplicationBuilder)}.
   * <ul>
   *   <li>Then return
   * {@link SpringApplicationBuilder#SpringApplicationBuilder(Object[])} with
   * {@code Sources}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ServletInitializer#configure(SpringApplicationBuilder)}
   */
  @Test
  public void testConfigure_thenReturnSpringApplicationBuilderWithSources() {
    // Arrange
    ServletInitializer servletInitializer = new ServletInitializer();
    SpringApplicationBuilder application = new SpringApplicationBuilder("Sources");

    // Act and Assert
    assertSame(application, servletInitializer.configure(application));
  }
}
