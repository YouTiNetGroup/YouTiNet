package com.youti.api.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_paper")
public class TestPaperBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int test_paper_id;
	private String creator_id;
	private int subject_id;
	private String title;
	private int total_score;
	private String difficulty_degree;
	private int semester;
	private String school_year;
	
	public int getTest_paper_id() {
		return test_paper_id;
	}
	public void setTest_paper_id(int test_paper_id) {
		this.test_paper_id = test_paper_id;
	}
	public String getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public String getDifficulty_degree() {
		return difficulty_degree;
	}
	public void setDifficulty_degree(String difficulty_degree) {
		this.difficulty_degree = difficulty_degree;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getSchool_year() {
		return school_year;
	}
	public void setSchool_year(String school_year) {
		this.school_year = school_year;
	}
}
