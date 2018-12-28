package com.youti.api.controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youti.api.bean.AccountBean;
import com.youti.api.bean.KnowledgePointBean;
import com.youti.api.bean.QuestionBean;
import com.youti.api.bean.QuestionTypeBean;
import com.youti.api.bean.SubjectBean;
import com.youti.api.bean.TestPaperBean;
import com.youti.api.bean.TestPaperContainBean;
import com.youti.api.service.QuestionService;
import com.youti.api.service.TestPaperContainService;
import com.youti.api.service.TestPaperService;
import com.youti.api.utils.JsonXMLUtils;
import com.youti.api.utils.RespEntity;
import com.youti.api.utils.createRandomList;
import com.youti.api.utils.questionsInfo;

/**
 * 试卷管理
 * */
@RestController
@RequestMapping("/testpaper")
@CrossOrigin
public class TestPaperController {
	@Resource
	private TestPaperService testPaperService;
	@Resource
	private TestPaperContainService testPaperContainService;
	@Resource
	private QuestionService questionService;
	@Resource
	private createRandomList createrandomList;
	/**
	 * 查找单份试卷内容
	 * */
	@RequestMapping("/gettestpaper")
	@ResponseBody
	public RespEntity getTestPaper(HttpServletRequest request) {
		RespEntity respEntity = new RespEntity();
		String test_paper_id=request.getParameter("test_paper_id");
		int id=Integer.parseInt(test_paper_id);
		TestPaperBean testpaper=testPaperService.findById(id);
		Map<String, Object> param = JSON.parseObject(JSON.toJSONString(testpaper));
		respEntity.setData(param);
		List<TestPaperContainBean> testpapercontain =testPaperContainService.findByTestPaperId(id);
		Iterator<TestPaperContainBean> it = testpapercontain.iterator();
		
		Collections.sort(testpapercontain, new Comparator<TestPaperContainBean>() {  //根据大题号小题号排序

            @Override  
            public int compare(TestPaperContainBean o1, TestPaperContainBean o2) {  
                int i = o1.getQuestion_number() - o2.getQuestion_number();  
                if(i == 0){  
                    return o1.getQuestion_number_2() - o2.getQuestion_number_2();  
                }  
                return i;  
            }  
        });  
		while(it.hasNext()){
			TestPaperContainBean x = it.next();
			Map<String, Object> params = JSON.parseObject(JSON.toJSONString(x));
			respEntity.setData(params);
		}
		respEntity.setIsSuccess(true);
		respEntity.setMessage("成功");
		return respEntity;
	}
	/**
	 * 获取用户试卷列表
	 * */
	@RequestMapping("/gettestpaperall")
	@ResponseBody
	public RespEntity getTestPaperAll(HttpServletRequest request) {
		RespEntity respEntity = new RespEntity();
		String account_id=request.getParameter("account_id") ;
		List<TestPaperBean> testpaper=testPaperService.findByCreatorId(account_id);
		Iterator<TestPaperBean> it = testpaper.iterator();
		while(it.hasNext()){
			TestPaperBean x = it.next();
			Map<String, Object> params = JSON.parseObject(JSON.toJSONString(x));
			respEntity.setData(params);
		}
		respEntity.setIsSuccess(true);
		respEntity.setMessage("成功");
		return respEntity;
	}
	/**
	 * 修改试卷信息
	 * @throws Exception 
	 * */
	@RequestMapping("/modifytestpaper")
	@ResponseBody
	public RespEntity modifyTestPaper(@RequestBody Map<String,Object> map) throws Exception {
		RespEntity respEntity = new RespEntity();
		TestPaperBean testpaper = JsonXMLUtils.map2obj((Map<String, Object>)map.get("testpaper"),TestPaperBean.class);
		int id = testpaper.getTest_paper_id();
		List<TestPaperContainBean> testpapercontain = (List<TestPaperContainBean>) JsonXMLUtils.map2obj((Map<String, Object>)map.get("testpapercontain"),TestPaperContainBean.class);
		List<TestPaperContainBean> testpapercontain1 = testPaperContainService.findByTestPaperId(id);
		testPaperContainService.deleteAllList(testpapercontain1);
		if(testPaperService.findById(testpaper.getTest_paper_id()) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("试卷不存在");
		}else {
			testPaperService.updateDifficultyDegreeById(id, testpaper.getDifficulty_degree());
			testPaperService.updateSchoolYearById(id, testpaper.getSchool_year());
			testPaperService.updateSemesterById(id, testpaper.getSemester());
			testPaperService.updateSubjectById(id, testpaper.getSubject_id());
			testPaperService.updateTitleById(id, testpaper.getTitle());
			testPaperService.updateTotalScoreById(id, testpaper.getTotal_score());
			testPaperContainService.saveAll(testpapercontain);;
			
		}
		respEntity.setIsSuccess(true);
		respEntity.setMessage("试卷修改成功");
		return respEntity;
	}
	
