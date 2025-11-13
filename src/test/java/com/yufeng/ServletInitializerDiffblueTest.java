package com.yufeng;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ServletInitializerDiffblueTest {
  /**
   * Test {@link ServletInitializer#configure(SpringApplicationBuilder)}.
   *
   * <ul>
   *   <li>Then return {@link SpringApplicationBuilder#SpringApplicationBuilder(Object[])} with
   *       {@code Sources}.
   * </ul>
   *
   * <p>Method under test: {@link ServletInitializer#configure(SpringApplicationBuilder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SpringApplicationBuilder ServletInitializer.configure(SpringApplicationBuilder)"
  })
  public void testConfigure_thenReturnSpringApplicationBuilderWithSources() {
    // Arrange
    ServletInitializer servletInitializer = new ServletInitializer();
    SpringApplicationBuilder application = new SpringApplicationBuilder("Sources");

    // Act
    SpringApplicationBuilder actualConfigureResult = servletInitializer.configure(application);

    // Assert
    assertSame(application, actualConfigureResult);
  }
}
