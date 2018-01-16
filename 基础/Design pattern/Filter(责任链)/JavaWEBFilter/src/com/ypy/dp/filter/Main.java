package com.ypy.dp.filter;
/*
 * 时间：2017年1月11日 13:06:19。
 * 目的：责任链javaWEB，能够将两条过滤链的过滤顺序以相反的方向返回。
 * 方法：主要部分代码执行顺序---> FilterChain.java22行     index==1
 *                        HTMLFilter.java7行    执行request的HTML过滤
 *                        HTMLFilter.java8行
 *                        FilterChain.java17-22行      index==2
 *                        SesitiveFilter.java7行     执行request的敏感过滤
 *                        SesitiveFilter.java8行
 *                        FilterChain.java17行        index==filters.size()  return
 *                        SesitiveFilter.java9行     执行response的敏感过滤
 *                        HTMLFilter.java9行     执行response的HTML过滤
 */
public class Main {
	public static void main(String[] args) {
		String msg = "大家好:)，<script>,敏感，哈哈哈....";
		Request request = new Request();
		request.setRequestStr(msg+"request");
		Response response = new Response();
		response.setResponseStr(msg+"response");
		FilterChain fc = new FilterChain();
		fc.addFilter(new HTMLFilter())
		    .addFilter(new SesitiveFilter());
		fc.doFilter(request, response, fc);
		System.out.println(request.getRequestStr());
		System.out.println(response.getResponseStr());
	}
}
