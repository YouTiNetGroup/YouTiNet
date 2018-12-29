package com.youti.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youti.api.bean.AccountBean;
import com.youti.api.repository.AccountRepository;

@Service
public class AccountService {
	@Resource
    private AccountRepository accountRepository;
	
	/**
	 * 新增/更新单个账号
	 * @param AccountBean
	 * */
	@Transactional
    public void save(AccountBean accountBean){
		accountRepository.save(accountBean);
    }
	
	/**
	 * 新增/更新多个账号
	 * @param List<AccountBean>
	 * */
	public void saveAllList(List<AccountBean> list) {
		accountRepository.saveAll(list);
	}
	
	
	/**
	 * 根据id删除账号
	 * @param id
	 * */
	@Transactional
	public void deleteById(String id) {
		accountRepository.deleteById(id);
	}
	
	/**
	 * 删除多个账号
	 * @param List<AccountBean>
	 * */
	@Transactional
	public void deleteAllList(List<AccountBean> list) {
		accountRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据id修改昵称
	 * @param id, name
	 * */
	@Transactional
	public void updateNameById(String id, String name) {
		Optional<AccountBean> sessionAccount = accountRepository.findById(id);
		sessionAccount.get().setName(name);
		accountRepository.save(sessionAccount.get());
	}
	
	/**
	 * 根据id修改email
	 * @param id, email
	 * */
	@Transactional
	public void updateEmailById(String id, String email) {
		Optional<AccountBean> sessionAccount = accountRepository.findById(id);
		sessionAccount.get().setEmail(email);
		accountRepository.save(sessionAccount.get());
	}
	
	/**
	 * 根据id修改电话
	 * @param id, phone
	 * */
	@Transactional
	public void updatePhoneById(String id, String phone) {
		Optional<AccountBean> sessionAccount = accountRepository.findById(id);
		sessionAccount.get().setPhone(phone);
		accountRepository.save(sessionAccount.get());
	}
	
	/**
	 * 根据id修改密码
	 * @param id, password
	 * */
	@Transactional
	public void updatePasswordById(String id, String password) {
		Optional<AccountBean> sessionAccount = accountRepository.findById(id);
		sessionAccount.get().setPassword(password);
		accountRepository.save(sessionAccount.get());
	}
	
	/**
	 * 根据id查找账号
	 * @param id
	 * */
	@Transactional
	public AccountBean findById(String id) {
		Optional<AccountBean> accountOptional = accountRepository.findById(id);
		if(accountOptional.isPresent()){
			return accountOptional.get();
		}
		return null;
	}
	
	
	/**
	 * 根据权限查找账号
	 * @param privilege
	 * */
	@Transactional
	public List<AccountBean> findByPrivilege(String privilege) {
		
		Iterator<AccountBean> iterator = accountRepository.findAll().iterator();
		List<AccountBean> list = new ArrayList<AccountBean>();
		AccountBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getPrivilege().equals(privilege)) {
				list.add(temp);
			}
		}
		return list;
	}
	
	
	/**
	 * 查找所有账号
	 * */
	@Transactional
	public List<AccountBean> findAll() {
		return accountRepository.findAll();
	}
	
	/**
	 * 分页查找所有账号
	 * */
	@Transactional
	public Page<AccountBean> findAll(Pageable pageable){
		return accountRepository.findAll(pageable);
	}
	
	
	/**
	 * 验证账号
	 * */
	@Transactional
	public boolean verify(AccountBean accountBean) {
		boolean verify = false;
		Optional<AccountBean> sessionAccount = accountRepository.findById(accountBean.getAccount_id());
		
		if(sessionAccount.isPresent()){
			verify = accountBean.getPassword().equals(sessionAccount.get().getPassword()) && 
					accountBean.getPrivilege().equals(sessionAccount.get().getPrivilege());
		}
		return verify;
	}

}
