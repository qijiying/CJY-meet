package com.cjy.year.controller;

import com.cjy.year.dao.*;
import com.cjy.year.entity.*;
import com.cjy.year.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private MeetingDao meetingDao;

    @Autowired
    private SignPointDao signPointDao;

    @Autowired
    private EmployeeCompoundsDao employeeCompoundsDao;

    @Autowired
    private MeetingSignRecord meetingSignRecord;

    @GetMapping(value = "meeting")
    public String meeting(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(HttpServletRequest req,@RequestParam String phone,@RequestParam String password,@RequestParam String meetCode){
        tEmployee temployee = new tEmployee();
        //查找员工
        tEmployee em = employeeDao.findByPhoneNumber(phone);
        if (em!=null){
            String pw = null;
            try {
                pw = em.getPassword();
            } catch (Exception e) {
                pw = "1234";
            }
            if (pw.equals(password)){
                //根据code查找会议
                tMeeting tm = meetingDao.findByCode(meetCode);
                if (tm!=null){
                    //根据signPoint查找小区id
                    tSignPoint tsp = signPointDao.findOne(tm.getSignPointId());
                    if (tsp!=null){
                        //根据employeeId和compoundsId查询tEmployeeCompounds
                        tEmployeeCompounds tec = employeeCompoundsDao.findByEmployeeIdAndCompoundsId(em.getId(),tsp.getCompoundsId());
                        if(tec!=null){
                            List<tMeetingSignRecord> recordList = meetingSignRecord.findByMeetingId(tm.getId());
                            System.out.println("--------------欢迎："+em.getName()+"----------------"+recordList.size());
                            List<String> employeeName = new ArrayList<>();
                            List<String> employeeImageUrl = new ArrayList<>();
                            List<tEmployee> employeeList = new ArrayList<>();
                            for (int i = 0; i < recordList.size(); i++) {
                                temployee = employeeDao.findOne(recordList.get(i).getEmployeeId());
                                employeeName.add(temployee.getName());
                                try {
                                    employeeImageUrl.add(temployee.getHeadPicUrl());
                                } catch (Exception e) {
                                    employeeImageUrl.add("");
                                }
                                employeeList.add(temployee);
                            }
                            req.setAttribute("employeeNames",employeeName);
                            req.setAttribute("employeeImageUrls",employeeImageUrl);
                            req.setAttribute("employeeList",employeeList);
                            //返回meetingID
                            req.setAttribute("meetingId",tm.getId());

                            //签到人数
                            req.setAttribute("recordNumber",recordList.size());

                            //设置图片显示每行数
                            String rowString = "test1";
                            List<String> rowList = new ArrayList<>();
                            int row = 8;
                            for (int i = 0; i < row; i++) {
                                rowList.add("test"+(i+1));
                                if(i!=0) rowString += ",test"+(i+1);
                            }
                            req.setAttribute("meetCode",tsp.getCode());
                            req.setAttribute("rowList",rowList);
                            req.setAttribute("rowString",rowString);
                            return "index";
                        }else{
                            req.setAttribute("messageM","没有权限进入该会议！");
                            req.setAttribute("phone",phone);
                            req.setAttribute("password",password);
                        }
                    }else{
                        req.setAttribute("messageM","查找会议区域时出错！");
                        req.setAttribute("phone",phone);
                        req.setAttribute("password",password);
                    }
                }else{
                    req.setAttribute("messageM","会议不存在！");
                    req.setAttribute("phone",phone);
                    req.setAttribute("password",password);
                }
            }else {
                req.setAttribute("messagePW","密码不正确！");
                req.setAttribute("phone",phone);
                req.setAttribute("meetCode",meetCode);
            }
        }else{
            req.setAttribute("messageP","没有查找到该用户！");
            req.setAttribute("meetCode",meetCode);
        }
        //System.out.println("--------"+em.getName()+"-------------");
        return "login";
    }

    @PostMapping(value = "/sign")
    @ResponseBody
    public Map<String,Object> getSignInfo(@RequestParam long meetingId){
        Map<String,Object> map = new HashMap<>();
        tEmployee temployee = new tEmployee();
        List<tMeetingSignRecord> recordList = meetingSignRecord.findByMeetingId(meetingId);
        List<String> employeeName = new ArrayList<>();
        List<String> employeeImageUrl = new ArrayList<>();
        for (int i = 0; i < recordList.size(); i++) {
            temployee = employeeDao.findOne(recordList.get(i).getEmployeeId());
            employeeName.add(temployee.getName());
            try {
                employeeImageUrl.add(temployee.getHeadPicUrl());
            } catch (Exception e) {
                employeeImageUrl.add("");
            }
        }
        System.out.println(meetingId);
        map.put("employeeName",employeeName);
        map.put("employeeImageUrl",employeeImageUrl);
        map.put("recordNumber",recordList.size());
        map.put("recordList",recordList);
        return map;
    }


    @PostMapping(value = "/checkRegister")
    @ResponseBody
    public Map<String,Object> checkRegister(@RequestParam int checkNumber,@RequestParam long meetingId){
        Map<String,Object> map = new HashMap<>();
        boolean flag = false;
        tEmployee temployee = new tEmployee();
        List<tMeetingSignRecord> recordList = meetingSignRecord.findByMeetingId(meetingId);
        List<String> employeeName = new ArrayList<>();
        List<String> employeeImageUrl = new ArrayList<>();
        System.out.println("checkNumber和flag"+checkNumber+"--"+recordList.size());
        if (recordList.size()>checkNumber) {
            flag = true;
                temployee = employeeDao.findOne(recordList.get(checkNumber).getEmployeeId());
                employeeName.add(temployee.getName());
                try {
                    employeeImageUrl.add(temployee.getHeadPicUrl());
                } catch (Exception e) {
                    employeeImageUrl.add("");
                }
                System.out.println("图片:"+employeeImageUrl.get(0)+"名称："+employeeName.get(0));
                map.put("employeeName",employeeName.get(0));
                map.put("employeeImageUrl",employeeImageUrl.get(0));
                map.put("recordNumber",recordList.size());
        }
        map.put("flag",flag);
        return map;
    }
}
