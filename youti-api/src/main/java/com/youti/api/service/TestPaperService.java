package com.youti.api.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youti.api.bean.TestPaperBean;
import com.youti.api.bean.TestPaperContainBean;
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
		testPaperRepository.save(testPaperBean);
	}
	
	/**
	 * 新增/更新 多个试卷
	 * @param List<TestPaperBean>
	 * */
	@Transactional
	public void saveAll(List<TestPaperBean> list) {
		//TODO
		testPaperRepository.saveAll(list);
	}
	
	/**
	 * 根据id删除试卷
	 * @param id
	 * */
	@Transactional
	public void deleteById(int id) {
		//TODO
		testPaperRepository.deleteById(id);
	}
	
	/**
	 * 删除多个试卷
	 * List<TestPaperBean>
	 * */
	@Transactional
	public void deleteAllList(List<TestPaperBean> list) {
		//TODO
		testPaperRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据学科id删除试卷
	 * @param subject_id
	 * */
	@Transactional
	public void deleteBySubjectId(int subject_id) {
		//TODO
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSubject_id() == subject_id) {
				list.add(temp);
			}
		}
		testPaperRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据创建者id删除试卷
	 * @param creator_id
	 * */
	@Transactional
	public void deleteByCreatorId(String creator_id) {
		//TODO
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getCreator_id() == creator_id) {
				list.add(temp);
			}
		}
		testPaperRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据id修改试卷学科
	 * @param id,subject_id
	 * */
	@Transactional
	public void updateSubjectById(int id,int subject_id) {
		//TODO
		Optional<TestPaperBean> sessionTestPaper= testPaperRepository.findById(id);
		sessionTestPaper.get().setSubject_id(subject_id);
		testPaperRepository.save(sessionTestPaper.get());
	}
	
	/**
	 * 根据id修改试卷标题
	 * @param id,title
	 * */
	@Transactional
	public void updateTitleById(int id,String title) {
		//TODO
		Optional<TestPaperBean> sessionTestPaper= testPaperRepository.findById(id);
		sessionTestPaper.get().setTitle(title);
		testPaperRepository.save(sessionTestPaper.get());
	}
	
	/**
	 * 根据id修改试卷总分值
	 * @param id,total_score
	 * */
	@Transactional
	public void updateTotalScoreById(int id,int total_score) {
		//TODO
		Optional<TestPaperBean> sessionTestPaper= testPaperRepository.findById(id);
		sessionTestPaper.get().setTotal_score(total_score);
		testPaperRepository.save(sessionTestPaper.get());
	}
	
	/**
	 * 根据id修改试卷难度
	 * @param id,difficulity_degree
	 * */
	@Transactional
	public void updateDifficulityDegreeById(int id,String difficulity_degree) {
		//TODO
		Optional<TestPaperBean> sessionTestPaper= testPaperRepository.findById(id);
		sessionTestPaper.get().setDifficulity_degree(difficulity_degree);
		testPaperRepository.save(sessionTestPaper.get());
	}
	
	/**
	 * 根据id修改试卷学期
	 * @param id,semester
	 * */
	@Transactional
	public void updateSemesterById(int id,int semester) {
		//TODO
		Optional<TestPaperBean> sessionTestPaper= testPaperRepository.findById(id);
		sessionTestPaper.get().setSemester(semester);
		testPaperRepository.save(sessionTestPaper.get());
	}
	
	/**
	 * 根据id修改试卷学年
	 * @param id,school_year
	 * */
	@Transactional
	public void updateSchoolYearById(int id,int school_year) {
		//TODO
		Optional<TestPaperBean> sessionTestPaper= testPaperRepository.findById(id);
		sessionTestPaper.get().setSchool_year(school_year);
		testPaperRepository.save(sessionTestPaper.get());
	}
	
	/**
	 * 根据id查找试卷
	 * @param id
	 * */
	@Transactional
	public TestPaperBean findById(int id) {
		//TODO
		return testPaperRepository.findById(id).get();
	}
	

	/**
	 * 查找所有试卷
	 * */
	@Transactional
	public List<TestPaperBean> findAll() {
		//TODO
		return testPaperRepository.findAll();
	}
	
	/**
	 * 根据创建者查找试卷
	 * @param creator_id
	 * */
	@Transactional
	public List<TestPaperBean> findByCreatorId(String creator_id) {
		//TODO
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getCreator_id() == creator_id) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据学科id查找试卷
	 * @param subject_id
	 * */
	@Transactional
	public List<TestPaperBean> findBySubjectId(int subject_id) {
		//TODO
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSubject_id() == subject_id) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据总分值查找试卷
	 * @param total_score
	 * */
	@Transactional
	public List<TestPaperBean> findByTotalScore(int total_score) {
		//TODO
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getTotal_score() == total_score) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据难度查找试卷
	 * @param difficulity_degree
	 * */
	@Transactional
	public List<TestPaperBean> findByDifficulityDegree(String difficulity_degree) {
		//TODO
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getDifficulity_degree() == difficulity_degree) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据学年学期查找试卷
	 * @param school_year，semester
	 * */
	@Transactional
	public List<TestPaperBean> findBySchoolYearAndSemester(int school_year, int semester) {
		//TODO
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSchool_year() == school_year && temp.getSemester() == semester) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据组合条件查找试题
	 * @param creator_id, subject_id,total_score,
	 * difficulity_degree,school_year,semester
	 * */
	@Transactional
	public List<TestPaperBean> find(String creator_id, int subject_id,
			int total_score,String difficulity_degree,int school_year,int semester) {
		//TODO
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getCreator_id() == creator_id && temp.getSubject_id() == subject_id && temp.getTotal_score() == total_score && temp.getDifficulity_degree() == difficulity_degree && temp.getSchool_year() == school_year && temp.getSemester() == semester) {
				list.add(temp);
			}
		}
		return list;
	}
	
}
