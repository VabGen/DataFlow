package org.example.dataflow.controller.request;

import java.util.UUID;

public class EmployeeRequest {

    private String firstName;

    private String middleName;

    private String lastName;

    private String address;

    private String email;

    private int phone;

    private int passport;

    private UUID postId;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String firstName, String middleName, String lastName, String address,
                           String email, int phone, int passport, UUID postId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.passport = passport;
        this.postId = postId;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public EmployeeRequest setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UUID getPostId() {
        return postId;
    }

    public EmployeeRequest setPostId(UUID postId) {
        this.postId = postId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeRequest setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public int getPhone() {
        return phone;
    }

    public EmployeeRequest setPhone(int phone) {
        this.phone = phone;
        return this;
    }

    public int getPassport() {
        return passport;
    }

    public EmployeeRequest setPassport(int passport) {
        this.passport = passport;
        return this;
    }
}
