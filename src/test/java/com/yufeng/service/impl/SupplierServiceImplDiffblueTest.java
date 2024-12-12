package com.yufeng.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.yufeng.entity.Supplier;
import com.yufeng.repository.SupplierRepository;
import java.util.ArrayList;
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

@ContextConfiguration(classes = {SupplierServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SupplierServiceImplDiffblueTest {
  @MockBean
  private SupplierRepository supplierRepository;

  @Autowired
  private SupplierServiceImpl supplierServiceImpl;

  /**
   * Test {@link SupplierServiceImpl#save(Supplier)}.
   * <p>
   * Method under test: {@link SupplierServiceImpl#save(Supplier)}
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
    when(supplierRepository.save(Mockito.<Supplier>any())).thenReturn(supplier);

    Supplier supplier2 = new Supplier();
    supplier2.setAddress("42 Main St");
    supplier2.setContact("Contact");
    supplier2.setId(1);
    supplier2.setName("Name");
    supplier2.setNumber("42");
    supplier2.setRemarks("Remarks");

    // Act
    supplierServiceImpl.save(supplier2);

    // Assert
    verify(supplierRepository).save(isA(Supplier.class));
  }

  /**
   * Test
   * {@link SupplierServiceImpl#list(Supplier, Integer, Integer, Direction, String[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SupplierServiceImpl#list(Supplier, Integer, Integer, Sort.Direction, String[])}
   */
  @Test
  public void testList_thenReturnEmpty() {
    // Arrange
    when(supplierRepository.findAll(Mockito.<Specification<Supplier>>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");

    // Act
    List<Supplier> actualListResult = supplierServiceImpl.list(supplier, 1, 3, Sort.Direction.ASC, "Properties");

    // Assert
    verify(supplierRepository).findAll(isA(Specification.class), isA(Pageable.class));
    assertTrue(actualListResult.isEmpty());
  }

  /**
   * Test {@link SupplierServiceImpl#getCount(Supplier)}.
   * <p>
   * Method under test: {@link SupplierServiceImpl#getCount(Supplier)}
   */
  @Test
  public void testGetCount() {
    // Arrange
    when(supplierRepository.count(Mockito.<Specification<Supplier>>any())).thenReturn(3L);

    Supplier supplier = new Supplier();
    supplier.setAddress("42 Main St");
    supplier.setContact("Contact");
    supplier.setId(1);
    supplier.setName("Name");
    supplier.setNumber("42");
    supplier.setRemarks("Remarks");

    // Act
    Long actualCount = supplierServiceImpl.getCount(supplier);

    // Assert
    verify(supplierRepository).count(isA(Specification.class));
    assertEquals(3L, actualCount.longValue());
  }

  /**
   * Test {@link SupplierServiceImpl#delete(Integer)}.
   * <p>
   * Method under test: {@link SupplierServiceImpl#delete(Integer)}
   */
  @Test
  public void testDelete() {
    // Arrange
    doNothing().when(supplierRepository).delete(Mockito.<Integer>any());

    // Act
    supplierServiceImpl.delete(1);

    // Assert
    verify(supplierRepository).delete(anyInt());
  }

  /**
   * Test {@link SupplierServiceImpl#findById(Integer)}.
   * <p>
   * Method under test: {@link SupplierServiceImpl#findById(Integer)}
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
    when(supplierRepository.findOne(Mockito.<Integer>any())).thenReturn(supplier);

    // Act
    Supplier actualFindByIdResult = supplierServiceImpl.findById(1);

    // Assert
    verify(supplierRepository).findOne(anyInt());
    assertSame(supplier, actualFindByIdResult);
  }

  /**
   * Test {@link SupplierServiceImpl#findByName(String)}.
   * <p>
   * Method under test: {@link SupplierServiceImpl#findByName(String)}
   */
  @Test
  public void testFindByName() {
    // Arrange
    when(supplierRepository.findByName(Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<Supplier> actualFindByNameResult = supplierServiceImpl.findByName("Name");

    // Assert
    verify(supplierRepository).findByName(Mockito.<String>any());
    assertTrue(actualFindByNameResult.isEmpty());
  }
}
