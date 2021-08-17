package cn.konngo.collection.List;

import java.util.DoubleSummaryStatistics;

import cn.konngo.collection.list.ArrayList;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();
		System.out.println(list.toString());
		list.add("zhangsan");
		list.add(1);
		list.add('c');
		System.out.println(list.toString());
		for(int i = 0 ; i<10; i++) {
			list.add(i);
			System.out.println(list.toString());
		}
		for(int i = 0 ; i<10; i++) {
			list.remove(i);
			System.out.println(list.toString());
		}
	}
}
