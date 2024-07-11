package org.example.dataflow.services;

import org.example.dataflow.controller.request.EmployeeRequest;
import org.example.dataflow.dao.model.filter.EmployeeFilter;
import org.example.dataflow.dto.EmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<EmployeeDto> findAll();

    Page<EmployeeDto> findAll(EmployeeFilter filter, Pageable pageable);

    EmployeeDto findById(UUID id);

    EmployeeDto save(EmployeeRequest request);

    EmployeeDto edit(EmployeeRequest request);

    void delete(UUID id);

    void generateAndSaveEmployeeRequests(int count, int threadCount);
}
