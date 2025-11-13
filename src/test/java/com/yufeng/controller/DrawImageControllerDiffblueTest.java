package com.yufeng.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class DrawImageControllerDiffblueTest {
  /**
   * Test {@link DrawImageController#drawImage(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames size is four.
   * </ul>
   *
   * <p>Method under test: {@link DrawImageController#drawImage(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DrawImageController.drawImage(HttpServletRequest, HttpServletResponse)"})
  public void testDrawImage_thenMockHttpServletResponseHeaderNamesSizeIsFour() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DrawImageController drawImageController = new DrawImageController();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    drawImageController.drawImage(request, response);

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(4, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("UTF-8", response.getCharacterEncoding());
    assertEquals("image/jpeg", response.getContentType());
    assertTrue(headerNames.contains("Cache-Control"));
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(headerNames.contains("Pragma"));
    assertTrue(headerNames.contains("expries"));
    assertTrue(response.isCharset());
  }
}
