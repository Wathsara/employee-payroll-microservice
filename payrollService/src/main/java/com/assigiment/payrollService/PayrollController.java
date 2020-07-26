package com.assigiment.payrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/service1")
public class PayrollController {

    @Autowired
    private PayrollRepository payroll;
    @Autowired
    private  PayrollHistoryRepository payrollHistoryRepository;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to Software Engineering Assignment. PayrollService";
    }

    @RequestMapping(value= "/test1", method=RequestMethod.GET)
    public List<Payroll> test1(){
        return payroll.findAll();
    }


    @RequestMapping(value = "/payroll", method = RequestMethod.GET)
    public String  getPayroll() {

        PayrollHistory emp1 = new PayrollHistory();
        emp1.setEmployee_id(1);
        emp1.setBasic_salary(12000.00);
        emp1.setSalary_after_pension_deducted(11000.00);
        emp1.setSalary_after_EPF_deducted(10000.00);
        emp1.setPaid_by_the_employer_on_behalf_of_the_employee_to_the_EPF(5000.00);

        PayrollHistory emp2 = new PayrollHistory();
        emp2.setEmployee_id(2);
        emp2.setBasic_salary(12000.00);
        emp2.setSalary_after_pension_deducted(11000.00);
        emp2.setSalary_after_EPF_deducted(10000.00);
        emp2.setPaid_by_the_employer_on_behalf_of_the_employee_to_the_EPF(5000.00);

        List<PayrollHistory> employee = new LinkedList<PayrollHistory>();
        employee.add(emp1);
        employee.add(emp2);

        Payroll obj = new Payroll();
        obj.setMonth("JAN");
        obj.setRecords(employee);

        payroll.save(obj);
        return "Hello";
    }
}
