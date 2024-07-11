package org.example.dataflow.dao.model.filter;

public class EmployeeFilter {

    public enum Include {
        POST
    }

    private String fullName;
    private Integer code;
    private String postFullName;
    private Include[] includes;

    public EmployeeFilter() {
    }

    public String getFullName() {
        return fullName;
    }

    public EmployeeFilter setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public EmployeeFilter setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getPostFullName() {
        return postFullName;
    }

    public EmployeeFilter setPostFullName(String postFullName) {
        this.postFullName = postFullName;
        return this;
    }

    public Include[] getIncludes() {
        return includes;
    }

    public EmployeeFilter setIncludes(Include[] includes) {
        this.includes = includes;
        return this;
    }
}
