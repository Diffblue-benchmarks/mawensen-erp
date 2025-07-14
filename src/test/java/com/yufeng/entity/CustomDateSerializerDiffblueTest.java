package com.yufeng.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class CustomDateSerializerDiffblueTest {
  /**
   * Test {@link CustomDateSerializer#serialize(Date, JsonGenerator, SerializerProvider)} with
   * {@code Date}, {@code JsonGenerator}, {@code SerializerProvider}.
   *
   * <ul>
   *   <li>Then calls {@link JsonGenerator#writeString(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomDateSerializer#serialize(Date, JsonGenerator,
   * SerializerProvider)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CustomDateSerializer.serialize(Date, JsonGenerator, SerializerProvider)"
  })
  public void testSerializeWithDateJsonGeneratorSerializerProvider_thenCallsWriteString()
      throws IOException {
    // Arrange
    CustomDateSerializer customDateSerializer = new CustomDateSerializer();
    Date value =
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).writeString(Mockito.<String>any());
    JsonGeneratorDelegate gen = new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true);

    // Act
    customDateSerializer.serialize(value, gen, new Impl());

    // Assert
    verify(d).writeString(Mockito.<String>any());
  }

  /**
   * Test new {@link CustomDateSerializer} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link CustomDateSerializer}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomDateSerializer.<init>()"})
  public void testNewCustomDateSerializer() {
    // Arrange and Act
    CustomDateSerializer actualCustomDateSerializer = new CustomDateSerializer();

    // Assert
    assertNull(actualCustomDateSerializer.getDelegatee());
    assertFalse(actualCustomDateSerializer.isUnwrappingSerializer());
  }
}
