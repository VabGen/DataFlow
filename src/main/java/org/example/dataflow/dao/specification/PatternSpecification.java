package org.example.dataflow.dao.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public abstract class PatternSpecification<T> {

    protected Specification<T> byFullName(CriteriaBuilder cb, Root<T> root, String value) {
        if (value == null) {
            return null;
        }

        return (root1, query, cb1) -> cb1.or(
                cb1.like(cb1.lower(root1.get("firstName")), value.toLowerCase() + "%"),
                cb1.like(cb1.lower(root1.get("middleName")), value.toLowerCase() + "%"),
                cb1.like(cb1.lower(root1.get("lastName")), value.toLowerCase() + "%")
        );
    }

    protected boolean alreadyFetched(From<?, ?> from, String attribute) {
        for (Fetch<?, ?> f : from.getFetches()) {
            if (f.getAttribute().getName().equals(attribute)) {
                return true;
            }
        }

        return false;
    }
}

