package com.youti.api.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.youti.api.bean.AccountBean;
import com.youti.api.service.AccountService;

@RestController
@RequestMapping("/account/login")
@CrossOrigin
public class LoginController {
	@Resource
    private AccountService loginService;
	
	/**
	 * 1.form表单
	 * @RequestParam("name") String name
	 * 会把传递过来的Form表单中的name对应到formData方法的name参数上
	 * 该注解不能接收json传参
	 * */
   /*@RequestMapping(value = "/test1", method = RequestMethod.POST)
    public String formData(@RequestParam("name") String name , @RequestParam("age") int age){
        String result = "receive name = "+name+" age = "+age;
        System.out.println(result);
        return result;
    }*/

	/**
	 * @GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
	 * @PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。
	 * */

	
	/*
	 * 动态接收URL中的数据
	 * */
	@RequestMapping(value = "/account/login{account_id}")
	public String deleteById(@PathVariable String account_id) {
		loginService.findById(account_id);
		if
	}
	private Logger logger = LoggerFactory.getLogger(UploadController.class);
    
//  @RequestMapping(value = "/singleFile", method = RequestMethod.POST)
//  @ResponseBody
//  public String singleFileUpload(@RequestBody Map<String, String> data) throws Exception {
//  	System.out.println(JSON.toJSONString(file, true));
//		return "update ok";
//  }

  @PostMapping("/singleFile")
  public Object singleFileUpload(MultipartFile file) {
  	System.out.println(JSON.toJSONString(file, true));
      logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
      if (Objects.isNull(file) || file.isEmpty()) {
          logger.error("文件为空");
          return "文件为空，请重新上传";
      }

      try {
          byte[] bytes = file.getBytes();
          Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
          //如果没有files文件夹，则创建
          if (!Files.isWritable(path)) {
              Files.createDirectories(Paths.get(UPLOAD_FOLDER));
          }
          //文件写入指定路径
          Files.write(path, bytes);
          logger.debug("文件写入成功...");
          return "文件上传成功";
      } catch (IOException e) {
          e.printStackTrace();
          return "后端异常...";
      }
  }
	
}
