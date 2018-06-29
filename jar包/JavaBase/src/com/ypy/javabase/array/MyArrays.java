package com.ypy.javabase.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @author joker
 * @data 2018��6��25��15��59��
 * @target ��װ����ĳ��ò���
 */
public class MyArrays {
	
	/**
	 * �����ֵ��Сֵʱ������ת��Ϊ����
	 * @param arr ����
	 * @return
	 * @description 
	 *     1������һ���������û�ȡ���ֽ����ļ�
	 *     2����Class�ľ�̬������isArray�ж��ǲ�������
	 *     3��������Ļ�ͨ��componentType()������ȡ����������
	 *     4�������ͽ����жϣ��ǻ����������;�һ������ӽ�list���ϣ��Զ�װ�䣩
	 *     5�����ǵĻ�����Object�е�arrayCopy������ֱ����ӽ�list����
	 */
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	private static List getMaxMinArrToList(Object arr) {
		Class clazz = arr.getClass();
		List list = new ArrayList();
		int length = 0;
		//�ж��ǲ�������
		if (clazz.isArray()) {
			//�õ�����ĳ���
			length = Array.getLength(arr);
			Class componentType = clazz.getComponentType(); //��ȡ������������
			//�ж��Ƿ�Ϊ������������
			if (componentType==int.class
					|| componentType==double.class
					|| componentType==float.class
					|| componentType==long.class
					|| componentType==char.class
					|| componentType==short.class) {
				for (int i=0; i<length; i++) {
					list.add(Array.get(arr, i));
				}
			//�ж��Ƿ�Ϊ��װ����
			} else if (componentType==Integer.class
					|| componentType==Float.class
					|| componentType==Double.class
					|| componentType==Long.class) {
				Object[] newArr = (Object[])Array.newInstance(componentType, length);
				System.arraycopy(arr, 0, newArr, 0, length);
				list = Arrays.asList(newArr);
			} else {
				throw new RuntimeException("��������������");
			}
		} else {
			throw new RuntimeException("����������");
		}
		return list;
	}
	
	/**
	 * �������е����ֵ
	 * @param arr ����
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object getMax(Object arr) {
		return Collections.max(getMaxMinArrToList(arr));
	}
	
	/**
	 * �������е���Сֵ
	 * @param arr ����
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object getMin(Object arr) {
		return Collections.min(getMaxMinArrToList(arr));
	}
}
