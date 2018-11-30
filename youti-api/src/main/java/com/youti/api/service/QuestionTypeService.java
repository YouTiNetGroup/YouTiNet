package com.youti.api.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youti.api.bean.QuestionTypeBean;
import com.youti.api.repository.QuestionTypeRepository;

@Service
public class QuestionTypeService {
	@Resource
	private QuestionTypeRepository questionTypeRepository;
	
	/**
	 * 新增/更新 单个试题类型
	 * @param QuestionTypeBean
	 * */
	@Transactional
	public void save(QuestionTypeBean questionTypeBean) {
		questionTypeRepository.save(questionTypeBean);
	}
	
	/**
	 * 新增/更新 多个试题类型
	 * @param List<QuestionTypeBean>
	 * */
	@Transactional
	public void saveAll(List<QuestionTypeBean> list) {
		questionTypeRepository.saveAll(list);
	}
	
	/**
	 * 根据id删除试题类型
	 * @param id
	 * */
	@Transactional
	public void deleteById(int id) {
		questionTypeRepository.deleteById(id);
	}
	
	/**
	 * 删除多个试题类型
	 * List<QuestionTypeBean>
	 * */
	@Transactional
	public void deleteAllList(List<QuestionTypeBean> list) {
		questionTypeRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据id修改试题类型
	 * @param id,question_type
	 * */
	@Transactional
	public void updateQuestionTypeById(int id,String question_type) {
		Optional<QuestionTypeBean> sessionquestionType= questionTypeRepository.findById(id);
		sessionquestionType.get().setQuestion_type(question_type);
		questionTypeRepository.save(sessionquestionType.get());
	}
	
	/**
	 * 根据id查找试题类型
	 * @param id
	 * */
	@Transactional
	public QuestionTypeBean findById(int id) {
		Optional<QuestionTypeBean> questionTypeOptional = questionTypeRepository.findById(id);
		if(questionTypeOptional.isPresent()) {
			return questionTypeOptional.get();
		}
		
		return null;
	}
	

	/**
	 * 查找所有试题类型
	 * */
	@Transactional
	public List<QuestionTypeBean> findAll() {
		return questionTypeRepository.findAll();
	}
	
	/**
	 * 分页查找所有试题类型
	 * */
	@Transactional
	public Page<QuestionTypeBean> findAll(Pageable pageable) {
		return questionTypeRepository.findAll(pageable);
	}

}
