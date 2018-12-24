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
	private AccountBean account=new AccountBean();
	
	@PostMapping("/regist")
	@ResponseBody
    public RespEntity Register(HttpServletRequest request){
		RespEntity respEntity = new RespEntity();
		String account_id=request.getParameter("account_id");
	    String password=request.getParameter("password");
        String privilege=request.getParameter("privilege");
        account=accountService.findById(account_id);
    
        if (account==null) {
        	AccountBean account = new AccountBean();
        	account.setAccount_id(account_id);
        	account.setPassword(password);
        	account.setPrivilege(privilege);
        	accountService.save(account);
        	respEntity.setIsSuccess(true);
        	respEntity.setMessage("注册成功");
        } else {
        	respEntity.setIsSuccess(false);
        	respEntity.setMessage("ID已经存在");
        }
        return respEntity;
    }

	
}
