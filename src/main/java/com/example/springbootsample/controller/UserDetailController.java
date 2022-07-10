package com.example.springbootsample.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample.domain.user.model.MUser;
import com.example.springbootsample.domain.user.service.UserService;
import com.example.springbootsample.form.UserDetailForm;

@Controller
@RequestMapping("/user")
public class UserDetailController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper; //instantiated in JavaConfig.java class as a @Bean

    //ユーザー詳細画面を表示
    @GetMapping("/detail/{userId:.+}")
	public String getUser(UserDetailForm form, Model model, @PathVariable("userId") String userId) {
		
		//ユーザーを１件取得
		MUser user = userService.getUserOne(userId);
		user.setPassword(null);
		
		//MUserをformに変換
		form = modelMapper.map(user, UserDetailForm.class);
		form.setSalaryList(user.getSalaryList());

		//Modelに登録
		model.addAttribute("userDetailForm", form);
		
		//ユーザー詳細画面を表示
		return "user/detail";
		
	}

    /* ユーザー更新処理 */
    @PostMapping(value="/detail", params = "update")
	public String updateUser(UserDetailForm form, Model model) {
		userService.updateUserOne(form.getUserId(),form.getPassword(),form.getUserName());
		return "redirect:/user/list";
	}
	
}
