package org.example.dataflow.controller.request;

public class PostRequest {

    private String postName;

    private int code;

    public PostRequest() {
    }

    public String getPostName() {
        return postName;
    }

    public PostRequest setPostName(String postName) {
        this.postName = postName;
        return this;
    }

    public int getCode() {
        return code;
    }

    public PostRequest setCode(int code) {
        this.code = code;
        return this;
    }
}
