package com.yufeng.util;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Helper class to create testable Specification instances for Diffblue Cover.
 * This addresses R083 errors where Diffblue cannot construct Specification interfaces directly.
 *
 * @author Generated for Diffblue Cover compatibility
 */
public class SpecificationHelper {

    /**
     * Creates a simple Specification that matches all entities (no filtering).
     * This is the most basic specification for testing repository methods.
     *
     * @param <T> the entity type
     * @return a Specification that returns true for all entities
     */
    public static <T> Specification<T> matchAll() {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.conjunction();
            }
        };
    }

    /**
     * Creates a Specification that matches no entities.
     * Useful for testing empty result sets.
     *
     * @param <T> the entity type
     * @return a Specification that returns false for all entities
     */
    public static <T> Specification<T> matchNone() {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.disjunction();
            }
        };
    }

    /**
     * Creates a Specification that filters by a specific field equality.
     *
     * @param <T>       the entity type
     * @param fieldName the name of the field to filter on
     * @param value     the value to match
     * @return a Specification that filters by field equality
     */
    public static <T> Specification<T> equalTo(String fieldName, Object value) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (value == null) {
                    return cb.isNull(root.get(fieldName));
                }
                return cb.equal(root.get(fieldName), value);
            }
        };
    }

    /**
     * Creates a Specification that filters by a LIKE pattern on a string field.
     *
     * @param <T>       the entity type
     * @param fieldName the name of the string field to filter on
     * @param pattern   the LIKE pattern (e.g., "%search%")
     * @return a Specification that filters by LIKE pattern
     */
    public static <T> Specification<T> like(String fieldName, String pattern) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (pattern == null) {
                    return cb.conjunction();
                }
                return cb.like(root.get(fieldName), pattern);
            }
        };
    }

    /**
     * Creates a Specification that filters by field not equal to a value.
     *
     * @param <T>       the entity type
     * @param fieldName the name of the field to filter on
     * @param value     the value to exclude
     * @return a Specification that filters by field inequality
     */
    public static <T> Specification<T> notEqualTo(String fieldName, Object value) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                if (value == null) {
                    return cb.isNotNull(root.get(fieldName));
                }
                return cb.notEqual(root.get(fieldName), value);
            }
        };
    }

    /**
     * Creates a Specification by combining two specifications with AND logic.
     *
     * @param <T>   the entity type
     * @param spec1 the first specification
     * @param spec2 the second specification
     * @return a Specification that is the AND combination of the two specifications
     */
    public static <T> Specification<T> and(Specification<T> spec1, Specification<T> spec2) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1 = spec1.toPredicate(root, query, cb);
                Predicate p2 = spec2.toPredicate(root, query, cb);
                return cb.and(p1, p2);
            }
        };
    }

    /**
     * Creates a Specification by combining two specifications with OR logic.
     *
     * @param <T>   the entity type
     * @param spec1 the first specification
     * @param spec2 the second specification
     * @return a Specification that is the OR combination of the two specifications
     */
    public static <T> Specification<T> or(Specification<T> spec1, Specification<T> spec2) {
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1 = spec1.toPredicate(root, query, cb);
                Predicate p2 = spec2.toPredicate(root, query, cb);
                return cb.or(p1, p2);
            }
        };
    }

    /**
     * Creates a null-safe Specification that returns a default specification if the input is null.
     *
     * @param <T>  the entity type
     * @param spec the specification to check
     * @return the input specification if not null, otherwise matchAll()
     */
    public static <T> Specification<T> nullSafe(Specification<T> spec) {
        return spec != null ? spec : matchAll();
    }
}
