package com.assigiment.payrollService;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    Payroll findByYearAndMonth(int year, int month);
}
