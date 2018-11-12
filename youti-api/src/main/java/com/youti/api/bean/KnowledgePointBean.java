package com.youti.api.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "knowledge_point")
public class KnowledgePointBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int knowledge_point_id;
	private int subject_id;
	private String knowledge_point;
	public int getKnowledge_point_id() {
		return knowledge_point_id;
	}
	public void setKnowledge_point_id(int knowledge_point_id) {
		this.knowledge_point_id = knowledge_point_id;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getKnowledge_point() {
		return knowledge_point;
	}
	public void setKnowledge_point(String knowledge_point) {
		this.knowledge_point = knowledge_point;
	}
	
	
	
}
