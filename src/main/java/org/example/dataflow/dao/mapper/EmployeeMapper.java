package org.example.dataflow.dao.mapper;

import org.example.dataflow.controller.request.EmployeeRequest;
import org.example.dataflow.dao.entity.Employee;
import org.example.dataflow.dao.model.filter.EmployeeFilter;
import org.example.dataflow.dto.EmployeeDto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static EmployeeDto entityToDto(Employee source) {
        if (source == null) {
            return null;
        }
        return entityToDto(new EmployeeDto(), source);
    }

    public static EmployeeDto entityToDto(EmployeeDto target, Employee source) {
        return target.setFirstName(source.getFirstName())
                .setMiddleName(source.getMiddleName())
                .setLastName(source.getLastName())
                .setPostId(source.getPostId())
                .setAddress(source.getAddress())
                .setEmail(source.getEmail())
                .setPhone(source.getPhone())
                .setPassport(source.getPassport());

    }

    public static List<EmployeeDto> listEntityToDtoList(Collection<Employee> source) {
        if (source == null) {
            return null;
        }
        return source.stream().map(EmployeeMapper::entityToDto).collect(Collectors.toList());
    }

    public static Employee requestToEntity(Employee target, EmployeeRequest request) {
        return target.setFirstName(request.getFirstName())
                .setMiddleName(request.getMiddleName())
                .setLastName(request.getLastName())
                .setPostId(request.getPostId())
                .setAddress(request.getAddress())
                .setEmail(request.getEmail())
                .setPhone(request.getPhone())
                .setPassport(request.getPassport());

    }

    public static Employee requestToEntity(EmployeeRequest request) {
        if (request == null) {
            return null;
        }

        return requestToEntity(new Employee(), request);
    }

    public static EmployeeDto entityToDto(Employee group, EmployeeFilter.Include... includes) {
        EmployeeDto dto = entityToDto(group);
        for (EmployeeFilter.Include type : includes) {
            switch (type) {
                case POST -> dto.setPost(PostMapper.entityToDto(group.getPost()));
            }
        }

        return dto;
    }
}
