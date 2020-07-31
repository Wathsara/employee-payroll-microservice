package com.assigiment.payrollService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/v1")
public class PayrollController {

    @Autowired
    private PayrollRepository payroll;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to Software Engineering Assignment. PayrollService";
    }

    @RequestMapping(value= "/paysheets", method=RequestMethod.GET)
    public List<Payroll> getPaySheets(){

        return payroll.findAll();
    }


    @RequestMapping(value = "/paysheet", method = RequestMethod.POST)
    public Object createPaySheet(@RequestBody Payroll payrollDetails) throws Exception{

        List<PayrollHistory> employee = new LinkedList<PayrollHistory>();
        JSONArray arr = getEmployeeData();
        for (int i = 0; i < arr.size(); i++) {
            JSONObject jo = (JSONObject) arr.get(i);
            PayrollHistory emp1 = new PayrollHistory();
            emp1.setEmployee_id((Long) jo.get("id"));
            emp1.setBasic_salary((Double) jo.get("basicSalary"));
            if((Boolean) jo.get("permanent")){
                emp1.setSalary_pension_deducted_amount((Double) jo.get("basicSalary")*12/100);
                emp1.setFinal_salary((Double) jo.get("basicSalary")*80/100);
            }else{
                emp1.setSalary_pension_deducted_amount(0);
                emp1.setFinal_salary((Double) jo.get("basicSalary")*92/100);
            }
            emp1.setSalary_EPF_deducted_amount((Double) jo.get("basicSalary")*8/100);
            emp1.setPaid_by_the_employer_on_behalf_of_the_employee_to_the_EPF((Double) jo.get("basicSalary")*12/100);
            emp1.setTotol_EPF((Double) jo.get("basicSalary")*12/100 + (Double) jo.get("basicSalary")*8/100);
            employee.add(emp1);
        }
        Payroll obj = new Payroll();
        obj.setMonth(payrollDetails.getMonth());
        obj.setYear(payrollDetails.getYear());
        obj.setRecords(employee);
        payroll.save(obj);
        return ResponseEntity.ok().body("PaySheet created successfully");
    }

    @RequestMapping(value= "/paysheet/{year}/{month}", method=RequestMethod.GET)
    public JSONObject getPaySheets(@PathVariable(value = "year") int year , @PathVariable(value = "month") int month) throws Exception {
        Payroll details = payroll.findByYearAndMonth(year,month)
                .orElseThrow(() -> new NotFoundException("PaySheet is not available for : Year "+year+" Month-"+month));

        List<PayrollHistory> historyArr = details.getRecords();
        JSONObject full_details = new JSONObject();
        JSONArray salary_employee = new JSONArray();
        for (PayrollHistory payrollHistory : historyArr) {
            JSONObject employerDetails = new JSONObject();
            PayrollHistory jo = payrollHistory;
            JSONObject employer = getEmployeeDataById((int) jo.getEmployee_id());
            employerDetails.put("employer", employer);
            employerDetails.put("PaySheet", jo);
            salary_employee.add(employerDetails);

        }
        full_details.put("Month", details.getMonth());
        full_details.put("year", details.getYear());
        full_details.put("PaySheet", salary_employee);
        return full_details;
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
        JSONParser parser = new JSONParser();
        Object json = parser.parse(result.toString());
        JSONArray jsonArr = (JSONArray) json;
        return jsonArr;
    }

    private static JSONObject getEmployeeDataById(int id) throws Exception{

        StringBuilder result = new StringBuilder();
        URL url = new URL("http://35.247.184.208:8000/api/v1/employee/"+id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(result.toString());
        return json;
    }
}
