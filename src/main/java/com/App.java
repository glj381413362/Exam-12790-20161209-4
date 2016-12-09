package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class App {
	  
	    /**     
	     * @discription 
	     * @author 龚梁钧       
	     * @created Dec 9, 2016 10:22:28 PM     
	     * @param args     
	     */
	public static void main(String[] args) {
		List<Integer> list = getRandList();
		Set<Map.Entry<Integer, HashSet<Integer>>> noSortMapResulst = noSortMap(list);
		Set<Map.Entry<Integer, TreeSet<Integer>>> sortMapResulst = sortMap(list);
		System.out.println("Map 中的数据为:"+noSortMapResulst);
		System.out.println("排序后的Map为: "+sortMapResulst);
	}
	
	    
	    /**     
	     * @discription 获得50个随机数
	     * @author 龚梁钧       
	     * @created Dec 9, 2016 10:17:29 PM     
	     * @return  List <Integer>   
	     */
	public static List<Integer> getRandList() {
		  List<Integer> list = new ArrayList<Integer>();
			StringBuffer sBuffer = new StringBuffer(); 
			sBuffer.append("随机生成50 个小于100 的数分别为:");
			for (int i = 0; i < 50; i++) {
				Random r = new Random();
				int j = r.nextInt(100)+1;
				list.add(j);
				sBuffer.append(j);
				if (list.size()!=50)
					sBuffer.append(",");
			}
			System.out.println(sBuffer);  //输出得到的50个随机数
			return list;
	}
	  
	    /**     
	     * @discription 获得未排序之前的结果
	     * @author 龚梁钧       
	     * @created Dec 9, 2016 10:14:53 PM     
	     * @param list
	     * @return     
	     */
	public static Set<Map.Entry<Integer, HashSet<Integer>>> noSortMap(List<Integer> list) {
		TreeMap<Integer, HashSet<Integer>> map = new TreeMap<Integer, HashSet<Integer>>();
		for (int i : list) {
			int j = i / 10;
			if (map.keySet().contains(j)) {
				HashSet<Integer> set = map.get(j);
				set.add(i);
				map.put(j, set);
			} else {
				HashSet<Integer> set = new HashSet<Integer>();
				set.add(i);
				map.put(j, set);
			}
		}
		return map.entrySet();
	}
	
	    /**     
	     * @discription 得到排序后的結果
	     * @author 龚梁钧       
	     * @created Dec 9, 2016 10:09:17 PM     
	     * @param list
	     * @return     
	     */
	public static Set<Map.Entry<Integer, TreeSet<Integer>>> sortMap(List<Integer> list){
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
		return map.entrySet();
	}
	
}
