package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Log;
import com.yufeng.entity.User;
import com.yufeng.repository.LogRepository;
import com.yufeng.repository.UserRepository;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {LogServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LogServiceImplDiffblueTest {
  @MockBean
  private LogRepository logRepository;

  @Autowired
  private LogServiceImpl logServiceImpl;

  @MockBean
  private UserRepository userRepository;

  /**
   * Test {@link LogServiceImpl#list(Log, Integer, Integer, Direction, String[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LogServiceImpl#list(Log, Integer, Integer, Sort.Direction, String[])}
   */
  @Test
  public void testList_thenReturnEmpty() {
    // Arrange
    when(logRepository.findAll(Mockito.<Specification<Log>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    Log log = new Log();
    log.setBtime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    log.setContent("Not all who wander are lost");
    log.setEtime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    log.setId(1);
    log.setTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    log.setType("Type");
    log.setUser(user);

    // Act
    List<Log> actualListResult = logServiceImpl.list(log, 1, 3, Sort.Direction.ASC, "Properties");

    // Assert
    verify(logRepository).findAll(isA(Specification.class), isA(Pageable.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link LogServiceImpl#getCount(Log)}.
   * <p>
   * Method under test: {@link LogServiceImpl#getCount(Log)}
   */
  @Test
  public void testGetCount() {
    // Arrange
    when(logRepository.count(Mockito.<Specification<Log>>any())).thenReturn(3L);

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    Log log = new Log();
    log.setBtime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    log.setContent("Not all who wander are lost");
    log.setEtime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    log.setId(1);
    log.setTime(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    log.setType("Type");
    log.setUser(user);

    // Act
    Long actualCount = logServiceImpl.getCount(log);

    // Assert
    verify(logRepository).count(isA(Specification.class));
    assertEquals(3L, actualCount.longValue());
  }
}
