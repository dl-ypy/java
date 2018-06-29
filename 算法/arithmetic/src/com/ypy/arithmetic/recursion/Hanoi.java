package com.ypy.arithmetic.recursion;
/**
 * @author joker
 * @data 2018��6��21��09��51��
 * @target ��ŵ������
 * ����������
 *     �����촴�������ʱ�������������ʯ���ӣ���һ�������ϴ������ϰ��մ�С˳������64Ƭ�ƽ�Բ�̡�
 *     ���������������Ű�Բ�̴����濪ʼ����С˳�����°ڷ�����һ�������ϡ�
 *     ���ҹ涨����СԲ���ϲ��ܷŴ�Բ�̣�����������֮��һ��ֻ���ƶ�һ��Բ�̡�
 * �㷨������
 *     ��ԭ���ϵ�n-1��Բ���ƶ���������
 *     ����n��Բ�̴�ԭ���ƶ���Ŀ����
 *     ����������n-1��Բ���ƶ���Ŀ����
 *     �ݹ�ִ��...
 */
public class Hanoi {

	/**
	 * @param n          Բ�̸���
	 * @param fromPeg    ԭ��
	 * @param toPeg      Ŀ����
	 * @param auxPeg     ������
	 */
	public static void TowersOfHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
		//��ֹ����
		if (n == 1) {
			System.out.println("��"+ fromPeg + "�ƶ�Բ�̵�" +toPeg);
			return;
		}
		//����C����Ϊ��������A���ϵ�n-1��Բ���ƶ���B��
		TowersOfHanoi(n-1, fromPeg, auxPeg, toPeg);
		//��ʣ�µ�Բ�̴�A���ƶ���C��
		System.out.println("��"+ fromPeg + "�ƶ�Բ�̵�" +toPeg);
		//����A����Ϊ��������B���ϵ�n-1��Բ���ƶ���C��
		TowersOfHanoi(n-1, auxPeg, toPeg, fromPeg);
	}
}

/**
 * ��jdk1.8���н��
 * ��A�ƶ�Բ�̵�C
 * ��A�ƶ�Բ�̵�B
 * ��C�ƶ�Բ�̵�B
 * ��A�ƶ�Բ�̵�C
 * ��B�ƶ�Բ�̵�A
 * ��B�ƶ�Բ�̵�C
 * ��A�ƶ�Բ�̵�C 
*/