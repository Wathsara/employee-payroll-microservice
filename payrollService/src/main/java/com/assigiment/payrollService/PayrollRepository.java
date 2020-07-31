package com.assigiment.payrollService;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    Optional<Payroll> findByYearAndMonth(int year, int month);
}
