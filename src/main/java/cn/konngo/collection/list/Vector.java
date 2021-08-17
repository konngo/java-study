package cn.konngo.collection.list;

import java.util.Arrays;

/**
 * @author konngo
 * Vector �� ArrayList��ͬ���� Vector���߳�ͬ���ġ������ڶ�Ӧ��add��remove�������м�ͬ������
 */
public class Vector<E> {
	// ���ڴ������
		private Object[] elements = {}; 
		// Ĭ�ϳ���
		private int DEFAULT_LENGTH = 10;
		// ��ǰlist����
		private int size;
		
		// �������
		public synchronized void add (E e) {
			// ��������Ѿ�û�п���λ��
			if(size == elements.length) {
				grow();
			}
			// ������ݵ�ArrayList
			elements[size++] = e;
		}
		
		// ɾ������
		public synchronized void remove (E e) {
			int i = 0;
			for (; i<size ; i++) {
				if (e.equals(elements[i])) break;
			}
			/**
			 * System.arraycopy(old_element, start_pos, new_element, new_pos , length);
			 * old_element:Ҫ���Ƶ�����
			 * start_pos:����Դ�������ʼλ��
			 * new_element:Ŀ������
			 * new_pos:Ŀ��������±�λ��
			 * length:Ҫ���Ƶĳ���
			 */
			
			System.arraycopy(elements, i+1, elements, i, size-i);
		}
		
		// ��������
		private void grow() {
			// ����Ϊ��ǰ���鳤�ȵ�3/2
			int oldLength = elements.length;
			if (oldLength>0) {
				int newLength = oldLength + (oldLength >> 1) ; 
				elements = Arrays.copyOf(elements, newLength);
			}else {
				// �����ǰ����Ϊ�գ�����Ĭ������
				elements = new Object[DEFAULT_LENGTH];
			}
		}
		
		public String toString() {
			return Arrays.toString(elements);
		}
}
