package com.example.springbootsample.aspect;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllAdvice {
	
	/** データベース関連の例外処理*/
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
	
	/** その他の例外処理*/
	@ExceptionHandler(Exception.class) 
	public String exceptionHandler(Exception e, Model model) {
		
		//空文字をセット
		model.addAttribute("error", "");
		
		//メッセージをModelに登録
		model.addAttribute("message", "An exception occured in SignupController");
		
		//register HTTP error code(500) in Model
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		
		return "error";
		
	}

}