package com.ypy.dp.filter;
/*
 * ʱ�䣺2017��1��11�� 09:24:59��
 * Ŀ�ģ�������
 */
public class Main {
	public static void main(String[] args) {
		String msg = "��Һ�:)��<script>,���У�������....";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		FilterChain fc = new FilterChain();
		FilterChain fc2 = new FilterChain();
		fc.addFilter(new HTMLFilter())
		    .addFilter(new SesitiveFilter());
		fc2.addFilter(new FaceFilter());
		fc.addFilter(fc2);   //��������������������
		mp.setFc(fc);
		String result = mp.process();
		System.out.println(result);
	}
}
