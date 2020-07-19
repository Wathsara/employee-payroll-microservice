package com.assigiment.employeeDetailsService;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(nullable = false)
    private String full_name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Date dob;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private boolean permanent;

    @Column(nullable = false)
    private float basic_salary;

    @Column(nullable = false)
    private String department;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

    public float getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(float basic_salary) {
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
