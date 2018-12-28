package com.youti.api.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.youti.api.bean.KnowledgePointBean;
import com.youti.api.bean.QuestionBean;
import com.youti.api.bean.QuestionTypeBean;
import com.youti.api.bean.SubjectBean;
import com.youti.api.bean.TestPaperBean;
import com.youti.api.bean.TestPaperContainBean;
import com.youti.api.service.KnowledgePointService;
import com.youti.api.service.QuestionService;
import com.youti.api.service.QuestionTypeService;
import com.youti.api.service.SubjectService;
import com.youti.api.service.TestPaperContainService;
import com.youti.api.service.TestPaperService;
import com.youti.api.utils.RespEntity;

/**
 * 试题管理
 */
@RestController
@RequestMapping("/question")
@CrossOrigin
public class QuestionController {
	@Resource
	private QuestionService questionService;
	@Resource
	private QuestionTypeService questionTypeService;
	@Resource
	private SubjectService subjectService;
	@Resource
	private KnowledgePointService knowledgePointService;
	@Resource
	private TestPaperService testPaperService;
	@Resource
	private TestPaperContainService testPaperContainService;

	/**
	 * 获取单个试题内容//
	 */
	/*@RequestMapping("/get")
	@ResponseBody
	public RespEntity getQuestion(@RequestBody QuestionBean questionBean) {
		RespEntity respEntity = new RespEntity();

		QuestionBean question = questionService.findById(questionBean.getQuestion_id());
		if (question == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("试题不存在");
		} else {
			int type_id = question.getType_id();
			int subject_id = question.getSubject_id();
			int knowledge_point_id = question.getKnowledge_point_id();

			QuestionTypeBean type = questionTypeService.findById(type_id);
			SubjectBean subject = subjectService.findById(subject_id);
			KnowledgePointBean knowledge = knowledgePointService.findById(knowledge_point_id);

			Map<String, Object> params = JSON.parseObject(JSON.toJSONString(question));

			if (type != null) {
				params.put("question_type", type.getQuestion_type());
			}
			if (subject != null) {
				params.put("subject", subject.getSubject());
			}
			if (knowledge != null) {
				params.put("knowledge_point", knowledge.getKnowledge_point());
			}

			respEntity.setIsSuccess(true);
			respEntity.setMessage("成功");
			respEntity.setData(params);
		}

		return respEntity;
	}*/

	/**
	 * 获取所有题目
	 */
	@RequestMapping("/getAllQuestions")
	@ResponseBody
	public RespEntity getAllQuestions() {
		RespEntity respEntity = new RespEntity();
		List<QuestionBean> questionBeanlist = questionService.findAll();
		/*
		 * //对应id转成具体内容 Iterator<QuestionBean> iterator = questionBeanlist.iterator();
		 * List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		 * 
		 * while(iterator.hasNext()){ QuestionBean question = iterator.next();
		 * 
		 * int type_id = question.getType_id(); int subject_id =
		 * question.getSubject_id(); int knowledge_point_id =
		 * question.getKnowledge_point_id();
		 * 
		 * QuestionTypeBean type = questionTypeService.findById(type_id); SubjectBean
		 * subject = subjectService.findById(subject_id); KnowledgePointBean knowledge =
		 * knowledgePointService.findById(knowledge_point_id);
		 * 
		 * Map<String, Object> params = JSON.parseObject(JSON.toJSONString(question));
		 * 
		 * if(type!=null) { params.put("question_type", type.getQuestion_type()); }
		 * if(subject!=null) { params.put("subject", subject.getSubject()); }
		 * if(knowledge!=null) { params.put("knowledge_point",
		 * knowledge.getKnowledge_point()); } list.add(params);
		 * 
		 * } respEntity.setData(list);
		 */
		respEntity.setData(questionBeanlist);
		respEntity.setIsSuccess(true);
		respEntity.setMessage("成功");
		return respEntity;
	}

