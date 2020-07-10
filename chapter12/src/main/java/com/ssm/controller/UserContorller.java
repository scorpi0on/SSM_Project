package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ssm.po.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserContorller {
    @RequestMapping(value = "/selectUser")
    public String selectUser(@RequestParam(value = "user_id") Integer id){
//        String id=request.getParameter("id");
        System.out.println("id="+id);
        return "success";
    }
    @RequestMapping(value = "toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "/registerUser")
    public String registerUser(User user){
        String username = user.getUsername();
        String password = user.getPassword();

        System.out.println("username="+username);
        System.out.println("password="+password);
        return "success";
    }
}
