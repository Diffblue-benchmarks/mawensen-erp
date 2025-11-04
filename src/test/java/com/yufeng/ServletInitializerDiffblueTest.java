package com.yufeng;

import static org.junit.Assert.assertSame;
import org.junit.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ServletInitializerDiffblueTest {
  /**
   * Method under test:
   * {@link ServletInitializer#configure(SpringApplicationBuilder)}
   */
  @Test
  public void testConfigure() {
    // Arrange
    ServletInitializer servletInitializer = new ServletInitializer();
    SpringApplicationBuilder application = new SpringApplicationBuilder("Sources");

    // Act and Assert
    assertSame(application, servletInitializer.configure(application));
  }
}