	/**
	 * 删除试卷
	 * */
	@RequestMapping("/deletetestpaper")
	@ResponseBody
	public RespEntity deleteTestPaper(HttpServletRequest request) {
		RespEntity respEntity = new RespEntity();
		String test_paper_id = request.getParameter("test_paper_id");
		int id=Integer.parseInt(test_paper_id);
		TestPaperBean testpaper = testPaperService.findById(id);
		if(testPaperService.findById(testpaper.getTest_paper_id()) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("试卷不存在");
		}else {
			testPaperService.deleteById(testpaper.getTest_paper_id());
			respEntity.setIsSuccess(true);
			respEntity.setMessage("试卷删除成功");
		}
		return respEntity;
	}
	/**
	 * 导出试卷
	 * */
	
	
	
	/**
	 * 手动生成试卷
	 * */
	@RequestMapping("/manualtestpaper")
	@ResponseBody
	public RespEntity manualTestPaper(@RequestBody Map<String,Object> map) throws Exception {
		RespEntity respEntity = new RespEntity();
		TestPaperBean testpaper = JsonXMLUtils.map2obj((Map<String, Object>)map.get("testpaper"),TestPaperBean.class);
		int id = testpaper.getTest_paper_id();
		List<TestPaperContainBean> testpapercontain = JSON.parseArray(JSON.toJSONString(map.get("questions")),TestPaperContainBean.class);
		if(testPaperService.findById(testpaper.getTest_paper_id()) == null) {
			testPaperService.save(testpaper);
			testPaperContainService.saveAll(testpapercontain);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("试卷生成成功");
		}else {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("试卷已经存在");
		}
		return respEntity;
	}
	/**
	 * 智能生成试卷
	 * */
	@RequestMapping("/intelltestpaper")
	@ResponseBody
	public RespEntity intellTestPaper(@RequestBody Map<String,Object> map) {
		RespEntity respEntity = new RespEntity();
	    String creator_id = (String) map.get("creator_id");
	    String difficulty_degree = (String) map.get("difficulty_degree");
	    String school_year = (String) map.get("school_year");
	    int semester = (int) map.get("semester");
	    int subject_id = (int) map.get("subject_id");
	    String title = (String) map.get("title");
	    int total_score = (int) map.get("total_score");
	    TestPaperBean testpaper = new TestPaperBean();
	    testpaper.setCreator_id(creator_id);
	    testpaper.setDifficulty_degree(difficulty_degree);
	    testpaper.setSchool_year(school_year);
	    testpaper.setSemester(semester);
	    testpaper.setSubject_id(subject_id);
	    testpaper.setTitle(title);
	    testpaper.setTotal_score(total_score);
	    testPaperService.save(testpaper);
	    int test_paper_id = testpaper.getTest_paper_id();
	    List<TestPaperBean> list = testPaperService.findBySubjectIdAndCreatId(subject_id, creator_id);
	    List<QuestionBean> question = questionService.findBySubjectId(subject_id);
	    List<QuestionBean> question2 = new ArrayList();
	    int j = 0;
	    for(TestPaperBean testpapers1 : list) {
	    	j=j+1;
	    	if(j==2) {
	    		break;
	    	}
	    	List<TestPaperContainBean> testpapercontain = testPaperContainService.findByTestPaperId(testpapers1.getTest_paper_id());
	    	for(TestPaperContainBean testpapercontain1 : testpapercontain) {
	    		question2.add(questionService.findById(testpapercontain1.getQuestion_id()));
	    	}
	    }
	    question.removeAll(question2);
	    /*生成题目*/
	    List<questionsInfo> questionsinfo = JSON.parseArray(JSON.toJSONString(map.get("questionsInfo")),questionsInfo.class);
	    Iterator<questionsInfo> it = questionsinfo.iterator();
	    int question_number = 0;
	    while(it.hasNext()){
	    	question_number = question_number + 1;
	    	questionsInfo x = it.next();
			int type_id = x.gettype();
			int count = x.getcount();
			int score = x.getscore();
			int difficulty =Integer.parseInt(difficulty_degree);
			int sum = count*difficulty;
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(type_id);
			List<QuestionBean> result = null;
			result = question.stream()                                            
					.filter((QuestionBean q) -> typeList.contains(q.getType_id()))
					.collect(Collectors.toList());
			
			boolean m = true;
			List<QuestionBean> question1 = createrandomList.createRandomList(result,count);
			while(m) {
				int sum1=0;
			    for(QuestionBean questions : question1) {
			    	sum1=sum+Integer.parseInt(questions.getDifficulty_degree());
			    }
				if(sum1==sum || sum1-1==sum || sum1+1==sum) {
					m = false;
				}
			}
			int question_number_2 = 0;
			for(QuestionBean questions : question1) {
				question_number_2 = question_number_2+1;
				TestPaperContainBean testpapercontain = new TestPaperContainBean();
				testpapercontain.setQuestion_id(questions.getQuestion_id());
				testpapercontain.setTest_paper_id(test_paper_id);
				testpapercontain.setSet_score(score);
				testpapercontain.setQuestion_number(question_number);
				testpapercontain.setQuestion_number_2(question_number_2);
		    }
		}
	    respEntity.setIsSuccess(true);
		respEntity.setMessage("试卷生成成功");
		return respEntity;
	}
	
}
