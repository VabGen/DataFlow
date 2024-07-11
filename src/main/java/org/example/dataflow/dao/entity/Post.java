package org.example.dataflow.dao.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "post", schema = "data_flow")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "code")
    @NotNull(message = "Please provide code")
    @Min(value = 1, message = "Value should not be less than 1")
    @Max(value = 1000, message = "Value should not be greater than 10")
    protected int code;

    @Column(name = "post_name")
    @NotNull(message = "Please provide postName")
//    @NotBlank(message = "Please provide postName")
    @Size(max = 255, message = "Value length should be 255 signs")
    protected String postName;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Employee> employees;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private Instant createDate;

    public Post() {
    }

    public Post(String postName) {
        this.postName = postName;
    }

    public UUID getId() {
        return id;
    }

    public Post setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getPostName() {
        return postName;
    }

    public Post setPostName(String postName) {
        this.postName = postName;
        return this;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Post setCreateDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Post setCode(int code) {
        this.code = code;
        return this;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Post setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return code == post.code &&
                Objects.equals(id, post.id) &&
                Objects.equals(postName, post.postName) &&
                Objects.equals(employees, post.employees) &&
                Objects.equals(createDate, post.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, postName, employees, createDate);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", code=" + code +
                ", postName='" + postName + '\'' +
                ", employees=" + employees +
                ", createDate=" + createDate +
                '}';
    }
}
