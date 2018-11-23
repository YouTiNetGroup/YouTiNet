package com.youti.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youti.api.service.AccountService;

/**
 *注册 
 * */
@RestController
@RequestMapping("/register")
@CrossOrigin
public class RegisterController {
	@Resource
	private AccountService accountService;

	/**
	 * 注册
	 * */
	
	
	
	
}
