package com.assigiment.payrollService;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="payroll")
public class Payroll {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(name="month")
    private String month;

    @OneToMany(targetEntity = PayrollHistory.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="phfk",referencedColumnName = "id")
    private List<PayrollHistory> records;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<PayrollHistory> getRecords() {
        return records;
    }

    public void setRecords(List<PayrollHistory> records) {
        this.records = records;
    }
}
