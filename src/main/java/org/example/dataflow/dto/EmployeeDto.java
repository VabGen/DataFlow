package org.example.dataflow.dto;

import java.io.Serializable;
import java.util.UUID;

public class EmployeeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;

    private String middleName;

    private String lastName;

    private UUID postId;

    private PostDto post;

    private String address;

    private String email;

    private int phone;

    private int passport;

    public EmployeeDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public EmployeeDto setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UUID getPostId() {
        return postId;
    }

    public EmployeeDto setPostId(UUID postId) {
        this.postId = postId;
        return this;
    }

    public PostDto getPost() {
        return post;
    }

    public EmployeeDto setPost(PostDto post) {
        this.post = post;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getPhone() {
        return phone;
    }

    public EmployeeDto setPhone(int phone) {
        this.phone = phone;
        return this;
    }

    public int getPassport() {
        return passport;
    }

    public EmployeeDto setPassport(int passport) {
        this.passport = passport;
        return this;
    }
}
