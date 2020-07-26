package com.assigiment.payrollService;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="payroll")
public class Payroll {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(name="month")
    @NotEmpty
    private String month;

}
