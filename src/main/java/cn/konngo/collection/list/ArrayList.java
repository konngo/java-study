package cn.konngo.collection.list;

import java.util.Arrays;

/**
 * @author konngo
 * 
 * 自定义实现数组List
 */
public class ArrayList<E> {
	// 用于存放数据
	private Object[] elements = {}; 
	// 默认长度
	private int DEFAULT_LENGTH = 10;
	// 当前list长度
	private int size;
	
	// 添加数据
	public void add (E e) {
		// 如果数组已经没有空余位置
		if(size == elements.length) {
			grow();
		}
		// 添加数据到ArrayList
		elements[size++] = e;
	}
	
	// 删除数据
	public void remove (E e) {
		int i = 0;
		for (; i<size ; i++) {
			if (e.equals(elements[i])) break;
		}
		/**
		 * System.arraycopy(old_element, start_pos, new_element, new_pos , length);
		 * old_element:要复制的数组
		 * start_pos:复制源数组的起始位置
		 * new_element:目标数组
		 * new_pos:目标数组的下标位置
		 * length:要复制的长度
		 */
		
		System.arraycopy(elements, i+1, elements, i, size-i);
	}
	
	// 数组扩容
	private void grow() {
		// 长度为当前数组长度的3/2
		int oldLength = elements.length;
		if (oldLength>0) {
			int newLength = oldLength + (oldLength >> 1) ; 
			elements = Arrays.copyOf(elements, newLength);
		}else {
			// 如果当前数组为空，设置默认数组
			elements = new Object[DEFAULT_LENGTH];
		}
	}
	
	public String toString() {
		return Arrays.toString(elements);
	}
}
