package org.example.dataflow.dao.model.filter;

public class PostFilter {

    public enum Include {
        EMPLOYEE
    }

    private String PostName;
    private Integer code;;
    private Include[] includes;

    public PostFilter() {
    }

    public String getPostName() {
        return PostName;
    }

    public PostFilter setPostName(String postName) {
        PostName = postName;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public PostFilter setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Include[] getIncludes() {
        return includes;
    }

    public PostFilter setIncludes(Include[] includes) {
        this.includes = includes;
        return this;
    }
}
