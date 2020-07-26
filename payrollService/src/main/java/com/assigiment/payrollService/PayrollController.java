package com.assigiment.payrollService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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


    @RequestMapping(value = "/payroll", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE})
    public String  getPayroll() throws FileNotFoundException {

        JSONObject obj = new JSONObject();
        JSONArray  salaries = new JSONArray();
        Map salariesrecords  = new LinkedHashMap(5);
        salariesrecords.put("emp_id", 1);
        salariesrecords.put("basic_salary", 1200.00);
        salariesrecords.put("salary_after_pension_deducted", 11000.00);
        salariesrecords.put("salary_after_EPF_deducted", 1000.00);
        salariesrecords.put("paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF", 9000.00);
        salaries.add(salariesrecords);
        // putting data to JSONObject
        obj.put("month", "JAN");
        obj.put("records",salaries);
//        payroll.
        return "Hello";
    }
}
