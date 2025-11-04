package com.yufeng.controller;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.apache.catalina.ssi.ByteArrayServletOutputStream;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class DrawImageControllerDiffblueTest {
  /**
   * Method under test:
   * {@link DrawImageController#drawImage(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testDrawImage() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DrawImageController drawImageController = new DrawImageController();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getSession()).thenReturn(new MockHttpSession());
    doNothing().when(request).setCharacterEncoding(Mockito.<String>any());
    AddDefaultCharsetFilter.ResponseWrapper response = mock(AddDefaultCharsetFilter.ResponseWrapper.class);
    when(response.getOutputStream()).thenReturn(new ByteArrayServletOutputStream());
    doNothing().when(response).setDateHeader(Mockito.<String>any(), anyLong());
    doNothing().when(response).setHeader(Mockito.<String>any(), Mockito.<String>any());
    doNothing().when(response).setContentType(Mockito.<String>any());

    // Act
    drawImageController.drawImage(request, response);

    // Assert
    verify(request).setCharacterEncoding(Mockito.<String>any());
    verify(response).getOutputStream();
    verify(request).getSession();
    verify(response).setDateHeader(Mockito.<String>any(), anyLong());
    verify(response, atLeast(1)).setHeader(Mockito.<String>any(), Mockito.<String>any());
    verify(response, atLeast(1)).setContentType(Mockito.<String>any());
  }
}
