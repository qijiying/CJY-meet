package com.cjy.year.dao;

import com.cjy.year.entity.tEmployeeCompounds;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCompoundsDao extends JpaRepository<tEmployeeCompounds,Long> {
    tEmployeeCompounds findByEmployeeIdAndCompoundsId(long employeeId,long compoundsId);
}
