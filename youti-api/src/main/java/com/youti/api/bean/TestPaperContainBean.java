package com.youti.api.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_paper_contain")
public class TestPaperContainBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int question_id;
	private int test_paper_id;
	private int set_score;
	private int question_number;
	private int question_number_2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getTest_paper_id() {
		return test_paper_id;
	}
	public void setTest_paper_id(int test_paper_id) {
		this.test_paper_id = test_paper_id;
	}
	public int getSet_score() {
		return set_score;
	}
	public void setSet_score(int set_score) {
		this.set_score = set_score;
	}
	public int getQuestion_number() {
		return question_number;
	}
	public void setQuestion_number(int question_number) {
		this.question_number = question_number;
	}
	public int getQuestion_number_2() {
		return question_number_2;
	}
	public void setQuestion_number_2(int question_number_2) {
		this.question_number_2 = question_number_2;
	}
	
}
