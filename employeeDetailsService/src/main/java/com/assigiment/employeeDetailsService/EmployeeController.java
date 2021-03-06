package com.assigiment.employeeDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/v1")
@RibbonClient(name="employee-details-service")
public class EmployeeController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    Environment environment;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        ServiceInstance instance = loadBalancer.choose("employee-details-service");
        String Port = String.valueOf(instance.getPort());
        return ("Welcome to Software Engineering Assignment.\n I am running on Port : "+Port);
    }

    @RequestMapping(
            value = "/employees",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE}
            )
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeRepository.findAll();
        return list;
    }
    @PostMapping("/employee")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee) {
            employeeRepository.save(employee);
            return ResponseEntity.created(URI.create("/api/v1/employee/"+employee.getId())).body("Employee Created Successfully");
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws IllegalArgumentException {
            return employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new NotFoundException(String.format("Employee not found for this id :: " + employeeId)));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws IllegalArgumentException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NotFoundException(String.format("Employee not found for this id :: " + employeeId)));

        employeeRepository.delete(employee);
        return ResponseEntity.ok().body("Employee Deleted");
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity < Employee > updateEmployee(@Valid @PathVariable(value = "id") Long employeeId,
                                                      @RequestBody Employee employeeDetails) throws IllegalArgumentException {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Employee not found for this id :: " + employeeId))
                );

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
