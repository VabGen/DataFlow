package org.example.dataflow.services.impl;

import org.example.dataflow.controller.request.EmployeeRequest;
import org.example.dataflow.dao.entity.Employee;
import org.example.dataflow.dao.mapper.EmployeeMapper;
import org.example.dataflow.dao.model.filter.EmployeeFilter;
import org.example.dataflow.dao.services.EmployeeServiceDao;
import org.example.dataflow.dto.EmployeeDto;
import org.example.dataflow.generation.thread.EmployeeProcessThread;
import org.example.dataflow.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeServiceDao dao;
    private final EmployeeProcessThread consumer;

    @Autowired
    public EmployeeServiceImpl(EmployeeServiceDao dao, EmployeeProcessThread consumer) {
        this.dao = dao;
        this.consumer = consumer;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDto> findAll() {
        List<Employee> employee = dao.findAll();
        return EmployeeMapper.listEntityToDtoList(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeDto> findAll(EmployeeFilter filter, Pageable pageable) {
        Page<Employee> EmployeePage = dao.findAll(filter, pageable);
        return EmployeePage.map(e -> EmployeeMapper.entityToDto(e, filter.getIncludes()));
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDto findById(UUID id) {
        Employee employee = dao.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeMapper.entityToDto(employee);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmployeeDto save(EmployeeRequest request) {
        Employee employee = EmployeeMapper.requestToEntity(request);
        return EmployeeMapper.entityToDto(dao.save(employee));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EmployeeDto edit(EmployeeRequest request) {
        Employee employee = EmployeeMapper.requestToEntity(request);
        return EmployeeMapper.entityToDto(dao.edit(employee));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(UUID id) {
        dao.delete(id);
    }

    @Override
    public void generateAndSaveEmployeeRequests(int count, int threadCount) {
        consumer.generateAndSaveEmployeeRequests(count, threadCount);
    }
}
