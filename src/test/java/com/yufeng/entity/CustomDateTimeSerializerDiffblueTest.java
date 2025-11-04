package com.yufeng.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomDateTimeSerializerDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link CustomDateTimeSerializer}
   */
  @Test
  public void testNewCustomDateTimeSerializer() {
    // Arrange and Act
    CustomDateTimeSerializer actualCustomDateTimeSerializer = new CustomDateTimeSerializer();

    // Assert
    assertNull(actualCustomDateTimeSerializer.getDelegatee());
    assertFalse(actualCustomDateTimeSerializer.isUnwrappingSerializer());
  }

  /**
   * Method under test:
   * {@link CustomDateTimeSerializer#serialize(Date, JsonGenerator, SerializerProvider)}
   */
  @Test
  public void testSerialize() throws IOException {
    // Arrange
    CustomDateTimeSerializer customDateTimeSerializer = new CustomDateTimeSerializer();
    Date value = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    // Act
    customDateTimeSerializer.serialize(value, gen, new DefaultSerializerProvider.Impl());

    // Assert
    verify(d).writeString(Mockito.<String>any());
  }
}
