package com.cjy.year.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity(name = "t_meeting")
@NamedQuery(name = "tMeeting.findByCode",
        query = "select t from t_meeting t where code=?1")
public class tMeeting {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private Long signPointId;

    private Date startTime;

    private Date endTime;

    public tMeeting() {
    }

    public tMeeting(String name, String address, Long signPointId, Date startTime, Date endTime) {
        this.name = name;
        this.address = address;
        this.signPointId = signPointId;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getSignPointId() {
        return signPointId;
    }

    public void setSignPointId(Long signPointId) {
        this.signPointId = signPointId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
