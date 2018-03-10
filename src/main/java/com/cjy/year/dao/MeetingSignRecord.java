package com.cjy.year.dao;

import com.cjy.year.entity.tMeetingSignRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingSignRecord extends JpaRepository<tMeetingSignRecord,Long> {
    List<tMeetingSignRecord> findByMeetingId(long meeting_id);
}
