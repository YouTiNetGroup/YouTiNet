package com.youti.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youti.api.bean.KnowledgePointBean;
import com.youti.api.bean.QuestionBean;
import com.youti.api.repository.QuestionRepository;

@Service
public class QuestionService {
	@Resource
	private QuestionRepository questionRepository;
	
	/**
	 * 新增/更新 单个试题
	 * @param QuestionBean
	 * */
	@Transactional
	public void save(QuestionBean questionBean) {
		//TODO
		questionRepository.save(questionBean);
	}
	
	/**
	 * 新增/更新 多个试题
	 * @param List<QuestionBean>
	 * */
	@Transactional
	public void saveAll(List<QuestionBean> list) {
		//TODO
		questionRepository.saveAll(list);
	}
	
	/**
	 * 根据id删除单个试题
	 * @param id
	 * */
	@Transactional
	public void deleteById(int id) {
		//TODO
		questionRepository.deleteById(id);
	}
	
	/**
	 * 删除多个试题
	 * List<QuestionBean>
	 * */
	@Transactional
	public void deleteAllList(List<QuestionBean> list) {
		//TODO
		questionRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据学科id删除试题
	 * @param subject_id
	 * */
	@Transactional
	public void deleteBySubjectId(int subject_id) {
		//TODO
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSubject_id() == subject_id) {
				list.add(temp);
			}
		}
		questionRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据知识点id删除试题
	 * @param knowledge_point_id
	 * */
	@Transactional
	public void deleteByKnowledgePointId(int knowledge_point_id) {
		//TODO
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getKnowledge_point_id() == knowledge_point_id) {
				list.add(temp);
			}
		}
		questionRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据试题类型id删除试题
	 * @param type_id
	 * */
	@Transactional
	public void deleteByTypeId(int type_id) {
		//TODO
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getType_id() == type_id) {
				list.add(temp);
			}
		}
		questionRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据id修改试题内容
	 * @param id,content
	 * */
	@Transactional
	public void updateContentById(int id,String content) {
		//TODO
		Optional<QuestionBean> sessionquestion= questionRepository.findById(id);
		sessionquestion.get().setContent(content);
		questionRepository.save(sessionquestion.get());
	}
	
	/**
	 * 根据id修改试题答案
	 * @param id,answer
	 * */
	@Transactional
	public void updateAnswerById(int id,String answer) {
		//TODO
		Optional<QuestionBean> sessionquestion= questionRepository.findById(id);
		sessionquestion.get().setAnswer(answer);
		questionRepository.save(sessionquestion.get());
	}
	
	/**
	 * 根据id修改试题默认分值
	 * @param id,score
	 * */
	@Transactional
	public void updateScoreById(int id,int score) {
		//TODO
		Optional<QuestionBean> sessionquestion= questionRepository.findById(id);
		sessionquestion.get().setScore(score);
		questionRepository.save(sessionquestion.get());
	}
	
	/**
	 * 根据id修改试题难度
	 * @param id,difficulity_degree
	 * */
	@Transactional
	public void updateDifficulityDegreeById(int id,String difficulity_degree) {
		//TODO
		Optional<QuestionBean> sessionquestion= questionRepository.findById(id);
		sessionquestion.get().setDifficulity_degree(difficulity_degree);
		questionRepository.save(sessionquestion.get());
	}
	
	/**
	 * 根据id修改试题类型id
	 * @param id,type_id
	 * */
	@Transactional
	public void updateTypeById(int id,int type_id) {
		//TODO
		Optional<QuestionBean> sessionquestion= questionRepository.findById(id);
		sessionquestion.get().setType_id(type_id);
		questionRepository.save(sessionquestion.get());
	}
	
	/**
	 * 根据id修改试题知识点id
	 * @param id,knowledge_point_id
	 * */
	@Transactional
	public void updateKnowledgePointById(int id,int knowledge_point_id) {
		//TODO
		Optional<QuestionBean> sessionquestion= questionRepository.findById(id);
		sessionquestion.get().setKnowledge_point_id(knowledge_point_id);
		questionRepository.save(sessionquestion.get());
	}
	
	/**
	 * 根据id修改试题所属学科id
	 * @param id,subject_id
	 * */
	@Transactional
	public void updateSubjectById(int id,int subject_id) {
		//TODO
		Optional<QuestionBean> sessionquestion= questionRepository.findById(id);
		sessionquestion.get().setSubject_id(subject_id);
		questionRepository.save(sessionquestion.get());
	}
	
	/**
	 * 根据id查找试题
	 * @param id
	 * */
	@Transactional
	public QuestionBean findById(int id) {
		//TODO
		return questionRepository.findById(id).get();
	}
	

	/**
	 * 查找所有试题
	 * */
	@Transactional
	public List<QuestionBean> findAll() {
		//TODO
		return questionRepository.findAll();
	}
	

	/**
	 * 根据试题类型id查找试题
	 * @param type_id
	 * */
	@Transactional
	public List<QuestionBean> findByTypeId(int type_id) {
		//TODO
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getType_id() == type_id) {
				list.add(temp);
			}
		}
		return list;
	}

	
	/**
	 * 根据试题学科id查找试题
	 * @param subject_id
	 * */
	@Transactional
	public List<QuestionBean> findBySubjectId(int subject_id) {
		//TODO
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSubject_id() == subject_id) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据试题知识点id查找试题
	 * @param knowledge_point_id
	 * */
	@Transactional
	public List<QuestionBean> findByKnowledgePointId(int knowledge_point_id) {
		//TODO
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getKnowledge_point_id() == knowledge_point_id) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据试题分值查找试题
	 * @param score
	 * */
	@Transactional
	public List<QuestionBean> findByScore(int score) {
		//TODO
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getScore() == score) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据试题难度查找试题
	 * @param difficulity_degree
	 * */
	@Transactional
	public List<QuestionBean> findByDifficulityDegree(String difficulity_degree) {
		//TODO
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getDifficulity_degree() == difficulity_degree) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据组合条件查找试题
	 * @param type_id,subject_id,knowledge_point_id,score,difficulity_degree
	 * */
	@Transactional
	public List<QuestionBean> find(int type_id,int subject_id,
			int knowledge_point_id,int score,String difficulity_degree) {
		//TODO
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getType_id() == type_id && temp.getSubject_id() == subject_id && temp.getKnowledge_point_id() == knowledge_point_id && temp.getScore() == score && temp.getDifficulity_degree() == difficulity_degree) {
				list.add(temp);
			}
		}
		return list;
	}
	
}
