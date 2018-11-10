package com.youti.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youti.api.bean.KnowledgePointBean;
import com.youti.api.repository.KnowledgePointRepository;

@Service
public class KnowledgePointService {
	@Resource
	private KnowledgePointRepository knowledgePointRepository;
	
	/**
	 * 新增单条知识点
	 * @param KnowledgePointBean
	 * */
	@Transactional
	public void save(KnowledgePointBean knowledgePointBean) {
		knowledgePointRepository.save(knowledgePointBean);
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
	 * 根据id修改知识点所属学科
	 * @param id,subjectid
	 * */
	@Transactional
	public void updateSubjectById(int id, int subjectid) {
		Optional<KnowledgePointBean> sessionKnowledgePoint= knowledgePointRepository.findById(id);
		sessionKnowledgePoint.get().setSubject_id(subjectid);
		knowledgePointRepository.save(sessionKnowledgePoint.get());
	}
	
	/**
	 * 根据id查找知识点
	 * @param id
	 * */
	@Transactional
	public KnowledgePointBean findById(int id) {
		return knowledgePointRepository.findById(id).get();
	}
	
	/**
	 * 查找所有知识点
	 * */
	@Transactional
	public List<KnowledgePointBean> findAll(){
		return knowledgePointRepository.findAll();
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
