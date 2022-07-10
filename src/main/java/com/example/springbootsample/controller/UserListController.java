package com.example.springbootsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample.domain.user.model.MUser;
import com.example.springbootsample.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserListController {
    @Autowired
    private UserService userService;
    
    //ユーザー一覧表示
    @GetMapping("/list")
    public String getUserList(Model model){
        List<MUser>userList=userService.getUsers();
        model.addAttribute("userList",userList);
        return "user/list";
    }
}
