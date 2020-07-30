package com.assigiment.payrollService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import org.json.JSONObject;

import java.io.*;
import java.net.*;

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

    @RequestMapping(value= "/get_payrolls", method=RequestMethod.GET)
    public List<Payroll> test1(){
        return payroll.findAll();
    }


    @RequestMapping(value = "/payroll", method = RequestMethod.GET)
    public Object getPayroll() throws Exception{

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

//        payroll.save(obj);
        JSONArray arr = getEmployeeData();
        Object jsonValue;
        for (int i = 0; i < arr.size(); i++) {
            JSONObject jo = (JSONObject) arr.get(i);
            String firstName = (String) jo.get("fullName");
            System.out.println(firstName);
        }
        arr.forEach(item -> {

            System.out.println(item.getClass());
        });
        return getEmployeeData();

    }


    private static JSONArray getEmployeeData() throws Exception{

        StringBuilder result = new StringBuilder();
        URL url = new URL("http://35.247.184.208:8000/api/v1/employees");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        //System.out.println(result.toString());

        // json string
        String jsonStr = "{\"Fullname\": \"Address\", \"Email\": \"Basic_Salary\": \"Is_Permenent\": \"Department\": \"DOB\"}";
        // convert to json object
//        JSONObject json = new JSONObject(result);
        // print object
//        System.out.println(json.toString());

        JSONParser parser = new JSONParser();
        Object json = parser.parse(result.toString());
        JSONArray jsonArr = (JSONArray) json;
        return jsonArr;
    }

//    private static String putPayrollData() throws Exception{
//        String sql = "insert into payroll (month, fullname, address, email, basic_salary, is_permenent, department, dob) values (?, ?, ?, ?,?, ?, ?)";
//        Connection connection = new getConnection();
//        PreparedStatement ps = connection.prepareStatement(sql);
//
//        for (Payroll payroll: payrolls) {
//            ps.setString(1, obj.getMonth());
//            ps.setString(1, employeeDetails.getFullName());
//            ps.setString(2, employeeDetails.getAddress());
//            ps.setString(3, employeeDetails.getEmail());
//            ps.setString(3, employeeDetails.getBasicSalary());
//            ps.setString(3, employeeDetails.isPermenent());
//            ps.setString(3, employeeDetails.getDepartment());
//            ps.setString(3, employeeDetails.getDob());
//            ps.addBatch();
//        }
//        ps.executeBatch();
//
//
//    }
}
