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
		questionRepository.save(questionBean);
	}
	
	/**
	 * 新增/更新 多个试题
	 * @param List<QuestionBean>
	 * */
	@Transactional
	public void saveAll(List<QuestionBean> list) {
		questionRepository.saveAll(list);
	}
	
	/**
	 * 根据id删除单个试题
	 * @param id
	 * */
	@Transactional
	public void deleteById(int id) {
		questionRepository.deleteById(id);
	}
	
	/**
	 * 删除多个试题
	 * List<QuestionBean>
	 * */
	@Transactional
	public void deleteAllList(List<QuestionBean> list) {
		questionRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据学科id删除试题
	 * @param subject_id
	 * */
	@Transactional
	public void deleteBySubjectId(int subject_id) {
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
		Optional<QuestionBean> sessionquestion= questionRepository.findById(id);
		sessionquestion.get().setScore(score);
		questionRepository.save(sessionquestion.get());
	}
	
	/**
	 * 根据id修改试题难度
	 * @param id,difficulty_degree
	 * */
	@Transactional
	public void updateDifficultyDegreeById(int id,String difficulty_degree) {
		Optional<QuestionBean> sessionquestion= questionRepository.findById(id);
		sessionquestion.get().setDifficulty_degree(difficulty_degree);
		questionRepository.save(sessionquestion.get());
	}
	
	/**
	 * 根据id修改试题类型id
	 * @param id,type_id
	 * */
	@Transactional
	public void updateTypeById(int id,int type_id) {
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
		Optional<QuestionBean> questionOptional = questionRepository.findById(id);
		if(questionOptional.isPresent()) {
			return questionOptional.get();
		}
		return null;
	}
	

	/**
	 * 查找所有试题
	 * */
	@Transactional
	public List<QuestionBean> findAll() {
		return questionRepository.findAll();
	}
	
	/**
	 * 分页查找所有试题
	 * */
	@Transactional
	public Page<QuestionBean> findAll(Pageable pageable) {
		return questionRepository.findAll(pageable);
	}
	
	/**
	 * 根据试题类型id查找试题
	 * @param type_id
	 * */
	@Transactional
	public List<QuestionBean> findByTypeId(int type_id) {
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
	 * 根据试题学科id和知识点id查找试题
	 * @param subject_id
	 * */
	@Transactional
	public List<QuestionBean> findBySubjectIdAndKnowledgePointId(int subject_id,int knowledge_point_id) {
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSubject_id() == subject_id && 
					temp.getKnowledge_point_id() == knowledge_point_id) {
				list.add(temp);
			}
		}
		return list;
	}
	/**
	 * 根据试题学科id和题型id查找试题
	 * @param subject_id
	 * */
	@Transactional
	public List<QuestionBean> findBySTD(int subject_id,int type_id,String difficulty_degree) {
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSubject_id() == subject_id && 
					temp.getType_id() == type_id && temp.getDifficulty_degree() == difficulty_degree) {
				list.add(temp);
			}
		}
		return list;
	}
	
	public List<QuestionBean> findByST(int subject_id,int type_id) {
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSubject_id() == subject_id && 
					temp.getType_id() == type_id ) {
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
	 * @param difficulty_degree
	 * */
	@Transactional
	public List<QuestionBean> findByDifficultyDegree(String difficulty_degree) {
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getDifficulty_degree().equals(difficulty_degree)) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据组合条件查找试题,-1表示该条件不参与选择
	 * @param type_id,subject_id,knowledge_point_id,difficulty_degree
	 * */
	@Transactional
	public List<QuestionBean> find(int type_id,int subject_id,
			int knowledge_point_id,String difficulty_degree) {
		List<QuestionBean> list = new ArrayList<QuestionBean>();
		Iterator<QuestionBean> iterator = questionRepository.findAll().iterator();
		QuestionBean temp = null;
		
		
		boolean ignore[] = new boolean[4];
		ignore[0] = (type_id == -1);
		ignore[1] = (subject_id == -1);
		ignore[2] = (knowledge_point_id == -1);
		ignore[3] = (difficulty_degree.equals("-1"));
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			
			boolean right[] = new boolean[4];
			/**
			 * 忽略该条件  符合该条件  结果
			 * 1           1、0     = 1
			 * 0            0       = 0
			 * 0            1       = 1
			 * */
			right[0] = ignore[0] || ((!ignore[0]) && (temp.getType_id() == type_id));
			right[1] = ignore[1] || ((!ignore[1]) && (temp.getSubject_id() == subject_id));
			right[2] = ignore[2] || ((!ignore[2]) && (temp.getKnowledge_point_id() == knowledge_point_id));
			right[3] = ignore[3] || ((!ignore[3]) && (temp.getDifficulty_degree().equals(difficulty_degree)));
			
			if(right[0]&&right[1]&&right[2]&&right[3]){
				list.add(temp);
			}
		}
		return list;
	}
	
	
}
