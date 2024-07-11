package org.example.dataflow.controller;

import org.example.dataflow.controller.request.EmployeeRequest;
import org.example.dataflow.dao.model.filter.EmployeeFilter;
import org.example.dataflow.dto.EmployeeDto;
import org.example.dataflow.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeDto>> getCollection(@ModelAttribute EmployeeFilter filter, @PageableDefault(sort = {"id"}) Pageable pageable) {
        Page<EmployeeDto> EmployeeFilter = employeeService.findAll(filter, pageable);
        return ResponseEntity.ok(EmployeeFilter);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDto> get(@PathVariable UUID id) {
        EmployeeDto findEmployee = employeeService.findById(id);
        return ResponseEntity.ok(findEmployee);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> post(@RequestBody EmployeeRequest request) {
        EmployeeDto save = employeeService.save(request);
        return ResponseEntity.ok(save);
    }

    @PostMapping(value = "/generate")
    public ResponseEntity<?> post() {
        employeeService.generateAndSaveEmployeeRequests(50000, 5);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> put(@RequestBody EmployeeRequest request) {
        EmployeeDto edit = employeeService.edit(request);
        return ResponseEntity.ok(edit);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<EmployeeDto> delete(@PathVariable("id") UUID employeeId) {
        employeeService.delete(employeeId);
        return ResponseEntity.noContent().build();
    }
}
