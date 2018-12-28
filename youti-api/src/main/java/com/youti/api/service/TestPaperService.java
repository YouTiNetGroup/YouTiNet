package com.youti.api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		testPaperRepository.save(testPaperBean);
	}
	
	/**
	 * 新增/更新 多个试卷
	 * @param List<TestPaperBean>
	 * */
	@Transactional
	public void saveAll(List<TestPaperBean> list) {
		testPaperRepository.saveAll(list);
	}
	
	/**
	 * 根据id删除试卷
	 * @param id
	 * */
	@Transactional
	public void deleteById(int id) {
		testPaperRepository.deleteById(id);
	}
	
	/**
	 * 删除多个试卷
	 * List<TestPaperBean>
	 * */
	@Transactional
	public void deleteAllList(List<TestPaperBean> list) {
		testPaperRepository.deleteInBatch(list);
	}
	
	/**
	 * 根据学科id删除试卷
	 * @param subject_id
	 * */
	@Transactional
	public void deleteBySubjectId(int subject_id) {
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
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getCreator_id().equals(creator_id)) {
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
		Optional<TestPaperBean> sessionTestPaper= testPaperRepository.findById(id);
		sessionTestPaper.get().setTotal_score(total_score);
		testPaperRepository.save(sessionTestPaper.get());
	}
	
	/**
	 * 根据id修改试卷难度
	 * @param id,difficulty_degree
	 * */
	@Transactional
	public void updateDifficultyDegreeById(int id,String difficulty_degree) {
		Optional<TestPaperBean> sessionTestPaper= testPaperRepository.findById(id);
		sessionTestPaper.get().setDifficulty_degree(difficulty_degree);
		testPaperRepository.save(sessionTestPaper.get());
	}
	
	/**
	 * 根据id修改试卷学期
	 * @param id,semester
	 * */
	@Transactional
	public void updateSemesterById(int id,int semester) {
		Optional<TestPaperBean> sessionTestPaper= testPaperRepository.findById(id);
		sessionTestPaper.get().setSemester(semester);
		testPaperRepository.save(sessionTestPaper.get());
	}
	
	/**
	 * 根据id修改试卷学年
	 * @param id,school_year
	 * */
	@Transactional
	public void updateSchoolYearById(int id,String school_year) {
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
		Optional<TestPaperBean> testPaperOptional = testPaperRepository.findById(id);
		if(testPaperOptional.isPresent()) {
			return testPaperOptional.get();
		}
		
		return null;
	}
	

	/**
	 * 查找所有试卷
	 * */
	@Transactional
	public List<TestPaperBean> findAll() {
		return testPaperRepository.findAll();
	}
	
	/**
	 * 分页查找所有试卷
	 * */
	@Transactional
	public Page<TestPaperBean> findAll(Pageable pageable) {
		return testPaperRepository.findAll(pageable);
	}
	
	/**
	 * 根据创建者查找试卷
	 * @param creator_id
	 * */
	@Transactional
	public List<TestPaperBean> findByCreatorId(String creator_id) {
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getCreator_id().equals(creator_id)) {
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
	 * 根据学科id和试卷id查找试卷查找试卷
	 * @param subject_id creator_id
	 * */
	@Transactional
	public List<TestPaperBean> findBySubjectIdAndCreatId(int subject_id,String creator_id) {
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSubject_id() == subject_id && temp.getCreator_id() == creator_id) {
				list.add(temp);
			}
		}
		Collections.sort(list, new Comparator<TestPaperBean>() {  
			  
            @Override  
            public int compare(TestPaperBean o1, TestPaperBean o2) {  
                // 按照试卷的id进行升序排列  
                if (o1.getTest_paper_id() < o2.getTest_paper_id()){  
                    return 1;  
                }  
                if (o1.getTest_paper_id() == o2.getTest_paper_id()) {  
                    return 0;  
                }  
                return -1;  
            }  
        });  
		return list;
	}
	/**
	 * 根据总分值查找试卷
	 * @param total_score
	 * */
	@Transactional
	public List<TestPaperBean> findByTotalScore(int total_score) {
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
	 * @param difficulty_degree
	 * */
	@Transactional
	public List<TestPaperBean> findByDifficultyDegree(String difficulty_degree) {
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getDifficulty_degree().equals(difficulty_degree)) {
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
	public List<TestPaperBean> findBySchoolYearAndSemester(String school_year, int semester) {
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			if(temp.getSchool_year().equals(school_year) && temp.getSemester() == semester) {
				list.add(temp);
			}
		}
		return list;
	}
	
	/**
	 * 根据组合条件查找试卷,-1表示该条件不参与选择
	 * @param creator_id, subject_id,
	 * difficulty_degree,school_year,semester
	 * */
	@Transactional
	public List<TestPaperBean> find(String creator_id, int subject_id,
			String difficulty_degree,String school_year,int semester) {
		List<TestPaperBean> list = new ArrayList<TestPaperBean>();
		Iterator<TestPaperBean> iterator = testPaperRepository.findAll().iterator();
		TestPaperBean temp = null;
		
		boolean ignore[] = new boolean[5];
		ignore[0] = (creator_id.equals("-1"));
		ignore[1] = (subject_id == -1);
		ignore[2] = (difficulty_degree.equals("-1"));
		ignore[3] = (school_year.equals("-1"));
		ignore[4] = (semester == -1);
		
		
		while(iterator.hasNext()) {
			temp = iterator.next();
			
			boolean right[] = new boolean[5];
			/**
			 * 忽略该条件  符合该条件  结果
			 * 1           1、0     = 1
			 * 0            0       = 0
			 * 0            1       = 1
			 * */
			right[0] = ignore[0] || ((!ignore[0]) && (temp.getCreator_id().equals(creator_id)));
			right[1] = ignore[1] || ((!ignore[1]) && (temp.getSubject_id() == subject_id));
			right[2] = ignore[2] || ((!ignore[2]) && (temp.getDifficulty_degree().equals(difficulty_degree)));
			right[3] = ignore[3] || ((!ignore[3]) && (temp.getSchool_year().equals(school_year)));
			right[4] = ignore[4] || ((!ignore[4]) && (temp.getSemester() == semester));
			
			
			if(right[0]&&right[1]&&right[2]&&right[3]&&right[4]) {
				list.add(temp);
			}
		}
		return list;
	}
	
}
