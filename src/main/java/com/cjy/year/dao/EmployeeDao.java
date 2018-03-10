package com.cjy.year.dao;


import com.cjy.year.entity.tEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeDao extends JpaRepository<tEmployee,Long>{
    tEmployee findByPhoneNumber(String phone);
}
