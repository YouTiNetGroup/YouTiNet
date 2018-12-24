package com.youti.api.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.youti.api.bean.AccountBean;
import com.youti.api.service.AccountService;
import com.youti.api.utils.RespEntity;


/**
 * 账号管理(管理员)
 * */
@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
	@Resource
	private AccountService accountService;
	
	/**
	 * 获取单个账号信息
	 * */
	@RequestMapping("/get")
	@ResponseBody
	public RespEntity getAcoountMessage(@RequestBody AccountBean accountBean) {
		RespEntity respEntity = new RespEntity();
		
		AccountBean account = accountService.findById(accountBean.getAccount_id());
		if(account == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("账号不存在");
		}else {
			respEntity.setIsSuccess(true);
			respEntity.setMessage("成功");
			respEntity.setData(account);
		}
		return respEntity;
	}
	
	
	/**
	 * 获取账号列表
	 * */
	@RequestMapping("/list")
	@ResponseBody
	public RespEntity getAccountList(){
		List<AccountBean> accountList = accountService.findAll();
		RespEntity respEntity = new RespEntity(true,accountList,"成功");
		return respEntity;
	}
	
	/**
	 * 创建新账号 
	 * */
	@RequestMapping("/create")
	@ResponseBody
	public RespEntity createAccount(@RequestBody AccountBean accountBean) {
		RespEntity respEntity = new RespEntity();
		
		if(accountService.findById(accountBean.getAccount_id()) != null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("账号已经存在");
		}else {
			accountService.save(accountBean);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("账号创建成功");
		}
		return respEntity;
	}
	
	/**
	 * 删除账号
	 * */
	@RequestMapping("/delete")
	@ResponseBody
	public RespEntity deleteAccount(@RequestBody AccountBean accountBean) {
		RespEntity respEntity = new RespEntity();

		if(accountService.findById(accountBean.getAccount_id()) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("账号不存在");
		}else {
			accountService.deleteById(accountBean.getAccount_id());
			respEntity.setIsSuccess(true);
			respEntity.setMessage("账号删除成功");
		}
		return respEntity;
	}
	
	/**
	 * 修改账号信息
	 * */
	@RequestMapping("/modify")
	@ResponseBody
	public RespEntity modifyAccount(@RequestBody AccountBean accountBean) {
		RespEntity respEntity = new RespEntity();
		
		if(accountService.findById(accountBean.getAccount_id()) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("账号不存在");
		}else {
			accountService.save(accountBean);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("账号信息修改成功");
		}
		return respEntity;
	}
	
	
}
