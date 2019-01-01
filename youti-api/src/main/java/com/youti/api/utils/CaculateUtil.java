package com.youti.api.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.youti.api.bean.TestPaperContainBean;

/**
 * 计算Utils
 * */
public class CaculateUtil {
	
	/**
	 * 试卷难度计算
	 * 题目难度*（题目分值/总分值）的累加；四舍五入
	 * 返回 String
	 * */
	public static String caculateDifficultyDegree(int[]difficulty_degree ,List<TestPaperContainBean> questions,int total_score) {
		float result = 0;
		Iterator<TestPaperContainBean> iterator = questions.iterator();
		
		int i=0;
		while(iterator.hasNext()) {
			TestPaperContainBean temp = iterator.next();
			result += (temp.getSet_score()/(float)total_score)*difficulty_degree[i];
			i++;
			
		}
		
		return String.valueOf(Math.round(result));
	}
	
	public static void main(String args[]) {
		List<TestPaperContainBean> questions = new ArrayList<TestPaperContainBean>();
		TestPaperContainBean t1 = new TestPaperContainBean();
		TestPaperContainBean t2 = new TestPaperContainBean();
		TestPaperContainBean t3 = new TestPaperContainBean();
		
		t1.setSet_score(10);
		t2.setSet_score(10);
		t3.setSet_score(20);
		
		questions.add(t1);
		questions.add(t2);
		questions.add(t3);
		
		int[] difficulty_degree = {1,2,3};
		int total_score = 40;
		
		System.out.println(CaculateUtil.caculateDifficultyDegree(difficulty_degree, questions, total_score));
		
		
	}
}
