package com.youti.api.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youti.api.bean.SubjectBean;
import com.youti.api.repository.SubjectRepository;

@Service
public class SubjectService {
	@Resource
	private SubjectRepository subjectRepository;
	
	/**
	 * 新增/更新 单个学科
	 * @param SubjectBean
	 * */
	@Transactional
	public void save(SubjectBean subjectBean) {
		//TODO
	}
	
	/**
	 * 新增/更新 多个学科
	 * @param List<SubjectBean>
	 * */
	@Transactional
	public void saveAll(List<SubjectBean> list) {
		//TODO
	}
	
	/**
	 * 根据id删除学科
	 * @param id
	 * */
	@Transactional
	public void deleteById(int id) {
		//TODO
	}
	
	/**
	 * 删除多个学科
	 * List<QuestionTypeBean>
	 * */
	@Transactional
	public void deleteAllList(List<SubjectBean> list) {
		//TODO
	}
	
	/**
	 * 根据id修改学科
	 * @param id,subject
	 * */
	@Transactional
	public void updateSubjectById(int id,String subject) {
		//TODO
	}
	
	/**
	 * 根据id查找学科
	 * @param id
	 * */
	@Transactional
	public SubjectBean findById(int id) {
		//TODO
		return null;
	}
	

	/**
	 * 查找所有试题类型
	 * */
	@Transactional
	public List<SubjectBean> findAll() {
		//TODO
		return null;
	}

}
