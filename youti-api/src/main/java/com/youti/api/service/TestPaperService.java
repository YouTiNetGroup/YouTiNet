package com.youti.api.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youti.api.bean.TestPaperBean;
import com.youti.api.repository.TestPaperRepository;

@Service
public class TestPaperService {
	@Resource
	private TestPaperRepository testPaperRepository;
	
	/**
	 * 新增/更新 单个试卷
	 * @param TestPaperBean
	 * */
	@Transactional
	public void save(TestPaperBean testPaperBean) {
		//TODO
	}
	
	/**
	 * 新增/更新 多个试卷
	 * @param List<TestPaperBean>
	 * */
	@Transactional
	public void saveAll(List<TestPaperBean> list) {
		//TODO
	}
	
	/**
	 * 根据id删除试卷
	 * @param id
	 * */
	@Transactional
	public void deleteById(int id) {
		//TODO
	}
	
	/**
	 * 删除多个试卷
	 * List<TestPaperBean>
	 * */
	@Transactional
	public void deleteAllList(List<TestPaperBean> list) {
		//TODO
	}
	
	/**
	 * 根据学科id删除试卷
	 * @param subject_id
	 * */
	@Transactional
	public void deleteBySubjectId(int subject_id) {
		//TODO
	}
	
	/**
	 * 根据创建者id删除试卷
	 * @param creator_id
	 * */
	@Transactional
	public void deleteByCreatorId(int creator_id) {
		//TODO
	}
	
	/**
	 * 根据id修改试卷学科
	 * @param id,subject_id
	 * */
	@Transactional
	public void updateSubjectById(int id,int subject_id) {
		//TODO
	}
	
	/**
	 * 根据id修改试卷标题
	 * @param id,title
	 * */
	@Transactional
	public void updateTitleById(int id,String title) {
		//TODO
	}
	
	/**
	 * 根据id修改试卷总分值
	 * @param id,total_score
	 * */
	@Transactional
	public void updateTotalScoreById(int id,int total_score) {
		//TODO
	}
	
	/**
	 * 根据id修改试卷难度
	 * @param id,difficulity_degree
	 * */
	@Transactional
	public void updateDifficulityDegreeById(int id,String difficulity_degree) {
		//TODO
	}
	
	/**
	 * 根据id修改试卷学期
	 * @param id,semester
	 * */
	@Transactional
	public void updateSemesterById(int id,int semester) {
		//TODO
	}
	
	/**
	 * 根据id修改试卷学年
	 * @param id,school_year
	 * */
	@Transactional
	public void updateSchoolYearById(int id,int school_year) {
		//TODO
	}
	
	/**
	 * 根据id查找试卷
	 * @param id
	 * */
	@Transactional
	public TestPaperBean findById(int id) {
		//TODO
		return null;
	}
	

	/**
	 * 查找所有试卷
	 * */
	@Transactional
	public List<TestPaperBean> findAll() {
		//TODO
		return null;
	}
	
	/**
	 * 根据创建者查找试卷
	 * @param creator_id
	 * */
	@Transactional
	public List<TestPaperBean> findByCreatorId(int creator_id) {
		//TODO
		return null;
	}
	
	/**
	 * 根据学科id查找试卷
	 * @param subject_id
	 * */
	@Transactional
	public List<TestPaperBean> findBySubjectId(int subject_id) {
		//TODO
		return null;
	}
	
	/**
	 * 根据总分值查找试卷
	 * @param total_score
	 * */
	@Transactional
	public List<TestPaperBean> findByTotalScore(int total_score) {
		//TODO
		return null;
	}
	
	/**
	 * 根据难度查找试卷
	 * @param difficulity_degree
	 * */
	@Transactional
	public List<TestPaperBean> findByDifficulityDegree(String difficulity_degree) {
		//TODO
		return null;
	}
	
	/**
	 * 根据学年学期查找试卷
	 * @param school_year，semester
	 * */
	@Transactional
	public List<TestPaperBean> findBySchoolYearAndSemester(int school_year, int semester) {
		//TODO
		return null;
	}
	
	/**
	 * 根据组合条件查找试题
	 * @param creator_id, subject_id,total_score,
	 * difficulity_degree,school_year,semester
	 * */
	@Transactional
	public List<TestPaperBean> find(int creator_id, int subject_id,
			int total_score,String difficulity_degree,int school_year,int semester) {
		//TODO
		return null;
	}
	
}
