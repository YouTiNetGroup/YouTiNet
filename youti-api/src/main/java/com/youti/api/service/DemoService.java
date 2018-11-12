package com.youti.api.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youti.api.bean.DemoBean;
import com.youti.api.repository.DemoRepository;

@Service
public class DemoService {
	//resource自动注入对象
		//transactional事务

		@Resource
	    private DemoRepository demoRepository;
	    
		/**
		 * save,update ,delete 方法需要绑定事务. 使用@Transactional进行事务的绑定.
		 * 
		 * @param TestBean
		 * 保存对象
		 */
		@Transactional
	    public void save(DemoBean demoBean){
			demoRepository.save(demoBean);
	    }

		
		/**
		* 根据id删除对象
		*
		* @param id
		*/

		@Transactional
		public void deleteById(int id){
			demoRepository.deleteById(id);
		}

		/**
		* 查询所有数据
		*
		* @return
		*/
		public List<DemoBean> getAll(){
			return demoRepository.findAll();
		}

		/**
		* 修改用户对象数据
		*
		* @param testBean
		*/

		@Transactional
		public void update(int id){
			Optional<DemoBean> sessionDemo = demoRepository.findById(id);
			sessionDemo.get().setContent("change");
			demoRepository.save(sessionDemo.get());
		}
}
