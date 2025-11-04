package com.yufeng.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LogDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Log#Log()}
   *   <li>{@link Log#setBtime(Date)}
   *   <li>{@link Log#setContent(String)}
   *   <li>{@link Log#setEtime(Date)}
   *   <li>{@link Log#setId(Integer)}
   *   <li>{@link Log#setTime(Date)}
   *   <li>{@link Log#setType(String)}
   *   <li>{@link Log#setUser(User)}
   *   <li>{@link Log#getBtime()}
   *   <li>{@link Log#getContent()}
   *   <li>{@link Log#getEtime()}
   *   <li>{@link Log#getId()}
   *   <li>{@link Log#getTime()}
   *   <li>{@link Log#getType()}
   *   <li>{@link Log#getUser()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Log.<init>()", "void Log.<init>(String, String)", "Date Log.getBtime()",
      "String Log.getContent()", "Date Log.getEtime()", "Integer Log.getId()", "Date Log.getTime()",
      "String Log.getType()", "User Log.getUser()", "void Log.setBtime(Date)", "void Log.setContent(String)",
      "void Log.setEtime(Date)", "void Log.setId(Integer)", "void Log.setTime(Date)", "void Log.setType(String)",
      "void Log.setUser(User)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    Log actualLog = new Log();
    Date btime = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualLog.setBtime(btime);
    actualLog.setContent("Not all who wander are lost");
    Date etime = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualLog.setEtime(etime);
    actualLog.setId(1);
    Date time = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualLog.setTime(time);
    actualLog.setType("Type");
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    actualLog.setUser(user);
    Date actualBtime = actualLog.getBtime();
    String actualContent = actualLog.getContent();
    Date actualEtime = actualLog.getEtime();
    Integer actualId = actualLog.getId();
    Date actualTime = actualLog.getTime();
    String actualType = actualLog.getType();
    User actualUser = actualLog.getUser();

    // Assert
    assertEquals("Not all who wander are lost", actualContent);
    assertEquals("Type", actualType);
    assertEquals(1, actualId.intValue());
    assertSame(user, actualUser);
    assertSame(btime, actualBtime);
    assertSame(etime, actualEtime);
    assertSame(time, actualTime);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Log#Log(String, String)}
   *   <li>{@link Log#setBtime(Date)}
   *   <li>{@link Log#setContent(String)}
   *   <li>{@link Log#setEtime(Date)}
   *   <li>{@link Log#setId(Integer)}
   *   <li>{@link Log#setTime(Date)}
   *   <li>{@link Log#setType(String)}
   *   <li>{@link Log#setUser(User)}
   *   <li>{@link Log#getBtime()}
   *   <li>{@link Log#getContent()}
   *   <li>{@link Log#getEtime()}
   *   <li>{@link Log#getId()}
   *   <li>{@link Log#getTime()}
   *   <li>{@link Log#getType()}
   *   <li>{@link Log#getUser()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Log.<init>()", "void Log.<init>(String, String)", "Date Log.getBtime()",
      "String Log.getContent()", "Date Log.getEtime()", "Integer Log.getId()", "Date Log.getTime()",
      "String Log.getType()", "User Log.getUser()", "void Log.setBtime(Date)", "void Log.setContent(String)",
      "void Log.setEtime(Date)", "void Log.setId(Integer)", "void Log.setTime(Date)", "void Log.setType(String)",
      "void Log.setUser(User)"})
  public void testGettersAndSetters_whenType() {
    // Arrange and Act
    Log actualLog = new Log("Type", "Not all who wander are lost");
    Date btime = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualLog.setBtime(btime);
    actualLog.setContent("Not all who wander are lost");
    Date etime = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualLog.setEtime(etime);
    actualLog.setId(1);
    Date time = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualLog.setTime(time);
    actualLog.setType("Type");
    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");
    actualLog.setUser(user);
    Date actualBtime = actualLog.getBtime();
    String actualContent = actualLog.getContent();
    Date actualEtime = actualLog.getEtime();
    Integer actualId = actualLog.getId();
    Date actualTime = actualLog.getTime();
    String actualType = actualLog.getType();
    User actualUser = actualLog.getUser();

    // Assert
    assertEquals("Not all who wander are lost", actualContent);
    assertEquals("Type", actualType);
    assertEquals(1, actualId.intValue());
    assertSame(user, actualUser);
    assertSame(btime, actualBtime);
    assertSame(etime, actualEtime);
    assertSame(time, actualTime);
  }
}
