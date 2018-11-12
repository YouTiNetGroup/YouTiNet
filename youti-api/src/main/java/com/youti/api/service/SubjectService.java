package com.youti.api.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youti.api.bean.QuestionTypeBean;
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
		subjectRepository.save(subjectBean);
	}
	
	/**
	 * 新增/更新 多个学科
	 * @param List<SubjectBean>
	 * */
	@Transactional
	public void saveAll(List<SubjectBean> list) {
		//TODO
		subjectRepository.saveAll(list);
	}
	
	/**
	 * 根据id删除学科
	 * @param id
	 * */
	@Transactional
	public void deleteById(int id) {
		//TODO
		subjectRepository.deleteById(id);
	}
	
	/**
	 * 删除多个学科
	 * List<QuestionTypeBean>
	 * */
	@Transactional
	public void deleteAllList(List<SubjectBean> list) {
		//TODO
		subjectRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据id修改学科
	 * @param id,subject
	 * */
	@Transactional
	public void updateSubjectById(int id,String subject) {
		//TODO
		Optional<SubjectBean> sessionsubject= subjectRepository.findById(id);
		sessionsubject.get().setSubject(subject);
		subjectRepository.save(sessionsubject.get());
	}
	
	/**
	 * 根据id查找学科
	 * @param id
	 * */
	@Transactional
	public SubjectBean findById(int id) {
		//TODO
		return subjectRepository.findById(id).get();
	}
	

	/**
	 * 查找所有试题类型
	 * */
	@Transactional
	public List<SubjectBean> findAll() {
		//TODO
		return subjectRepository.findAll();
	}

}
