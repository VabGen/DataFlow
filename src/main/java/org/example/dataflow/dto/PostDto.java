package org.example.dataflow.dto;

import java.io.Serializable;
import java.util.List;

public class PostDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String postName;

    private int code;

    private List<EmployeeDto> employees;

    public PostDto() {
    }

    public String getPostName() {
        return postName;
    }

    public PostDto setPostName(String postName) {
        this.postName = postName;
        return this;
    }

    public int getCode() {
        return code;
    }

    public PostDto setCode(int code) {
        this.code = code;
        return this;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public PostDto setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
        return this;
    }
}
