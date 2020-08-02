package com.ssm.controller;

import com.ssm.po.User;
import com.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/findUserById")
    public String findUserById(Integer id, Model model){
        User user=userService.findUserByID(id);
        model.addAttribute("user", user);
        return "user";
    }
}
