package com.assigiment.payrollDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/v1")
public class PayrollController {

    @Autowired
    private PayrollRepository payrollRepository;

    @RequestMapping("/")
    @ResponseBody

    @RequestMapping(
            value = "/payrollsheet",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE}
            )
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = employeeRepository.findAll();
        return list;
    }


    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws IllegalArgumentException {
            return employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new NotFoundException(String.format("Employee not found for this id :: " + employeeId)));
    }

    @GetMapping("/payroll/{id}")
    public Employee getPayrollById(@PathVariable(value = "id") Long payrollId)
            throws IllegalArgumentException {
            return payrollRepository.findById(Id)
                    .orElseThrow(() -> new NotFoundException(String.format("Payroll not found for this id :: " + payrollId)));
    }

    @PutMapping("/payroll/{id}")
    public ResponseEntity < Payroll > updatePayroll(@Valid @PathVariable(value = "id") Long payrollId,
                                                      @RequestBody Payroll payrollDetails,) throws IllegalArgumentException {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Employee not found for this id :: " + employeeId))
                );

        Payroll payroll = payrollRepository.findById(payrollId)
            .orElseThrow(() ->
                    new NotFoundException(String.format("Payroll not found for this id :: " + payrollId))
        );

        payroll.Id(payrollDetailsDetails.getId());
        employee.employee_id(employeeDetails.getId());
        payroll.salary_after_pension_deducted(payrollDetails.getSalaryAfterPensionDeducted());
        payroll.salary_after_EPF_deducted(payrollDetails.getSalaryAfterEPFDeducted());
        payroll.paid_by_the_employer_on_behalf_of_the_employee_to_the_EPF(payrollDetails.getSalaryPaidByTheEmployerOnBehalfOfTheEmployeeToTheEPF());
 
        final Payroll updatedPayroll = payrollRepository.save(payroll);

        return ResponseEntity.ok(updatedPayroll);
    }
}