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
 */
@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {
	@Resource
	private SubjectService subjectService;

}
