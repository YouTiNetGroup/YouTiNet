package com.youti.api.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.youti.api.bean.AccountBean;
import com.youti.api.service.AccountService;
import com.youti.api.utils.RespEntity;

/**
 * 登录
 * */
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
	@Resource
	private AccountService accountService;
	
	/**
	 * 登录验证
	 * */
	@PostMapping("/verify")
	@ResponseBody
    public RespEntity loginVerify(@RequestBody AccountBean accountBean, HttpSession session){
		RespEntity respEntity = new RespEntity();

        boolean verify = accountService.verify(accountBean);
        if (verify) {
        	session.setAttribute("account_id", accountBean.getAccount_id());
        	respEntity.setIsSuccess(true);
        	respEntity.setMessage("登录验证成功");
        } else {
        	respEntity.setIsSuccess(false);
        	respEntity.setMessage("登录验证失败");
        }
        return respEntity;
    }



}
