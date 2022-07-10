package com.example.springbootsample.controller;

import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springbootsample.application.service.UserApplicationService;
import com.example.springbootsample.domain.user.model.MUser;
import com.example.springbootsample.domain.user.service.UserService;
import com.example.springbootsample.form.GroupOrder;
import com.example.springbootsample.form.SignupForm;

import lombok.extern.slf4j.Slf4j;
//@RequestMapping。コントローラに付与して、リクエスト URL に対してどのメソッドの処理を実行するかを定義します。
@Controller
@RequestMapping("/user")
//Javaのロギング実装の柔軟な切り替えを実現するFacadeのことをSLF4Jといいます。
@Slf4j
public class SignupController {

    @Autowired
    private UserApplicationService userApplicationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping("/signup")
    public String getSignup(Model model,Locale locale,@ModelAttribute SignupForm form) {
        // Get gender
        Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);

        return "user/signup";
    }

    /* ユーザー登録処理 */
    @PostMapping("/signup")
    public String postSignup(Model model,Locale locale,
    @ModelAttribute @Validated(GroupOrder.class) SignupForm form,
    BindingResult bindingResult){          
        if(bindingResult.hasErrors()){
            return getSignup(model,locale,form);
        }      
        log.info(form.toString());
        //formをMUserクラスに変換
        MUser user = modelMapper.map(form, MUser.class);
        userService.signup(user);
        return "redirect:/login";
    }

    /**データベース関連の例外処理*/
	@ExceptionHandler(DataAccessException.class) 
	public String dataAccessExceptionHandler(DataAccessException e, Model model) {
		
		//空文字をセット
		model.addAttribute("error", "");
		
		//メッセージをModelに登録
		model.addAttribute("message", "An exception occured in SignupController");
		
		//register HTTP error code(500) in Model
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return "error";
		
	}
}