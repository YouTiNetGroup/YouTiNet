package com.youti.api.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.youti.api.bean.AccountBean;
import com.youti.api.service.AccountService;
import com.youti.api.utils.RespEntity;

/**
 * 账号管理
 */
@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
	@Resource
	private AccountService accountService;

	/**
	 * 获取用户信息
	 */
	@RequestMapping("/getUserInformation")
	@ResponseBody
//	public RespEntity getUserInformation(@RequestBody Map<String, String> params) {
	public RespEntity getUserInformation(@RequestParam(value = "account_id", required = true) String account_id) {
		RespEntity respEntity = new RespEntity();
		AccountBean account = accountService.findById(account_id);
		if (account == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("账号不存在");
		} else {
			respEntity.setIsSuccess(true);
			respEntity.setMessage("成功");
			respEntity.setData(account);
		}
		return respEntity;
	}

	/**
	 * 获取所有用户信息
	 */
	@RequestMapping("/getAllUsers")
	@ResponseBody
	public RespEntity getAllUsers() {
		List<AccountBean> accountList = accountService.findAll();
		RespEntity respEntity = new RespEntity(true, accountList, "成功");
		return respEntity;
	}

	/**
	 * 创建新账号 //
	 */
	/*
	 * @RequestMapping("/create")
	 * 
	 * @ResponseBody public RespEntity createAccount(@RequestBody AccountBean
	 * accountBean) { RespEntity respEntity = new RespEntity();
	 * 
	 * if (accountService.findById(accountBean.getAccount_id()) != null) {
	 * respEntity.setIsSuccess(false); respEntity.setMessage("账号已经存在"); } else {
	 * accountService.save(accountBean); respEntity.setIsSuccess(true);
	 * respEntity.setMessage("账号创建成功"); } return respEntity; }
	 */

	/**
	 * 删除用户信息
	 */
	@RequestMapping("/deleteUserByAccountId")
	@ResponseBody
	public RespEntity deleteUserByAccountId(@RequestBody Map<String, String> params) {
		RespEntity respEntity = new RespEntity();
		String account_id = params.get("account_id");

		if (accountService.findById(account_id) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("账号不存在");
		} else {
			accountService.deleteById(account_id);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("账号删除成功");
		}
		return respEntity;
	}

	/**
	 * 更新用户信息
	 */
	@RequestMapping("/updateUserInformation")
	@ResponseBody
	public RespEntity updateUserInformation(@RequestBody AccountBean accountBean) {
		RespEntity respEntity = new RespEntity();

		if (accountService.findById(accountBean.getAccount_id()) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("账号不存在");
		} else {
			accountService.save(accountBean);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("用户信息更新成功");
		}
		return respEntity;
	}

}
