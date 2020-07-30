package com.assigiment.payrollService;


import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="payroll")
public class Payroll {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(name="month")
    private int month;

    @Column(name="year")
    private int year;

    @OneToMany(targetEntity = PayrollHistory.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="phfk",referencedColumnName = "id")
    private List<PayrollHistory> records;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public List<PayrollHistory> getRecords() {
        return records;
    }

    public void setRecords(List<PayrollHistory> records) {
        this.records = records;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
