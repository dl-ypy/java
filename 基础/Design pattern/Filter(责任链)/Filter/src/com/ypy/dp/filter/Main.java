package com.ypy.dp.filter;
/*
 * 时间：2017年1月11日 09:24:59。
 * 目的：责任链
 */
public class Main {
	public static void main(String[] args) {
		String msg = "大家好:)，<script>,敏感，哈哈哈....";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		FilterChain fc = new FilterChain();
		FilterChain fc2 = new FilterChain();
		fc.addFilter(new HTMLFilter())
		    .addFilter(new SesitiveFilter());
		fc2.addFilter(new FaceFilter());
		fc.addFilter(fc2);   //将两条过滤链链接起来
		mp.setFc(fc);
		String result = mp.process();
		System.out.println(result);
	}
}
