package com.example.springbootsample.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample.application.service.UserApplicationService;
//@RequestMapping。コントローラに付与して、リクエスト URL に対してどのメソッドの処理を実行するかを定義します。
@Controller
@RequestMapping("/user")
public class SignupController {

    @Autowired
    private UserApplicationService userApplicationService;

    @GetMapping("/signup")
    public String getSignup(Model model) {
        // Get gender
        Map<String, Integer> genderMap = userApplicationService.getGenderMap();
        model.addAttribute("genderMap", genderMap);

        return "user/signup";
    }

    @PostMapping("/signup")
    public String postSignUp() {
        return "redirect:/login";
    }
}