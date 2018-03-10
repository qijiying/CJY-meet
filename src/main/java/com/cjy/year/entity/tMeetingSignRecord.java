package com.cjy.year.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity(name = "t_meeting_sign_record")
@NamedQuery(name = "tMeetingSignRecord.findByMeetingId",
        query = "select t from t_meeting_sign_record t where meeting_id=?1")
public class tMeetingSignRecord {

    @Id
    @GeneratedValue
    private Long id;

    private long meetingId;

    private long employeeId;

    private Date signInTime;

    public tMeetingSignRecord() {
    }

    public tMeetingSignRecord(long meetingId, long employeeId, Date signInTime) {
        this.meetingId = meetingId;
        this.employeeId = employeeId;
        this.signInTime = signInTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(long meetingId) {
        this.meetingId = meetingId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }
}
