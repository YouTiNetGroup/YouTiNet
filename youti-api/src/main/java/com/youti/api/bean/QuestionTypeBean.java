package com.youti.api.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question_type")
public class QuestionTypeBean {
	@Id
	@GeneratedValue
	private int question_type_id;
	private String question_type;
	
	public int getQuestion_type_id() {
		return question_type_id;
	}
	public void setQuestion_type_id(int question_type_id) {
		this.question_type_id = question_type_id;
	}
	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}
	
}
