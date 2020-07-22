package com.assigiment.employeeDetailsService;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(name = "fullname")
    @NotEmpty
    private String fullname;

    @Column(name = "email")
    @Email(message = "Please provide a valid email")
    private String email;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "permanent")
    @NotNull
    private boolean permanent;

    @Column(name = "basic_salary")
    @NotNull
    private float basic_salary;

    @Column(name = "department")
    @NotEmpty
    private String department;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullname) {
        this.fullname = fullname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public float getBasicSalary() {
        return basic_salary;
    }

    public void setBasicSalary(float basic_salary) {
        this.basic_salary = basic_salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
