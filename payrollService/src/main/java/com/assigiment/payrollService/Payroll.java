package com.assigiment.payrollService;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="payroll")
public class Payroll {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(name="month")
    @NotEmpty
    private String month;

    @OneToMany(targetEntity = PayrollHistory.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="phfk",referencedColumnName = "id")
    private List<PayrollHistory> records;
}
