package com.youti.api.controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.youti.api.bean.AccountBean;
import com.youti.api.bean.SubjectBean;
import com.youti.api.service.SubjectService;
import com.youti.api.utils.RespEntity;

/**
 * 学科管理
 * */
@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {
	@Resource
	private SubjectService subjectService;
	
	/**
	 * 获取学科
	 * */
	@RequestMapping("/get")
	@ResponseBody
	public RespEntity getSubject(@RequestBody SubjectBean subjectBean) {
		RespEntity respEntity = new RespEntity();

		SubjectBean subject = subjectService.findById(subjectBean.getSubject_id());
		//List<SubjectBean> subject = subjectService.findAll();
		if(subject == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("学科不存在");
		}else {
			respEntity.setIsSuccess(true);
			respEntity.setMessage("成功");
			respEntity.setData(subject);
		}
		return respEntity;
	}
	/**
	 * 获取学科列表
	 * */
	@RequestMapping("/get")
	@ResponseBody
	public RespEntity getSubjectList() {
		List<SubjectBean> subjectList = subjectService.findAll();
		RespEntity respEntity = new RespEntity(true,subjectList,"成功");
		return respEntity;

	}
	/**
	 * 增添学科
	 * */
	@RequestMapping("/add")
	@ResponseBody
	public RespEntity addSubject(@RequestBody SubjectBean subjectBean) {
		RespEntity respEntity = new RespEntity();
		
		if(subjectService.findById(subjectBean.getSubject_id()) != null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("学科已经存在");
		}else {
			subjectService.save(subjectBean);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("学科创建成功");
		}
		return respEntity;
	}
	/**
	 * 删除学科
	 * */
	@RequestMapping("delete")
	@ResponseBody
	public RespEntity deleteSubject(@RequestBody SubjectBean subjectBean) {
		RespEntity respEntity = new RespEntity();
		
		if(subjectService.findById(subjectBean.getSubject_id()) == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("学科不存在");
		}else {
			subjectService.deleteById(subjectBean.getSubject_id());
			respEntity.setIsSuccess(true);
			respEntity.setMessage("学科删除成功");
		}
		return respEntity;
	}
	
}
