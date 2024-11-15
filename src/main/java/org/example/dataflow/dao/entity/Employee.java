package org.example.dataflow.dao.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "employee", schema = "data_flow")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "first_name")
    @NotNull(message = "Please provide employee firstName")
//    @NotBlank(message = "Please provide employee firstName")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    @NotNull(message = "Please provide employee lastName")
//    @NotBlank(message = "Please provide employee lastName")
    private String lastName;

    @Column(name = "post_code")
//    @NotNull(message = "Please provide code")
//    @NotBlank(message = "Please provide code")
    private UUID postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "id", insertable = false, updatable = false)
    private Post post;

    @Size(max = 255, message = "Value length should be 255 signs")
    @Column(name = "address")
    private String address;

    @Size(max = 255, message = "Value length should be 255 signs")
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private int phone;

    @Column(name = "passport")
    private int passport;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private Instant createDate;

    public Employee() {
    }

    public Employee(String firstName, String middleName, String lastName, UUID postId,
                    String address, String email, int phone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.postId = postId;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public Employee setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Employee setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public @NotNull(message = "Please provide code") UUID getPostId() {
        return postId;
    }

    public Employee setPostId(@NotNull(message = "Please provide code") UUID postId) {
        this.postId = postId;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Employee setPost(Post post) {
        this.post = post;
        return this;
    }

    public @Size(max = 255, message = "Value length should be 255 signs") String getAddress() {
        return address;
    }

    public Employee setAddress(@Size(max = 255, message = "Value length should be 255 signs") String address) {
        this.address = address;
        return this;
    }

    public @Size(max = 255, message = "Value length should be 255 signs") String getEmail() {
        return email;
    }

    public Employee setEmail(@Size(max = 255, message = "Value length should be 255 signs") String email) {
        this.email = email;
        return this;
    }

    public int getPhone() {
        return phone;
    }

    public Employee setPhone(int phone) {
        this.phone = phone;
        return this;
    }

    public int getPassport() {
        return passport;
    }

    public Employee setPassport(int passport) {
        this.passport = passport;
        return this;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Employee setCreateDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

}
