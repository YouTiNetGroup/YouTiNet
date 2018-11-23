package com.youti.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youti.api.service.QuestionService;
import com.youti.api.service.TestPaperContainService;
import com.youti.api.service.TestPaperService;

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
	
	/**
	 * 查找试卷列表
	 * */
	
	/**
	 * 修改试卷信息
	 * */
	
	/**
	 * 删除试卷
	 * */
	
	/**
	 * 导出试卷
	 * */
	
	
	
	/**
	 * 手动生成试卷
	 * */
	
	/**
	 * 智能生成试卷
	 * */
	
}
