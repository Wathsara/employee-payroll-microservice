package com.assigiment.employeeDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to Software Engineering Assignment.";
    }

    @RequestMapping(
            value = "/api/v1/employees",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE}
            )
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeRepository.findAll();
        return list;
    }
    @PostMapping("/api/v1/employee")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
            employeeRepository.save(employee);
            return ResponseEntity.created(URI.create("/api/v1/employee/"+employee.getId())).body("Employee Created Successfully");
    }

    @GetMapping("/api/v1/employee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ExpressionException {
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ExpressionException("Employee not found for this id :: " + employeeId));
            return ResponseEntity.ok().body(employee);
    }

    @DeleteMapping("/api/v1/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws Exception {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ExpressionException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        return ResponseEntity.ok().body("Employee Deleted");
    }

    @PutMapping("/api/v1/employee/{id}")
    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                      @RequestBody Employee employeeDetails) throws ExpressionException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ExpressionException("Employee not found for this id :: " + employeeId));

        employee.setFullName(employeeDetails.getFullName());
        employee.setAddress(employeeDetails.getAddress());
        employee.setEmail(employeeDetails.getEmail());
        employee.setBasicSalary(employeeDetails.getBasicSalary());
        employee.setPermanent(employeeDetails.isPermanent());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setDob(employeeDetails.getDob());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
