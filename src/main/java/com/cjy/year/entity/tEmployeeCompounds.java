package com.cjy.year.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "t_employee_compounds")
@NamedQuery(name = "tEmployeeCompounds.findByEmployeeIdAndCompoundsId",
        query = "select t from t_employee_compounds t where employee_id=? and compounds_id=?")
public class tEmployeeCompounds {

    @Id
    @GeneratedValue
    private Long id;

    private long employeeId;

    private long compoundsId;

    public tEmployeeCompounds() {
    }

    public tEmployeeCompounds(long employeeId, long compoundsId) {
        this.employeeId = employeeId;
        this.compoundsId = compoundsId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getCompoundsId() {
        return compoundsId;
    }

    public void setCompoundsId(long compoundsId) {
        this.compoundsId = compoundsId;
    }
}
