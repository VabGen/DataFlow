package org.example.dataflow.dao.services.impl;

import org.example.dataflow.dao.entity.Employee;
import org.example.dataflow.dao.model.filter.EmployeeFilter;
import org.example.dataflow.dao.repository.EmployeeRepository;
import org.example.dataflow.dao.services.EmployeeServiceDao;
import org.example.dataflow.dao.services.PostServiceDao;
import org.example.dataflow.dao.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceDaoImpl implements EmployeeServiceDao {

    private final EmployeeRepository repository;
    private final EmployeeSpecification spec;

    @Autowired
    public EmployeeServiceDaoImpl(EmployeeRepository repository, EmployeeSpecification spec) {
        this.repository = repository;
        this.spec = spec;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Employee> findAll(EmployeeFilter filter, Pageable pageable) {
        return repository.findAll(spec.filterByCriteria(filter), pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Employee> findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Employee edit(Employee employee) {
        return repository.save(employee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
