package com.ypy.javabase.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * @author joker
 * @data 2018年6月25日15点59分
 * @target 封装数组的常用操作
 */
public class MyArrays {
	
	/**
	 * 求最大值最小值时将数组转换为集合
	 * @param arr 数组
	 * @return
	 * @description 
	 *     1、传入一个数组引用获取其字节码文件
	 *     2、用Class的静态方法，isArray判断是不是数组
	 *     3、是数组的话通过componentType()方法获取其数组类型
	 *     4、对类型进行判断，是基本数据类型就一个个添加进list集合（自动装箱）
	 *     5、不是的话就用Object中的arrayCopy（），直接添加进list集合
	 */
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	private static List getMaxMinArrToList(Object arr) {
		Class clazz = arr.getClass();
		List list = new ArrayList();
		int length = 0;
		//判断是不是数组
		if (clazz.isArray()) {
			//得到数组的长度
			length = Array.getLength(arr);
			Class componentType = clazz.getComponentType(); //获取数组数据类型
			//判断是否为基本数据类型
			if (componentType==int.class
					|| componentType==double.class
					|| componentType==float.class
					|| componentType==long.class
					|| componentType==char.class
					|| componentType==short.class) {
				for (int i=0; i<length; i++) {
					list.add(Array.get(arr, i));
				}
			//判断是否为包装类型
			} else if (componentType==Integer.class
					|| componentType==Float.class
					|| componentType==Double.class
					|| componentType==Long.class) {
				Object[] newArr = (Object[])Array.newInstance(componentType, length);
				System.arraycopy(arr, 0, newArr, 0, length);
				list = Arrays.asList(newArr);
			} else {
				throw new RuntimeException("请输入数字数组");
			}
		} else {
			throw new RuntimeException("请输入数组");
		}
		return list;
	}
	
	/**
	 * 求数组中的最大值
	 * @param arr 数组
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object getMax(Object arr) {
		return Collections.max(getMaxMinArrToList(arr));
	}
	
	/**
	 * 求数组中的最小值
	 * @param arr 数组
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Object getMin(Object arr) {
		return Collections.min(getMaxMinArrToList(arr));
	}
}
