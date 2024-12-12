package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Customer;
import com.yufeng.entity.SaleList;
import com.yufeng.entity.User;
import com.yufeng.repository.GoodsRepository;
import com.yufeng.repository.GoodsTypeRepository;
import com.yufeng.repository.SaleListGoodsRepository;
import com.yufeng.repository.SaleListRepository;
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
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SaleListServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SaleListServiceImplDiffblueTest {
  @MockBean
  private GoodsRepository goodsRepository;

  @MockBean
  private GoodsTypeRepository goodsTypeRepository;

  @MockBean
  private SaleListGoodsRepository saleListGoodsRepository;

  @MockBean
  private SaleListRepository saleListRepository;

  @Autowired
  private SaleListServiceImpl saleListServiceImpl;

  /**
   * Test {@link SaleListServiceImpl#getTodayMaxSaleNumber()}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#getTodayMaxSaleNumber()}
   */
  @Test
  public void testGetTodayMaxSaleNumber() {
    // Arrange
    when(saleListRepository.getTodayMaxSaleNumber()).thenReturn("42");

    // Act
    String actualTodayMaxSaleNumber = saleListServiceImpl.getTodayMaxSaleNumber();

    // Assert
    verify(saleListRepository).getTodayMaxSaleNumber();
    assertEquals("42", actualTodayMaxSaleNumber);
  }

  /**
   * Test {@link SaleListServiceImpl#save(SaleList, List)}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#save(SaleList, List)}
   */
  @Test
  public void testSave() {
    // Arrange
    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    SaleList saleList = new SaleList();
    saleList.setAmountPaid(10.0f);
    saleList.setAmountPayable(10.0f);
    saleList.setCustomer(customer);
    saleList.setId(1);
    saleList.setRemarks("Remarks");
    saleList.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.setSaleListGoodsList(new ArrayList<>());
    saleList.setSaleNumber("42");
    saleList.setState(1);
    saleList.setUser(user);
    saleList.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(saleListRepository.save(Mockito.<SaleList>any())).thenReturn(saleList);

    Customer customer2 = new Customer();
    customer2.setAddress("42 Main St");
    customer2.setContact("Contact");
    customer2.setId(1);
    customer2.setName("Name");
    customer2.setNumber("42");
    customer2.setRemarks("Remarks");

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    SaleList saleList2 = new SaleList();
    saleList2.setAmountPaid(10.0f);
    saleList2.setAmountPayable(10.0f);
    saleList2.setCustomer(customer2);
    saleList2.setId(1);
    saleList2.setRemarks("Remarks");
    saleList2.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList2.setSaleListGoodsList(new ArrayList<>());
    saleList2.setSaleNumber("42");
    saleList2.setState(1);
    saleList2.setUser(user2);
    saleList2.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList2.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    saleListServiceImpl.save(saleList2, new ArrayList<>());

    // Assert
    verify(saleListRepository).save(isA(SaleList.class));
  }

  /**
   * Test {@link SaleListServiceImpl#list(SaleList, Direction, String[])}.
   * <ul>
   *   <li>When {@code Properties}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SaleListServiceImpl#list(SaleList, Sort.Direction, String[])}
   */
  @Test
  public void testList_whenProperties_thenReturnEmpty() {
    // Arrange
    when(saleListRepository.findAll(Mockito.<Specification<SaleList>>any(), Mockito.<Sort>any()))
        .thenReturn(new ArrayList<>());

    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    SaleList saleList = new SaleList();
    saleList.setAmountPaid(10.0f);
    saleList.setAmountPayable(10.0f);
    saleList.setCustomer(customer);
    saleList.setId(1);
    saleList.setRemarks("Remarks");
    saleList.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.setSaleListGoodsList(new ArrayList<>());
    saleList.setSaleNumber("42");
    saleList.setState(1);
    saleList.setUser(user);
    saleList.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    List<SaleList> actualListResult = saleListServiceImpl.list(saleList, Sort.Direction.ASC, "Properties");

    // Assert
    verify(saleListRepository).findAll(isA(Specification.class), isA(Sort.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link SaleListServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(saleListGoodsRepository).deleteBySaleListId(Mockito.<Integer>any());
    doNothing().when(saleListRepository).delete(Mockito.<Integer>any());

    // Act
    saleListServiceImpl.delete(1);

    // Assert
    verify(saleListGoodsRepository).deleteBySaleListId(anyInt());
    verify(saleListRepository).delete(anyInt());
  }

  /**
   * Test {@link SaleListServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
    // Arrange
    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    SaleList saleList = new SaleList();
    saleList.setAmountPaid(10.0f);
    saleList.setAmountPayable(10.0f);
    saleList.setCustomer(customer);
    saleList.setId(1);
    saleList.setRemarks("Remarks");
    saleList.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.setSaleListGoodsList(new ArrayList<>());
    saleList.setSaleNumber("42");
    saleList.setState(1);
    saleList.setUser(user);
    saleList.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(saleListRepository.findOne(Mockito.<Integer>any())).thenReturn(saleList);

    // Act
    SaleList actualFindByIdResult = saleListServiceImpl.findById(1);

    // Assert
    verify(saleListRepository).findOne(anyInt());
    assertSame(saleList, actualFindByIdResult);
  }

  /**
   * Test {@link SaleListServiceImpl#update(SaleList)}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#update(SaleList)}
   */
  @Test
  public void testUpdate() {
    // Arrange
    Customer customer = new Customer();
    customer.setAddress("42 Main St");
    customer.setContact("Contact");
    customer.setId(1);
    customer.setName("Name");
    customer.setNumber("42");
    customer.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    SaleList saleList = new SaleList();
    saleList.setAmountPaid(10.0f);
    saleList.setAmountPayable(10.0f);
    saleList.setCustomer(customer);
    saleList.setId(1);
    saleList.setRemarks("Remarks");
    saleList.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.setSaleListGoodsList(new ArrayList<>());
    saleList.setSaleNumber("42");
    saleList.setState(1);
    saleList.setUser(user);
    saleList.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(saleListRepository.save(Mockito.<SaleList>any())).thenReturn(saleList);

    Customer customer2 = new Customer();
    customer2.setAddress("42 Main St");
    customer2.setContact("Contact");
    customer2.setId(1);
    customer2.setName("Name");
    customer2.setNumber("42");
    customer2.setRemarks("Remarks");

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    SaleList saleList2 = new SaleList();
    saleList2.setAmountPaid(10.0f);
    saleList2.setAmountPayable(10.0f);
    saleList2.setCustomer(customer2);
    saleList2.setId(1);
    saleList2.setRemarks("Remarks");
    saleList2.setSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList2.setSaleListGoodsList(new ArrayList<>());
    saleList2.setSaleNumber("42");
    saleList2.setState(1);
    saleList2.setUser(user2);
    saleList2.setbSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    saleList2.seteSaleDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    saleListServiceImpl.update(saleList2);

    // Assert
    verify(saleListRepository).save(isA(SaleList.class));
  }

  /**
   * Test {@link SaleListServiceImpl#countSaleByDay(String, String)}.
   * <p>
   * Method under test: {@link SaleListServiceImpl#countSaleByDay(String, String)}
   */
  @Test
  public void testCountSaleByDay() {
    // Arrange
    when(saleListRepository.countSaleByDay(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Object> actualCountSaleByDayResult = saleListServiceImpl.countSaleByDay("Begin", "End");

    // Assert
    verify(saleListRepository).countSaleByDay(Mockito.<String>any(), Mockito.<String>any());
    assertTrue(actualCountSaleByDayResult.isEmpty());
  }

  /**
   * Test {@link SaleListServiceImpl#countSaleByMonth(String, String)}.
   * <p>
   * Method under test:
   * {@link SaleListServiceImpl#countSaleByMonth(String, String)}
   */
  @Test
  public void testCountSaleByMonth() {
    // Arrange
    when(saleListRepository.countSaleByMonth(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Object> actualCountSaleByMonthResult = saleListServiceImpl.countSaleByMonth("Begin", "End");

    // Assert
    verify(saleListRepository).countSaleByMonth(Mockito.<String>any(), Mockito.<String>any());
    assertTrue(actualCountSaleByMonthResult.isEmpty());
  }
}
