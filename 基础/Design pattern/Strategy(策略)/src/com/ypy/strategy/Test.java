package com.ypy.strategy;

/*
 *ʱ�䣺2016��12��15�� 16:38:37
 *Ŀ�ģ�����ģʽ
 *�������еıȽϲ���
 */
public class Test {
	public static void main(String[] args) {
		//int a[] = {2,5,0,9,8}; 
		Cat a[] = {new Cat(20,50), new Cat(90,10), new Cat(12,30)};
		//Dog a[] = {new Dog(88), new Dog(20), new Dog(12)};
		DataSorter.sort(a);
		DataSorter.p(a);
	}

}
