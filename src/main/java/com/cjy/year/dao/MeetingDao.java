package com.cjy.year.dao;

import com.cjy.year.entity.tMeeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingDao extends JpaRepository<tMeeting,Long> {
    tMeeting findByCode(String code);
}
