package com.youti.api.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

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
 * 注册
 */
@RestController
@RequestMapping("/account")
@CrossOrigin
public class RegisterController {
	@Resource
	private AccountService accountService;

	/**
	 * 注册
	 */
	@PostMapping("/register")
	@ResponseBody
	public RespEntity register(@RequestBody AccountBean accountBean) {
		RespEntity respEntity = new RespEntity();

		if (accountService.findById(accountBean.getAccount_id()) == null) {
			accountBean.setPrivilege("user");
			accountService.save(accountBean);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("注册成功");
		} else {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("ID已经存在");
		}

		return respEntity;
	}

}
