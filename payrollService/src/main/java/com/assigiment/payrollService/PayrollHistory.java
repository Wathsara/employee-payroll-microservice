package com.assigiment.payrollService;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="payroll_history")
public class PayrollHistory {

    @Column(name="employee_id")
    @Id
    private long employee_id;

    @Column(name="basic_salary")
    private double basic_salary;

    @Column(name="salary_after_pension_deducted")
    private double salary_after_pension_deducted;

    @Column(name="salary_after_EPF_deducted")
    private double salary_after_EPF_deducted;

    @Column(name="paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF")
    private double paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF;

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public double getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(double basic_salary) {
        this.basic_salary = basic_salary;
    }

    public double getSalary_after_pension_deducted() {
        return salary_after_pension_deducted;
    }

    public void setSalary_after_pension_deducted(double salary_after_pension_deducted) {
        this.salary_after_pension_deducted = salary_after_pension_deducted;
    }

    public double getSalary_after_EPF_deducted() {
        return salary_after_EPF_deducted;
    }

    public void setSalary_after_EPF_deducted(double salary_after_EPF_deducted) {
        this.salary_after_EPF_deducted = salary_after_EPF_deducted;
    }

    public double getPaid_by_the_employer_on_behalf_of_the_employee_to_the_EPF() {
        return paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF;
    }

    public void setPaid_by_the_employer_on_behalf_of_the_employee_to_the_EPF(double paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF) {
        this.paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF = paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF;
    }
}
