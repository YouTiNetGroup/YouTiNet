package com.youti.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.youti.api.bean.AccountBean;
import com.youti.api.service.AccountService;
import com.youti.api.utils.RespEntity;

/**
 * 用户个人信息管理
 * */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	@Resource
	private AccountService accountService;
	
	/**
	 * 修改密码
	 * */
	@RequestMapping("/modifypwd")
	@ResponseBody
	public RespEntity modifyPssword(@RequestBody AccountBean accountBean,HttpSession session) {
		//不用判断账号是否存在，因为登录了的用户才能修改
		accountService.updatePasswordById(accountBean.getAccount_id(), accountBean.getPassword());
		session.removeAttribute("account_id");
		RespEntity respEntity = new RespEntity(true,null,"修改密码成功");
		return respEntity;
	}
	
	/**
	 * 登出
	 * */
	@RequestMapping("/logout")
	@ResponseBody
    public RespEntity logout(HttpSession session){
        session.removeAttribute("account_id");
        RespEntity respEntity = new RespEntity(true,null,"登出成功");
		return respEntity;
    }
	
}
