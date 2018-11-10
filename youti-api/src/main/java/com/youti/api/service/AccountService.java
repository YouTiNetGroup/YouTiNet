package com.youti.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

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
		Optional<AccountBean> accountBean = accountRepository.findById(id);
		return accountBean.get();
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

}
