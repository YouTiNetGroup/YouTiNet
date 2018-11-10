package com.youti.api.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionBean {
	@Id
	@GeneratedValue
	private int question_id;
	private int type_id;
	private String content;
	private String answer;
	private int score;
	private String difficulity_degree;
	private int subject_id;
	private int knowledge_point_id;
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getDifficulity_degree() {
		return difficulity_degree;
	}
	public void setDifficulity_degree(String difficulity_degree) {
		this.difficulity_degree = difficulity_degree;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getKnowledge_point_id() {
		return knowledge_point_id;
	}
	public void setKnowledge_point_id(int knowledge_point_id) {
		this.knowledge_point_id = knowledge_point_id;
	}
	
	
}
