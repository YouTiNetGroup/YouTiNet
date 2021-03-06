package com.youti.api.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.youti.api.service.AccountService;
import com.youti.api.service.QuestionService;
import com.youti.api.service.QuestionTypeService;
import com.youti.api.service.SubjectService;
import com.youti.api.service.TestPaperContainService;
import com.youti.api.service.TestPaperService;
import com.youti.api.utils.CaculateUtil;
import com.youti.api.utils.FileTypeConvertUtil;
import com.youti.api.utils.FileUtil;
import com.youti.api.utils.FreemarkerUtil;
import com.youti.api.utils.QuestionNumber;
import com.youti.api.utils.RespEntity;
import com.youti.api.utils.ZipUtil;
import com.youti.api.utils.CreateRandomListUtil;
import com.youti.api.utils.QuestionsInfoEntity;

/**
 * 试卷管理
 */
@RestController
@RequestMapping("/testPaper")
@CrossOrigin
public class TestPaperController {
	@Resource
	private TestPaperService testPaperService;
	@Resource
	private TestPaperContainService testPaperContainService;
	@Resource
	private QuestionService questionService;
	@Resource
	private AccountService accountService;
	@Resource
	private SubjectService subjectService;
	@Resource
	private QuestionTypeService questionTypeService;

	/**
	 * 获取用户的所有试卷
	 */
	@RequestMapping("/getTestPapersByAccountId")
	@ResponseBody
	public RespEntity getTestPapersByAccountId(@RequestParam(value = "account_id", required = true) String account_id) {
		RespEntity respEntity = new RespEntity();
		AccountBean accountBean = accountService.findById(account_id);
		if (accountBean == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("用户不存在");
		} else {
			List<TestPaperBean> testpaperList = testPaperService.findByCreatorId(account_id);
			respEntity.setData(testpaperList);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("成功");
		}
		return respEntity;
	}

	/**
	 * 获取所有试卷
	 */
	@RequestMapping("/getAllTestPapers")
	@ResponseBody
	public RespEntity getAllTestPapers() {
		RespEntity respEntity = new RespEntity();

		List<TestPaperBean> testPaperList = testPaperService.findAll();
		respEntity.setData(testPaperList);
		respEntity.setIsSuccess(true);
		respEntity.setMessage("成功");

		return respEntity;
	}

	/**
	 * 修改试卷信息
	 */
	@RequestMapping("/modifyTestPaperInformation")
	@ResponseBody
	public RespEntity modifyTestPaperInformation(@RequestBody Map<String, Object> map) {
		RespEntity respEntity = new RespEntity();
		JSONObject testPaper = (JSONObject) map.get("testPaper");

		int test_paper_id = (int) testPaper.get("test_paper_id");
		String creator_id = (String) testPaper.get("creator_id");
		int subject_id = (int) testPaper.get("subject_id");
		String title = (String) testPaper.get("title");
		int total_score = (int) testPaper.get("total_score");
		String difficulty_degree = (String) testPaper.get("difficulty_degree");
		int semester = (int) testPaper.get("semester");
		String school_year = (String) testPaper.get("school_year");

		List<TestPaperContainBean> questions = JSON.parseArray(JSON.toJSONString(testPaper.get("questions")),
				TestPaperContainBean.class);
		TestPaperBean testPaperBean = testPaperService.findById(test_paper_id);

		if (testPaperBean == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("试卷不存在");
		} else {

			testPaperBean.setCreator_id(creator_id);
			testPaperBean.setSubject_id(subject_id);
			testPaperBean.setTitle(title);

			testPaperBean.setSemester(semester);
			testPaperBean.setSchool_year(school_year);
			testPaperBean.setTotal_score(total_score);
			testPaperBean.setDifficulty_degree(difficulty_degree);
			
			if (questions == null || questions.size() == 0) {
				respEntity.setIsSuccess(true);
				respEntity.setMessage("试卷修改成功");
			} else {
				List<TestPaperContainBean> old_questions = testPaperContainService.findByTestPaperId(test_paper_id);

				// 找出questions中没有的oldquestions项，删去那些。
				// 这里直接删关old再添加新的
				testPaperContainService.deleteAllList(old_questions);
				testPaperContainService.saveAll(questions);
			}

			testPaperService.save(testPaperBean);

			respEntity.setIsSuccess(true);
			respEntity.setMessage("试卷修改成功");
		}

		return respEntity;
	}

