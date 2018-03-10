package com.cjy.year.repository;

import com.cjy.year.entity.tEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<tEmployee,Long> {
}
