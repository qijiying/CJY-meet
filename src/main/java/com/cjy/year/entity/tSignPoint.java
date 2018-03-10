package com.cjy.year.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "t_sign_point")
public class tSignPoint {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private long compoundsId;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public tSignPoint() {
    }

    public tSignPoint(String name, long compoundsId, String code) {
        this.name = name;
        this.compoundsId = compoundsId;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCompoundsId() {
        return compoundsId;
    }

    public void setCompoundsId(long compoundsId) {
        this.compoundsId = compoundsId;
    }
}
