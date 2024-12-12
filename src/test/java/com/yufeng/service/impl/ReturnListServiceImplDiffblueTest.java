package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.ReturnList;
import com.yufeng.entity.Supplier;
import com.yufeng.entity.User;
import com.yufeng.repository.GoodsRepository;
import com.yufeng.repository.GoodsTypeRepository;
import com.yufeng.repository.ReturnListGoodsRepository;
import com.yufeng.repository.ReturnListRepository;
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

@ContextConfiguration(classes = {ReturnListServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ReturnListServiceImplDiffblueTest {
  @MockBean
  private GoodsRepository goodsRepository;

  @MockBean
  private GoodsTypeRepository goodsTypeRepository;

  @MockBean
  private ReturnListGoodsRepository returnListGoodsRepository;

  @MockBean
  private ReturnListRepository returnListRepository;

  @Autowired
  private ReturnListServiceImpl returnListServiceImpl;

  /**
   * Test {@link ReturnListServiceImpl#getTodayMaxReturnNumber()}.
   * <p>
   * Method under test: {@link ReturnListServiceImpl#getTodayMaxReturnNumber()}
   */
  @Test
  public void testGetTodayMaxReturnNumber() {
    // Arrange
    when(returnListRepository.getTodayMaxReturnNumber()).thenReturn("42");

    // Act
    String actualTodayMaxReturnNumber = returnListServiceImpl.getTodayMaxReturnNumber();

    // Assert
    verify(returnListRepository).getTodayMaxReturnNumber();
    assertEquals("42", actualTodayMaxReturnNumber);
  }

  /**
   * Test {@link ReturnListServiceImpl#save(ReturnList, List)}.
   * <p>
   * Method under test: {@link ReturnListServiceImpl#save(ReturnList, List)}
   */
  @Test
  public void testSave() {
    // Arrange
    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(returnListRepository.save(Mockito.<ReturnList>any())).thenReturn(returnList);

    Supplier supplier2 = new Supplier();
    supplier2.setAddress("42 Main St");
    supplier2.setContact("Contact");
    supplier2.setId(1);
    supplier2.setName("Name");
    supplier2.setNumber("42");
    supplier2.setRemarks("Remarks");

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    ReturnList returnList2 = new ReturnList();
    returnList2.setAmountPaid(10.0f);
    returnList2.setAmountPayable(10.0f);
    returnList2.setId(1);
    returnList2.setRemarks("Remarks");
    returnList2.setReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList2.setReturnListGoodsList(new ArrayList<>());
    returnList2.setReturnNumber("42");
    returnList2.setState(1);
    returnList2.setSupplier(supplier2);
    returnList2.setUser(user2);
    returnList2.setbReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList2.seteReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    returnListServiceImpl.save(returnList2, new ArrayList<>());

    // Assert
    verify(returnListRepository).save(isA(ReturnList.class));
  }

  /**
   * Test {@link ReturnListServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link ReturnListServiceImpl#findById(Integer)}
   */
  @Test
  public void testFindById() {
    // Arrange
    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(returnListRepository.findOne(Mockito.<Integer>any())).thenReturn(returnList);

    // Act
    ReturnList actualFindByIdResult = returnListServiceImpl.findById(1);

    // Assert
    verify(returnListRepository).findOne(anyInt());
    assertSame(returnList, actualFindByIdResult);
  }

  /**
   * Test {@link ReturnListServiceImpl#list(ReturnList, Direction, String[])}.
   * <ul>
   *   <li>When {@code Properties}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ReturnListServiceImpl#list(ReturnList, Sort.Direction, String[])}
   */
  @Test
  public void testList_whenProperties_thenReturnEmpty() {
    // Arrange
    when(returnListRepository.findAll(Mockito.<Specification<ReturnList>>any(), Mockito.<Sort>any()))
        .thenReturn(new ArrayList<>());

    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    List<ReturnList> actualListResult = returnListServiceImpl.list(returnList, Sort.Direction.ASC, "Properties");

    // Assert
    verify(returnListRepository).findAll(isA(Specification.class), isA(Sort.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link ReturnListServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link ReturnListServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(returnListGoodsRepository).deleteByReturnListId(Mockito.<Integer>any());
    doNothing().when(returnListRepository).delete(Mockito.<Integer>any());

    // Act
    returnListServiceImpl.delete(1);

    // Assert
    verify(returnListGoodsRepository).deleteByReturnListId(anyInt());
    verify(returnListRepository).delete(anyInt());
  }

  /**
   * Test {@link ReturnListServiceImpl#update(ReturnList)}.
   * <p>
   * Method under test: {@link ReturnListServiceImpl#update(ReturnList)}
   */
  @Test
  public void testUpdate() {
    // Arrange
    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");

    User user = new User();
    user.setId(1);
    user.setPassword("iloveyou");
    user.setRemarks("Remarks");
    user.setRoles("Roles");
    user.setTrueName("True Name");
    user.setUserName("janedoe");

    ReturnList returnList = new ReturnList();
    returnList.setAmountPaid(10.0f);
    returnList.setAmountPayable(10.0f);
    returnList.setId(1);
    returnList.setRemarks("Remarks");
    returnList.setReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.setReturnListGoodsList(new ArrayList<>());
    returnList.setReturnNumber("42");
    returnList.setState(1);
    returnList.setSupplier(supplier);
    returnList.setUser(user);
    returnList.setbReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList.seteReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(returnListRepository.save(Mockito.<ReturnList>any())).thenReturn(returnList);

    Supplier supplier2 = new Supplier();
    supplier2.setAddress("42 Main St");
    supplier2.setContact("Contact");
    supplier2.setId(1);
    supplier2.setName("Name");
    supplier2.setNumber("42");
    supplier2.setRemarks("Remarks");

    User user2 = new User();
    user2.setId(1);
    user2.setPassword("iloveyou");
    user2.setRemarks("Remarks");
    user2.setRoles("Roles");
    user2.setTrueName("True Name");
    user2.setUserName("janedoe");

    ReturnList returnList2 = new ReturnList();
    returnList2.setAmountPaid(10.0f);
    returnList2.setAmountPayable(10.0f);
    returnList2.setId(1);
    returnList2.setRemarks("Remarks");
    returnList2.setReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList2.setReturnListGoodsList(new ArrayList<>());
    returnList2.setReturnNumber("42");
    returnList2.setState(1);
    returnList2.setSupplier(supplier2);
    returnList2.setUser(user2);
    returnList2.setbReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    returnList2.seteReturnDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));

    // Act
    returnListServiceImpl.update(returnList2);

    // Assert
    verify(returnListRepository).save(isA(ReturnList.class));
  }
}
