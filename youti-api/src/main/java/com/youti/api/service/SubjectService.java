package com.youti.api.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		subjectRepository.save(subjectBean);
	}
	
	/**
	 * 新增/更新 多个学科
	 * @param List<SubjectBean>
	 * */
	@Transactional
	public void saveAll(List<SubjectBean> list) {
		subjectRepository.saveAll(list);
	}
	
	/**
	 * 根据id删除学科
	 * @param id
	 * */
	@Transactional
	public void deleteById(int id) {
		subjectRepository.deleteById(id);
	}
	
	/**
	 * 删除多个学科
	 * List<QuestionTypeBean>
	 * */
	@Transactional
	public void deleteAllList(List<SubjectBean> list) {
		subjectRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据id修改学科
	 * @param id,subject
	 * */
	@Transactional
	public void updateSubjectById(int id,String subject) {
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
		Optional<SubjectBean> subjectOptional = subjectRepository.findById(id);
		if(subjectOptional.isPresent()) {
			return subjectOptional.get();
		}
		
		return null;
	}
	

	/**
	 * 查找所有
	 * */
	@Transactional
	public List<SubjectBean> findAll() {
		return subjectRepository.findAll();
	}
	
	/**
	 * 分页查找所有学科类型
	 * */
	@Transactional
	public Page<SubjectBean> findAll(Pageable pageable) {
		return subjectRepository.findAll(pageable);
	}

}
