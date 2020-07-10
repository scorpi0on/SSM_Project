package com.ssm.controller;

import com.ssm.po.Banji;
import com.ssm.po.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentContorller {
    @RequestMapping(value = "/todfindStudentWithBanji")
    public String tofindStudentWithBanji(){
        return "student";
    }
    @RequestMapping(value = "/findStudentWithBanji")
    public String findStudentWithBanji(Student student){
        Integer stu_id = student.getStu_id();
        Banji banji = student.getBanji();
        String banji_name = banji.getBanji_name();
        System.out.println("stu_id="+stu_id);
        System.out.println("banji_name="+banji_name);
        return "success";
    }
}
