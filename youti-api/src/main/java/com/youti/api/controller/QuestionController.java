package com.youti.api.controller;

import java.util.ArrayList;
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
import com.youti.api.service.KnowledgePointService;
import com.youti.api.service.QuestionService;
import com.youti.api.service.QuestionTypeService;
import com.youti.api.service.SubjectService;
import com.youti.api.utils.RespEntity;

/**
 * 试题管理
 * */
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
	
	
	/**
	 * 获取单个试题
	 * */
	@RequestMapping("/get")
	@ResponseBody
	public RespEntity getQuestion(@RequestBody QuestionBean questionBean) {
		RespEntity respEntity = new RespEntity();
		
		QuestionBean question = questionService.findById(questionBean.getQuestion_id());
		if(question == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("试题不存在");
		}else {
			int type_id = question.getType_id();
			int subject_id = question.getSubject_id();
			int knowledge_point_id = question.getKnowledge_point_id();
			
			QuestionTypeBean type = questionTypeService.findById(type_id);
			SubjectBean subject = subjectService.findById(subject_id);
			KnowledgePointBean knowledge = knowledgePointService.findById(knowledge_point_id);
			
			
			Map<String, Object> params = JSON.parseObject(JSON.toJSONString(question));
			
			if(type!=null) {
				params.put("question_type", type.getQuestion_type());
			}
			if(subject!=null) {
				params.put("subject", subject.getSubject());
			}
			if(knowledge!=null) {
				params.put("knowledge_point", knowledge.getKnowledge_point());
			}
			
			respEntity.setIsSuccess(true);
			respEntity.setMessage("成功");
			respEntity.setData(params);
		}

		return respEntity;
	}
	
	
	/**
	 * 获取全试题列表
	 * */
	@RequestMapping("/list")
	@ResponseBody
	public RespEntity getQuestionList() {
		RespEntity respEntity = new RespEntity();
		List <QuestionBean> list = questionService.findAll();
		Iterator<QuestionBean> it = list.iterator();
		while(it.hasNext()){
			QuestionBean x = it.next();
			QuestionBean question = questionService.findById(x.getQuestion_id());
			if(question == null) {
				respEntity.setIsSuccess(false);
				respEntity.setMessage("试题不存在");
			}else {
				int type_id = question.getType_id();
				int subject_id = question.getSubject_id();
				int knowledge_point_id = question.getKnowledge_point_id();
				
				QuestionTypeBean type = questionTypeService.findById(type_id);
				SubjectBean subject = subjectService.findById(subject_id);
				KnowledgePointBean knowledge = knowledgePointService.findById(knowledge_point_id);

				Map<String, Object> params = JSON.parseObject(JSON.toJSONString(question));
				
				if(type!=null) {
					params.put("question_type", type.getQuestion_type());
				}
				if(subject!=null) {
					params.put("subject", subject.getSubject());
				}
				if(knowledge!=null) {
					params.put("knowledge_point", knowledge.getKnowledge_point());
				}
				respEntity.setData(params);
			}
		}
		respEntity.setIsSuccess(true);
		respEntity.setMessage("成功");
		return respEntity;
	}
	
	/**
	 * 按条件获取试题列表
	 * */
	@RequestMapping("/listof")
	@ResponseBody
	public RespEntity getQuestionListBy(@RequestBody Map<String, Object> params) {
		RespEntity respEntity = new RespEntity();
		//选择条件
		int type_id= (int)params.get("type_id");
		int subject_id= (int)params.get("subject_id");
		int knowledge_point_id= (int)params.get("knowledge_point_id");
		String difficulty_degree= (String)params.get("difficulty_degree");
		
		List <QuestionBean> list = questionService.find(type_id,subject_id,knowledge_point_id,difficulty_degree);
		Iterator<QuestionBean> it = list.iterator();
		while(it.hasNext()){
			QuestionBean x = it.next();
			QuestionBean question = questionService.findById(x.getQuestion_id());
			if(question == null) {
				respEntity.setIsSuccess(false);
				respEntity.setMessage("试题不存在");
			}else {
				int type_id1 = question.getType_id();
				int subject_id1 = question.getSubject_id();
				int knowledge_point_id1 = question.getKnowledge_point_id();
				
				QuestionTypeBean type = questionTypeService.findById(type_id1);
				SubjectBean subject = subjectService.findById(subject_id1);
				KnowledgePointBean knowledge = knowledgePointService.findById(knowledge_point_id1);

				Map<String, Object> param = JSON.parseObject(JSON.toJSONString(question));
				
				if(type!=null) {
					param.put("question_type", type.getQuestion_type());
				}
				if(subject!=null) {
					param.put("subject", subject.getSubject());
				}
				if(knowledge!=null) {
					param.put("knowledge_point", knowledge.getKnowledge_point());
				}
				respEntity.setData(param);
			}
		}
		respEntity.setIsSuccess(true);
		respEntity.setMessage("成功");
		return respEntity;
	}
	
	
	
	//管理员
	/**
	 * 增添试题
	 * */
	@RequestMapping("/create")
	@ResponseBody
	public RespEntity createQuestion(@RequestBody QuestionBean questionBean) {
		RespEntity respEntity = new RespEntity();
		if(questionService.findById(questionBean.getQuestion_id()) != null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("题目已经存在");
		}else {
			questionService.save(questionBean);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("题目创建成功");
		}
		return respEntity;
	}
	
	
	/**
	 * 删除试题
	 * */
	@RequestMapping("/delete")
	@ResponseBody
	public RespEntity deleteQuestion(@RequestBody QuestionBean questionBean) {
       RespEntity respEntity = new RespEntity();
		
		if(questionService.findById(questionBean.getQuestion_id()) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("题目不存在");
		}else {
			questionService.deleteById(questionBean.getQuestion_id());
			respEntity.setIsSuccess(true);
			respEntity.setMessage("题目删除成功");
		}
		return respEntity;
	}
	
	/**
	 * 修改试题内容
	 * */
	@RequestMapping("/modify")
	@ResponseBody
	public RespEntity modifyQuestion(@RequestBody QuestionBean questionBean) {
        RespEntity respEntity = new RespEntity();
		
		if(questionService.findById(questionBean.getQuestion_id()) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("试题不存在");
		}else {
			questionService.save(questionBean);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("试题信息修改成功");
		}
		return respEntity;
	}
	
	
	/***/

}
