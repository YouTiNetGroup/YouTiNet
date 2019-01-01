package com.youti.api.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateRandomListUtil {
	/**
	 * 从list<T>中随机抽取元素
	 * 
	 * @param <T>
	 * @param list
	 * @param n
	 */
	public static <T> List<T> createRandomList(List<T> list, int n) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<T> listNew = new ArrayList<T>();
		if (list.size() <= n) {
			return list;
		} else {
			while (map.size() < n) {
				int random = (int) (Math.random() * list.size());
				if (!map.containsKey(random)) {
					map.put(random, "");
					listNew.add(list.get(random));
				}
			}
			return listNew;
		}
	}
	
	
	/**
	 * 从list<T>中随机抽取元素并按原顺序
	 * 
	 * @param <T>
	 * @param list
	 * @param n
	 */
	public static <T> List<T> createRandomList2(List<T> list, int n) {
		List<T> temp = new ArrayList<T>(list);
		while(temp.size()>n) {
			int random = (int) (Math.random() * temp.size());
			temp.remove(random);
		}
		return temp;
	}
	
}