	/**
	 * 按条件获取试题列表//
	 */
	/*@RequestMapping("/listof")
	@ResponseBody
	public RespEntity getQuestionListBy(@RequestBody Map<String, Object> params) {
		RespEntity respEntity = new RespEntity();
		// 选择条件
		int type_id = (int) params.get("type_id");
		int subject_id = (int) params.get("subject_id");
		int knowledge_point_id = (int) params.get("knowledge_point_id");
		String difficulty_degree = (String) params.get("difficulty_degree");

		List<QuestionBean> list = questionService.find(type_id, subject_id, knowledge_point_id, difficulty_degree);
		Iterator<QuestionBean> it = list.iterator();
		while (it.hasNext()) {
			QuestionBean x = it.next();
			QuestionBean question = questionService.findById(x.getQuestion_id());
			if (question == null) {
				respEntity.setIsSuccess(false);
				respEntity.setMessage("试题不存在");
			} else {
				int type_id1 = question.getType_id();
				int subject_id1 = question.getSubject_id();
				int knowledge_point_id1 = question.getKnowledge_point_id();

				QuestionTypeBean type = questionTypeService.findById(type_id1);
				SubjectBean subject = subjectService.findById(subject_id1);
				KnowledgePointBean knowledge = knowledgePointService.findById(knowledge_point_id1);

				Map<String, Object> param = JSON.parseObject(JSON.toJSONString(question));

				if (type != null) {
					param.put("question_type", type.getQuestion_type());
				}
				if (subject != null) {
					param.put("subject", subject.getSubject());
				}
				if (knowledge != null) {
					param.put("knowledge_point", knowledge.getKnowledge_point());
				}
				respEntity.setData(param);
			}
		}
		respEntity.setIsSuccess(true);
		respEntity.setMessage("成功");
		return respEntity;
	}*/

	/**
	 * 添加题目
	 */
	@RequestMapping("/addQuestion")
	@ResponseBody
	public RespEntity addQuestion(@RequestBody QuestionBean questionBean) {
		RespEntity respEntity = new RespEntity();
		questionService.save(questionBean);
		respEntity.setIsSuccess(true);
		respEntity.setMessage("题目创建成功");
		return respEntity;
	}

	/**
	 * 删除题目
	 */
	@RequestMapping("/deleteQuestionById")
	@ResponseBody
	public RespEntity deleteQuestionById(@RequestBody Map<String, String> params) {
		RespEntity respEntity = new RespEntity();
		int question_id = Integer.parseInt(params.get("question_id"));

		if (questionService.findById(question_id) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("题目不存在");
		} else {
			questionService.deleteById(question_id);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("题目删除成功");
		}
		return respEntity;
	}

	/**
	 * 修改题目信息
	 */
	@RequestMapping("/modifyQuestionInformation")
	@ResponseBody
	public RespEntity modifyQuestionInformation(@RequestBody QuestionBean questionBean) {
		RespEntity respEntity = new RespEntity();

		if (questionService.findById(questionBean.getQuestion_id()) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("试题不存在");
		} else {
			questionService.save(questionBean);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("试题信息修改成功");
		}
		return respEntity;
	}

	/**
	 * 获取一份试卷的所有题目
	 */
	@RequestMapping("/getQuestionByTestPaperId")
	@ResponseBody
	public RespEntity getQuestionByTestPaperId(@RequestBody Map<String, String> params) {
		RespEntity respEntity = new RespEntity();

		int test_paper_id = Integer.parseInt(params.get("test_paper_id"));

		TestPaperBean testPaperBean = testPaperService.findById(test_paper_id);
		if (testPaperBean == null) {
			respEntity.setMessage("试卷不存在");
			respEntity.setIsSuccess(false);
		} else {
			List<TestPaperContainBean> testpapercontain = testPaperContainService.findByTestPaperId(test_paper_id);
			List<QuestionBean> questionList = new ArrayList<QuestionBean>();

			Collections.sort(testpapercontain, new Comparator<TestPaperContainBean>() { // 根据大题号小题号排序
				@Override
				public int compare(TestPaperContainBean o1, TestPaperContainBean o2) {
					int i = o1.getQuestion_number() - o2.getQuestion_number();
					if (i == 0) {
						return o1.getQuestion_number_2() - o2.getQuestion_number_2();
					}
					return i;
				}
			});

			Iterator<TestPaperContainBean> it = testpapercontain.iterator();
			while (it.hasNext()) {
				TestPaperContainBean x = it.next();
				QuestionBean questionBean = questionService.findById(x.getQuestion_id());
				questionBean.setScore(x.getSet_score());

				questionList.add(questionBean);
			}
			respEntity.setData(questionList);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("成功");

		}

		return respEntity;
	}

}
