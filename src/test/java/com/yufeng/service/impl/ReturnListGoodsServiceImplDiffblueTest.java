package com.yufeng.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.GoodsType;
import com.yufeng.entity.ReturnList;
import com.yufeng.entity.ReturnListGoods;
import com.yufeng.entity.Supplier;
import com.yufeng.entity.User;
import com.yufeng.repository.ReturnListGoodsRepository;
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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ReturnListGoodsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ReturnListGoodsServiceImplDiffblueTest {
  @MockBean
  private ReturnListGoodsRepository returnListGoodsRepository;

  @Autowired
  private ReturnListGoodsServiceImpl returnListGoodsServiceImpl;

  /**
   * Test {@link ReturnListGoodsServiceImpl#listByReturnListId(Integer)}.
   * <p>
   * Method under test:
   * {@link ReturnListGoodsServiceImpl#listByReturnListId(Integer)}
   */
  @Test
  public void testListByReturnListId() {
    // Arrange
    when(returnListGoodsRepository.listByReturnListId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

    // Act
    List<ReturnListGoods> actualListByReturnListIdResult = returnListGoodsServiceImpl.listByReturnListId(1);

    // Assert
    verify(returnListGoodsRepository).listByReturnListId(anyInt());
    assertTrue(actualListByReturnListIdResult.isEmpty());
  }

  /**
   * Test {@link ReturnListGoodsServiceImpl#list(ReturnListGoods)}.
   * <p>
   * Method under test: {@link ReturnListGoodsServiceImpl#list(ReturnListGoods)}
   */
  @Test
  public void testList() {
    // Arrange
    when(returnListGoodsRepository.findAll(Mockito.<Specification<ReturnListGoods>>any()))
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

    GoodsType type = new GoodsType();
    type.setIcon("Icon");
    type.setId(1);
    type.setName("Name");
    type.setState(1);
    type.setpId(1);

    ReturnListGoods returnListGoods = new ReturnListGoods();
    returnListGoods.setCode("Code");
    returnListGoods.setCodeOrName("Code Or Name");
    returnListGoods.setGoodsId(1);
    returnListGoods.setId(1);
    returnListGoods.setModel("Model");
    returnListGoods.setName("Name");
    returnListGoods.setNum(10);
    returnListGoods.setPrice(10.0f);
    returnListGoods.setReturnList(returnList);
    returnListGoods.setTotal(10.0f);
    returnListGoods.setType(type);
    returnListGoods.setTypeId(1);
    returnListGoods.setUnit("Unit");

    // Act
    List<ReturnListGoods> actualListResult = returnListGoodsServiceImpl.list(returnListGoods);

    // Assert
    verify(returnListGoodsRepository).findAll(isA(Specification.class));
    assertTrue(actualListResult.isEmpty());
  }
}
