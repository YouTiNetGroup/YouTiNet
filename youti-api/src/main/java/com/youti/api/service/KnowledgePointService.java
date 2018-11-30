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

import com.youti.api.bean.KnowledgePointBean;
import com.youti.api.repository.KnowledgePointRepository;

@Service
public class KnowledgePointService {
	@Resource
	private KnowledgePointRepository knowledgePointRepository;
	
	/**
	 * 新增/更新单条知识点
	 * @param KnowledgePointBean
	 * */
	@Transactional
	public void save(KnowledgePointBean knowledgePointBean) {
		knowledgePointRepository.save(knowledgePointBean);
	}
	
	/**
	 * 新增/更新多条知识点
	 * @param List<KnowledgePointBean>
	 * */
	@Transactional
	public void saveAll(List<KnowledgePointBean> list) {
		knowledgePointRepository.saveAll(list);
	}
	
	/**
	 * 根据id删除知识点
	 * @param id
	 * */
	@Transactional
	public void deleteById(int id) {
		knowledgePointRepository.deleteById(id);
	}
	
	/**
	 * 删除多个知识点
	 * @param List<KnowledgePointBean>
	 * */
	@Transactional
	public void deleteAllList(List<KnowledgePointBean> list) {
		knowledgePointRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据id修改知识点所属学科id
	 * @param id,subject_id
	 * */
	@Transactional
	public void updateSubjectById(int id, int subject_id) {
		Optional<KnowledgePointBean> sessionKnowledgePoint= knowledgePointRepository.findById(id);
		sessionKnowledgePoint.get().setSubject_id(subject_id);
		knowledgePointRepository.save(sessionKnowledgePoint.get());
	}
	
	/**
	 * 根据id修改知识点
	 * @param id,knowledgePoint
	 * */
	@Transactional
	public void updateKnowledgePointById(int id,String knowledgePoint) {
		Optional<KnowledgePointBean> sessionKnowledgePoint= knowledgePointRepository.findById(id);
		sessionKnowledgePoint.get().setKnowledge_point(knowledgePoint);
		knowledgePointRepository.save(sessionKnowledgePoint.get());
	}
	
	/**
	 * 根据id查找知识点
	 * @param id
	 * */
	@Transactional
	public KnowledgePointBean findById(int id) {
		Optional<KnowledgePointBean> knowledgePointOptional = knowledgePointRepository.findById(id);
		if(knowledgePointOptional.isPresent()) {
			return knowledgePointOptional.get();
		}
		return null;
	}
	
	/**
	 * 查找所有知识点
	 * */
	@Transactional
	public List<KnowledgePointBean> findAll(){
		return knowledgePointRepository.findAll();
	}
	

	/**
	 * 分页查找所有知识点
	 * */
	@Transactional
	public Page<KnowledgePointBean> findAll(Pageable pageable){
		return knowledgePointRepository.findAll(pageable);
	}
	
	/**
	 * 根据学科id查找知识点
	 * */
	@Transactional
	public List<KnowledgePointBean> findBySubjectid(int subjectid){
		List<KnowledgePointBean> list = new ArrayList<KnowledgePointBean>();
		Iterator<KnowledgePointBean> iterator = knowledgePointRepository.findAll().iterator();
		KnowledgePointBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSubject_id() == subjectid) {
				list.add(temp);
			}
		}
		return list;
	}

}
