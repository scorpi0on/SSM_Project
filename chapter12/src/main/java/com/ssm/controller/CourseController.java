package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CourseController {
    @RequestMapping(value = "/toCourse")
    public String toCourse(){
        return "course";
    }

    @RequestMapping(value = "/deleteCourse")
    public String deleteCourse(Integer[] ids){
        if (ids != null){
            for (Integer id : ids){
                System.out.println("The id=" + id + " has been delete");
            }
        }else {
            System.out.println("ids = null");
        }
        return "success";
    }
}
