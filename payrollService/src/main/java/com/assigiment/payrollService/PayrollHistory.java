package com.assigiment.payrollService;

import javax.persistence.*;

@Entity
@Table(name="payroll_history")
public class PayrollHistory {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(name="employee_id")
    private long employee_id;

    @Column(name="basic_salary")
    private double basic_salary;

    @Column(name="salary_pension_deducted_amount")
    private double salary_pension_deducted_amount;

    @Column(name="salary_EPF_deducted_amount")
    private double salary_EPF_deducted_amount;

    @Column(name="paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF")
    private double paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF;

    @Column(name="final_salary")
    private double final_salary;

    @Column(name="total_EPF")
    private double totol_EPF;


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

    public double getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(double basic_salary) {
        this.basic_salary = basic_salary;
    }

    public double getSalary_pension_deducted_amount() {
        return salary_pension_deducted_amount;
    }

    public void setSalary_pension_deducted_amount(double salary_pension_deducted_amount) {
        this.salary_pension_deducted_amount = salary_pension_deducted_amount;
    }

    public double getSalary_EPF_deducted_amount() {
        return salary_EPF_deducted_amount;
    }

    public void setSalary_EPF_deducted_amount(double salary_EPF_deducted_amount) {
        this.salary_EPF_deducted_amount = salary_EPF_deducted_amount;
    }

    public double getPaid_by_the_employer_on_behalf_of_the_employee_to_the_EPF() {
        return paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF;
    }

    public void setPaid_by_the_employer_on_behalf_of_the_employee_to_the_EPF(double paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF) {
        this.paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF = paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF;
    }

    public double getFinal_salary() {
        return final_salary;
    }

    public void setFinal_salary(double final_salary) {
        this.final_salary = final_salary;
    }

    public double getTotol_EPF() {
        return totol_EPF;
    }

    public void setTotol_EPF(double totol_EPF) {
        this.totol_EPF = totol_EPF;
    }
}
