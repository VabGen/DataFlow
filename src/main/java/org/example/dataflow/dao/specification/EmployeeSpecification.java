package org.example.dataflow.dao.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.example.dataflow.dao.entity.Employee;
import org.example.dataflow.dao.model.filter.EmployeeFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecification extends PatternSpecification<Employee> {

    public Specification<Employee> filterByCriteria(EmployeeFilter criteria) {

        return (root, query, builder) -> {
            Specification<Employee> spec = Specification
                    .where(byFullName(builder, root, criteria.getFullName()));

            return spec.and(fetch(criteria.getIncludes())).toPredicate(root, query, builder);
        };
    }

    private Specification<Employee> fetch(EmployeeFilter.Include... includes) {
        return (root, query, cb) -> {
            for (EmployeeFilter.Include fetch : includes) {
                switch (fetch) {
                    case POST -> {
                        if (!alreadyFetched(root, "post")) {
                            root.fetch("post", JoinType.INNER);
                        }
                    }
                }
            }

            return cb.conjunction();
        };
    }

    @Override
    protected boolean alreadyFetched(From<?, ?> from, String attribute) {
        return super.alreadyFetched(from, attribute);
    }

    @Override
    protected Specification<Employee> byFullName(CriteriaBuilder cb, Root<Employee> root, String value) {
        return super.byFullName(cb, root, value);
    }

}
