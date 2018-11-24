package com.youti.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youti.api.service.KnowledgePointService;
import com.youti.api.service.SubjectService;

/**
 * 知识点管理
 * */
@RestController
@RequestMapping("/knowledge")
@CrossOrigin
public class KnowledgePointController {
	@Resource
	private KnowledgePointService knowledgePointService;
	@Resource
	private SubjectService subjectService;
	
	/**
	 * 获取知识点
	 * */
	
	/**
	 * 获取总知识点列表
	 * */
	
	/**
	 * 获取某学科知识点列表
	 * */
	
	/**
	 * 添加知识点
	 * */
	
	/**
	 * 编辑知识点
	 * */
	
	/**
	 * 删除知识点
	 * */
	

}
