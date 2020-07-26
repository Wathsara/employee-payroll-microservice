package com.assigiment.payrollService;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="payrolls")
public class Payroll {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(name="employee_id")
    @NotEmpty
    private long employee_id;

    @Column(name="basic_salary")
    @NotEmpty
    private float basic_salary;

    @Column(name="salary_after_pension_deducted")
    @NotEmpty
    private float salary_after_pension_deducted;

    @Column(name="salary_after_EPF_deducted")
    @NotEmpty
    private float salary_after_EPF_deducted;

    @Column(name="paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF")
    @NotEmpty
    private float paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public float getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(float basic_salary) {
        this.basic_salary = basic_salary;
    }

    public float getSalary_after_pension_deducted() {
        return salary_after_pension_deducted;
    }

    public void setSalary_after_pension_deducted(float salary_after_pension_deducted) {
        this.salary_after_pension_deducted = salary_after_pension_deducted;
    }

    public float getSalary_after_EPF_deducted() {
        return salary_after_EPF_deducted;
    }

    public void setSalary_after_EPF_deducted(float salary_after_EPF_deducted) {
        this.salary_after_EPF_deducted = salary_after_EPF_deducted;
    }

    public float getPaid_by_the_employer_on_behalf_of_the_employee_to_the_EPF() {
        return paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF;
    }

    public void setPaid_by_the_employer_on_behalf_of_the_employee_to_the_EPF(float paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF) {
        this.paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF = paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF;
    }
}
