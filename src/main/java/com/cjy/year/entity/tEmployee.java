package com.cjy.year.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "t_employee")
@NamedQuery(name = "tEmployee.findByPhoneNumber",
        query = "select t from t_employee t where phone=?1")
public class tEmployee {
    @Id
    @GeneratedValue
    private long id;

    private String code;

    private String name;

    private String phone;

    //private int jobs;

    //private Date birthday;

    //private long terminalId;

    private String password;

    private String headPicUrl;

    //private int deptId;

    private String remarks;

    //private int operator;

    //private int defaultCompoundsId;

    //private int status;

    //private float sequenceNumber;

    //private String face_data;

    public tEmployee() {
        super();
    }

    public tEmployee(String name, String phone, String password, String headPicUrl) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.headPicUrl = headPicUrl;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }
}