	/**
	 * 删除试卷
	 */
	@RequestMapping("/deleteTestPaperById")
	@ResponseBody
	public RespEntity deleteTestPaperById(@RequestBody Map<String, String> params) {
		RespEntity respEntity = new RespEntity();

		int test_paper_id = Integer.parseInt(params.get("test_paper_id"));
		TestPaperBean testpaperBean = testPaperService.findById(test_paper_id);

		if (testpaperBean == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("试卷不存在");
		} else {
			testPaperService.deleteById(test_paper_id);
			respEntity.setIsSuccess(true);
			respEntity.setMessage("试卷删除成功");
		}
		return respEntity;
	}

	/**
	 * 导出试卷
	 * *************************
	 * @throws IOException
	 */
	@RequestMapping("/exportTestPaperById")
	@ResponseBody
	public RespEntity exportTestPaperById(@RequestBody Map<String, String> params,HttpServletResponse response )
			throws IOException {
		RespEntity respEntity = new RespEntity();

		int test_paper_id = Integer.parseInt(params.get("test_paper_id"));
		TestPaperBean testpaperBean = testPaperService.findById(test_paper_id);
		if (testpaperBean == null) {
			respEntity.setIsSuccess(false);
			respEntity.setMessage("试卷不存在");
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
			int count1 = 0;// 大题数
			while (it.hasNext()) {
				TestPaperContainBean x = it.next();
				if (x.getQuestion_number() != count1) {
					count1++;
				}
				QuestionBean questionBean = questionService.findById(x.getQuestion_id());
				questionBean.setScore(x.getSet_score());// 用试卷的set_score

				questionList.add(questionBean);
			}

			SubjectBean subjectBean = subjectService.findById(testpaperBean.getSubject_id());

			// 试卷基本信息导出
			Map<String, Object> htmlContent = new HashMap<String, Object>();
			htmlContent.put("title", testpaperBean.getTitle());
			htmlContent.put("school_year", "学年：" + testpaperBean.getSchool_year());
			htmlContent.put("semester", "学期：第" + testpaperBean.getSemester() + "学期");
			htmlContent.put("subject", "科目：" + subjectBean.getSubject());
			htmlContent.put("total_score", "满分：" + testpaperBean.getTotal_score() + "分");

			// 答案基本信息导出
			Map<String, Object> htmlAnswer = new HashMap<String, Object>();
			htmlAnswer.put("title", testpaperBean.getTitle() + "答案");
			htmlAnswer.put("school_year", "学年：" + testpaperBean.getSchool_year());
			htmlAnswer.put("semester", "学期：第" + testpaperBean.getSemester() + "学期");
			htmlAnswer.put("subject", "科目：" + subjectBean.getSubject());
			htmlAnswer.put("total_score", "满分：" + testpaperBean.getTotal_score() + "分");

			// 获取大题对应的小题数
			it = testpapercontain.iterator();
			int[] count2 = new int[count1];// 大题对应的小题数
			count2[0] = 0;
			int i = 1;
			while (it.hasNext()) {
				TestPaperContainBean x = it.next();
				if (x.getQuestion_number() != i) {
					i++;
					count2[i - 1] = 0;
				}
				count2[i - 1]++;
			}

			// 试卷题目信息导入，答案信息导入
			int index = 0;
			int j = 0;
			for (i = 0; i < count2.length; i++) {
				String temp = "question_type_" + (i + 1);
				htmlContent.put(temp, QuestionNumber.NUMBER[i]/*(i + 1)*/ + "、"
						+ questionTypeService.findById(questionList.get(index).getType_id()).getQuestion_type());
				htmlAnswer.put(temp, QuestionNumber.NUMBER[i]/*(i + 1)*/ + "、"
						+ questionTypeService.findById(questionList.get(index).getType_id()).getQuestion_type());

				for (j = 0; j < count2[i]; j++) {
					String temp2 = "question_number2_" + (i + 1) + "_" + (j + 1);
					String temp3 = "question_content_" + (i + 1) + "_" + (j + 1);
					String temp4 = "question_score_" + (i + 1) + "_" + (j + 1);

					htmlContent.put(temp2, (j + 1) + ".");
					String testcontent = questionList.get(index).getContent().replace("<br>", "<br/>");
					testcontent = testcontent.replace("\\", "");
					htmlContent.put(temp3, testcontent);
					htmlContent.put(temp4, "(" + questionList.get(index).getScore() + "分)");

					String temp5 = "answer_" + (i + 1) + "_" + (j + 1);
					htmlAnswer.put(temp2, (j + 1) + ".");
					String answer = questionList.get(index).getAnswer().replace("<br>", "<br/>");
					answer = answer.replace("\\", "");
					htmlAnswer.put(temp5, answer);
					htmlAnswer.put(temp4, "(" + questionList.get(index).getScore() + "分)");
					index++;
				}

			}

			String testpaper_name = "testPaper_" + test_paper_id;
			String answer_name = "answer" + test_paper_id;

			String htmlname = testpaper_name + ".html";
			String htmlname2 = answer_name + ".html";

			String htmlFile = "files/" + htmlname;
			String htmlFile2 = "files/" + htmlname2;

			String pdfFile = "files/" + testpaper_name + ".pdf";
			String pdfFile2 = "files/" + answer_name + ".pdf";

			// 转html
			try {
				FreemarkerUtil.createHtmlByMode("testPaper.ftl", htmlname, htmlContent);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			try {
				FreemarkerUtil.createHtmlByMode("answer.ftl", htmlname2, htmlAnswer);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			// 转pdf

			try {
				FileTypeConvertUtil.html2pdf(htmlFile, pdfFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				FileTypeConvertUtil.html2pdf(htmlFile2, pdfFile2);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 压缩文件
			String zipfile = "D:\\" + testpaper_name + ".zip";

			List<File> fileList = new ArrayList<>();
			fileList.add(new File(pdfFile));
			fileList.add(new File(pdfFile2));
			FileOutputStream fos2 = new FileOutputStream(new File(zipfile));
			ZipUtil.toZip(fileList, fos2);

			// 下载
			File download_file = new File(zipfile);

			// 如果文件名存在，则进行下载
			if (download_file.exists()) {
				
				/*HttpHeaders headers = new HttpHeaders();    
		        String downloadFileName =new String((testpaper_name+".zip").getBytes("UTF-8"),"iso-8859-1");//解决文件名乱码
		        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);//application/octet-stream二进制流数据（最常见的文件下载）。
		        headers.setContentDispositionFormData("attachment", downloadFileName);//通知浏览器以attachment（下载方式）打开
		       
		        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(download_file),    
		                                              headers, HttpStatus.CREATED);  */ 
				
				
				
		  
		        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型   
		        /*response.setContentType("multipart/form-data");   
		        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)   
		        response.setHeader("Content-Disposition", "attachment;fileName="+"a.zip");   
		        ServletOutputStream out;   
		  
		        try {   
		            FileInputStream inputStream = new FileInputStream(download_file);   
		  
		            //3.通过response获取ServletOutputStream对象(out)   
		            out = response.getOutputStream();   
		  
		            int b = 0;   
		            byte[] buffer = new byte[1024];   
		            while (b != -1){   
		                b = inputStream.read(buffer);   
		                //4.写到输出流(out)中   
		                out.write(buffer,0,b);   
		            }   
		            inputStream.close();   
		            out.close();   
		            out.flush();   
		  
		        } catch (IOException e) {   
		            e.printStackTrace();   
		        }*/   

				
				
				/*BufferedInputStream bis = null;
				BufferedOutputStream bos = null;
			
				try {
					long fileLength = download_file.length();
					response.setContentType("application/x-msdownload;");
					response.setHeader("Content-disposition", "attachment; filename=" 
					+ new String((testpaper_name+".zip").getBytes("utf-8"), "ISO8859-1"));
					response.setHeader("Content-Length", String.valueOf(fileLength));
					bis = new BufferedInputStream(new FileInputStream(download_file));
					bos = new BufferedOutputStream(response.getOutputStream());
					byte[] buff = new byte[2048];
					int bytesRead;
					while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
						bos.write(buff, 0, bytesRead);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (bis != null)
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					if (bos != null)
						try {
							bos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				}	*/
			    

		          
				
				
				// 配置文件下载
		/*		response.setContentType("application/octet-stream");
				// 下载文件能正常显示中文
				response.setHeader("Content-Disposition",
						"attachment;filename=" + URLEncoder.encode(testpaper_name, "UTF-8"));

				// 实现文件下载
				byte[] buffer = new byte[2 * 1024];
				FileInputStream fis = null;
				BufferedInputStream bis = null;
				try {
					fis = new FileInputStream(download_file);
					bis = new BufferedInputStream(fis);
					OutputStream os = response.getOutputStream();
					int ii = bis.read(buffer);
					while (ii != -1) {
						os.write(buffer, 0, ii);
						ii = bis.read(buffer);
					}
					System.out.println("Download successfully!");
				} catch (Exception e) {
					System.out.println("Download failed!");
				} finally {
					if (bis != null) {
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
					*/
				respEntity.setIsSuccess(true);
				respEntity.setMessage("试卷导出成功");
					
			}else {
				respEntity.setIsSuccess(false);
				respEntity.setMessage("试卷导出失败");
			}

			// 删除文件
			FileUtil.deleteFile(htmlFile);
			FileUtil.deleteFile(htmlFile2);
			FileUtil.deleteFile(pdfFile);
			FileUtil.deleteFile(pdfFile2);
//			FileUtil.deleteFile(zipfile);

		}
//		return null;
		
		return respEntity;
	}

	/**
	 * 手动生成试卷
	 */
	@RequestMapping("/manualGenerateTestPaper")
	@ResponseBody
	public RespEntity manualGenerateTestPaper(@RequestBody Map<String, Object> map) {

		RespEntity respEntity = new RespEntity();
		TestPaperBean testPaperBean = new TestPaperBean();
		JSONObject testPaper = (JSONObject) map.get("testPaper");

		String creator_id = (String) testPaper.get("creator_id");
		int subject_id = (int) testPaper.get("subject_id");
		String title = (String) testPaper.get("title");
		// int total_score = (int) testPaper.get("total_score");
		String difficulty_degree = (String) testPaper.get("difficulty_degree");
		int semester = (int) testPaper.get("semester");
		String school_year = (String) testPaper.get("school_year");

		List<TestPaperContainBean> questions = JSON.parseArray(JSON.toJSONString(testPaper.get("questions")),
				TestPaperContainBean.class);

		testPaperBean.setCreator_id(creator_id);
		testPaperBean.setSchool_year(school_year);
		testPaperBean.setSemester(semester);
		testPaperBean.setSubject_id(subject_id);
		testPaperBean.setTitle(title);
		testPaperBean.setDifficulty_degree(difficulty_degree);

		testPaperService.save(testPaperBean);

		int test_paper_id = testPaperBean.getTest_paper_id();
		int total_score = 0;

		for (int i = 0; i < questions.size(); i++) {
			total_score += questions.get(i).getSet_score();
			questions.get(i).setTest_paper_id(test_paper_id);
		}

		testPaperBean.setTotal_score(total_score);

		testPaperService.save(testPaperBean);
		testPaperContainService.saveAll(questions);

		respEntity.setIsSuccess(true);
		respEntity.setMessage("试卷生成成功");
		return respEntity;

	}

	/**
	 * 智能生成试卷
	 */
	@RequestMapping("/autoGenerateTestPaper")
	@ResponseBody
	public RespEntity autoGenerateTestPaper(@RequestBody Map<String, Object> map) {
		RespEntity respEntity = new RespEntity();
		JSONObject testPaper = (JSONObject) map.get("testPaper");

		String creator_id = (String) testPaper.get("creator_id");
		String difficulty_degree = (String) testPaper.get("difficulty_degree");
		String school_year = (String) testPaper.get("school_year");
		int semester = (int) testPaper.get("semester");
		int subject_id = (int) testPaper.get("subject_id");
		String title = (String) testPaper.get("title");
		int total_score = (int) testPaper.get("total_score");

		List<QuestionsInfoEntity> questionsinfo = JSON.parseArray(JSON.toJSONString(testPaper.get("questionsInfo")),
				QuestionsInfoEntity.class);

		// 判断是否设置题目数超出已存题目数
		for (int i = 0; i < questionsinfo.size(); i++) {
			List<QuestionBean> questiontemp = questionService.findByST(subject_id, questionsinfo.get(i).getType());
			if (questiontemp.size() < questionsinfo.get(i).getCount()) {
				respEntity.setIsSuccess(false);
				respEntity.setMessage("题目数不满足");
				break;
			}
		}

		// 保存试卷信息
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

		
		//重复统计
		List<TestPaperBean> testPaperList = testPaperService.findBySubjectIdAndCreatId(subject_id, creator_id);
		List<QuestionBean> questionList = questionService.findBySubjectId(subject_id);
		List<QuestionBean> questionList2 = new ArrayList<QuestionBean>();
		Map<Integer,Integer> question2 = new HashMap<Integer,Integer>();
		
		for(QuestionBean questiontemp:questionList) {
			question2.put(questiontemp.getQuestion_id(), 0);
		}
		
		//System.out.println(question2.size());
		
		for(TestPaperBean testpapertemp: testPaperList) {
			List<TestPaperContainBean> testpapercontainList = testPaperContainService
					.findByTestPaperId(testpapertemp.getTest_paper_id());
			for(TestPaperContainBean testpapercontaintemp : testpapercontainList) {
				int times = question2.get(testpapercontaintemp.getQuestion_id());
				question2.put(testpapercontaintemp.getQuestion_id(), times+1);
			}
		}
		
	    Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer,Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue()-o2.getValue();
			}
	    };

	    List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(question2.entrySet());
	    Collections.sort(list,valueComparator);
	    for (Map.Entry<Integer, Integer> entry : list) {
	    	questionList2.add(questionService.findById(entry.getKey()));
	    }
	    
	    
	    //生成题目
	    Iterator<QuestionsInfoEntity> it = questionsinfo.iterator();
  		int question_number = 0;
  		int difficulty = Integer.parseInt(difficulty_degree);
  		
  		while (it.hasNext()) {
  			question_number = question_number + 1;
  			QuestionsInfoEntity x = it.next();
  			int type_id = x.getType();
  			int count = x.getCount();
  			int score = x.getScore();

  			int sum = count * difficulty;
  			List<Integer> typeList = new ArrayList<Integer>();
  			typeList.add(type_id);

  			List<QuestionBean> result = null;
  			result = questionList.stream().filter((QuestionBean q) -> typeList.contains(q.getType_id()))
  					.collect(Collectors.toList());
  			
  			
  			List<QuestionBean> question1 = null;
  			int limitcount = 0;
  			while (limitcount<=result.size()) {
  				question1 = CreateRandomListUtil.createRandomList2(result, count);
  				int sum1 = 0;
  				for (QuestionBean questions : question1) {
  					sum1 += Integer.parseInt(questions.getDifficulty_degree());
  				}
  				limitcount++;
  				if (sum1 + 1 >= sum) {
  					break;
  				}
  			}
  			

  			int question_number_2 = 0;
  			for (QuestionBean questions : question1) {
  				question_number_2 = question_number_2 + 1;
  				TestPaperContainBean testpapercontain = new TestPaperContainBean();
  				testpapercontain.setQuestion_id(questions.getQuestion_id());
  				testpapercontain.setTest_paper_id(test_paper_id);
  				testpapercontain.setSet_score(score);
  				testpapercontain.setQuestion_number(question_number);
  				testpapercontain.setQuestion_number_2(question_number_2);
  				testPaperContainService.save(testpapercontain);
  			}
  		}		
	    
		
		//重复区分
	/*	List<TestPaperBean> testPaperList = testPaperService.findBySubjectIdAndCreatId(subject_id, creator_id);
		List<QuestionBean> questionList = questionService.findBySubjectId(subject_id);
		List<QuestionBean> questionList2 = new ArrayList<QuestionBean>();
		
		for(TestPaperBean testpapertemp: testPaperList) {
			List<TestPaperContainBean> testpapercontainList = testPaperContainService
					.findByTestPaperId(testpapertemp.getTest_paper_id());
			for(TestPaperContainBean testpapercontaintemp : testpapercontainList) {
				QuestionBean questiontemp = questionService.findById(testpapercontaintemp.getQuestion_id());
				if(!questionList2.contains(questiontemp)) {
					questionList2.add(questiontemp);
				}
			}
		}
		questionList.removeAll(questionList2);
		
		//生成题目
		Iterator<QuestionsInfoEntity> it = questionsinfo.iterator();
		int question_number = 0;
		int difficulty = Integer.parseInt(difficulty_degree);
		
		while (it.hasNext()) {
			question_number = question_number + 1;
			QuestionsInfoEntity x = it.next();
			int type_id = x.getType();
			int count = x.getCount();
			int score = x.getScore();

			int sum = count * difficulty;
			List<Integer> typeList = new ArrayList<Integer>();
			typeList.add(type_id);

			List<QuestionBean> result = null;
			List<QuestionBean> backups = null;
			result = questionList.stream().filter((QuestionBean q) -> typeList.contains(q.getType_id()))
					.collect(Collectors.toList());
			if(result.size()<count) {
				backups = questionList2.stream().filter((QuestionBean q) -> typeList.contains(q.getType_id()))
						.collect(Collectors.toList());
				result.addAll(CreateRandomListUtil.createRandomList(backups, count-result.size()));
			}
			
			
			List<QuestionBean> question1 = null;
			int limitcount = 0;
			while (limitcount<=result.size()) {
				question1 = CreateRandomListUtil.createRandomList(result, count);
				int sum1 = 0;
				for (QuestionBean questions : question1) {
					sum1 += Integer.parseInt(questions.getDifficulty_degree());
				}
				limitcount++;
				if (sum1 + 2 >= sum) {
					break;
				}
			}
			

			int question_number_2 = 0;
			for (QuestionBean questions : question1) {
				question_number_2 = question_number_2 + 1;
				TestPaperContainBean testpapercontain = new TestPaperContainBean();
				testpapercontain.setQuestion_id(questions.getQuestion_id());
				testpapercontain.setTest_paper_id(test_paper_id);
				testpapercontain.setSet_score(score);
				testpapercontain.setQuestion_number(question_number);
				testpapercontain.setQuestion_number_2(question_number_2);
				testPaperContainService.save(testpapercontain);
			}
		}*/
		
		respEntity.setIsSuccess(true);
		respEntity.setMessage("试卷生成成功");
		
		return respEntity;
	}
}
