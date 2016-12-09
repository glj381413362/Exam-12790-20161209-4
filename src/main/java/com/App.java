package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		StringBuffer sBuffer = new StringBuffer(); 
		sBuffer.append("随机生成50 个小于100 的数,分别为:");
		for (int i = 0; i < 50; i++) {
			Random r = new Random();
			int j = r.nextInt(100)+1;
			list.add(j);
			sBuffer.append(j);
			sBuffer.append(",");
		}
		System.out.println(sBuffer);
		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<Integer, TreeSet<Integer>>();
		for (int i : list) {
			int j = i / 10;
			if (map.keySet().contains(j)) {
				TreeSet<Integer> set = map.get(j);
				set.add(i);
				map.put(j, set);
			} else {
				TreeSet<Integer> set = new TreeSet<Integer>();
				set.add(i);
				map.put(j, set);
			}
		}
		System.out.println(map);
		Set<Map.Entry<Integer, TreeSet<Integer>>> e = map.entrySet();
		System.out.println(e);
	}
}
