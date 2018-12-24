package com.youti.api.controller;

import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
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
	
	/**
	 * 查找单份试卷内容
	 * */
	@RequestMapping("/gettestpaper")
	@ResponseBody
	public RespEntity getTestPaper(HttpServletRequest request) {
		RespEntity respEntity = new RespEntity();
		String account_id=request.getParameter("test_paper_id");
		List<TestPaperBean> testpaper=testPaperService.findByCreatorId(account_id);
		return respEntity;
	}
	/**
	 * 获取用户试卷列表
	 * */
	@RequestMapping("/gettestpaperall")
	@ResponseBody
	public RespEntity getTestPaperAll(HttpServletRequest request) {
		RespEntity respEntity = new RespEntity();
		String account_id=request.getParameter("account_id");
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

	@ResponseBody
	public RespEntity modifyTestPaper(@RequestBody Map<String,Object> map) throws Exception {
		RespEntity respEntity = new RespEntity();
		TestPaperBean testpaper = JsonXMLUtils.map2obj((Map<String, Object>)map.get("testpaper"),TestPaperBean.class);
		int id = testpaper.getTest_paper_id();
		List<TestPaperContainBean> testpapercontain = (List<TestPaperContainBean>) JsonXMLUtils.map2obj((Map<String, Object>)map.get("testpapercontain"),TestPaperContainBean.class);
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
			Iterator<TestPaperContainBean> it = testpapercontain.iterator();
			while(it.hasNext()){
				TestPaperContainBean x = it.next();
				testPaperContainService.updateQuestionById(x.getId(), x.getQuestion_id());
				testPaperContainService.updateSetQuestionNumberById(x.getId(), x.getQuestion_number(), x.getQuestion_number_2());
				testPaperContainService.updateSetScoreById(x.getId(), x.getSet_score());
				testPaperContainService.updateTestPaperById(x.getId(), x.getTest_paper_id());
			}
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
	public RespEntity manualTestPaper(@RequestBody Map<String,Object> map) {
		RespEntity respEntity = new RespEntity();
		return respEntity;
	}
	/**
	 * 智能生成试卷
	 * */
	@RequestMapping("/intelltestpaper")
	@ResponseBody
	public RespEntity intellTestPaper(@RequestBody Map<String,Object> map) {
		RespEntity respEntity = new RespEntity();
		return respEntity;
	}
}
