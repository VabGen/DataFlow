package org.example.dataflow.dao.services;

import org.example.dataflow.dao.entity.Employee;
import org.example.dataflow.dao.model.filter.EmployeeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeServiceDao {

    List<Employee> findAll();

    Page<Employee> findAll(EmployeeFilter filter, Pageable pageable);

    Optional<Employee> findById(UUID id);

    Employee save(Employee employee);

    Employee edit(Employee employee);

    void delete(UUID id);
}
