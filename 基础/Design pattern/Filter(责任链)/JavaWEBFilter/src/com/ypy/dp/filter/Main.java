package com.ypy.dp.filter;
/*
 * ʱ�䣺2017��1��11�� 13:06:19��
 * Ŀ�ģ�������javaWEB���ܹ��������������Ĺ���˳�����෴�ķ��򷵻ء�
 * ��������Ҫ���ִ���ִ��˳��---> FilterChain.java22��     index==1
 *                        HTMLFilter.java7��    ִ��request��HTML����
 *                        HTMLFilter.java8��
 *                        FilterChain.java17-22��      index==2
 *                        SesitiveFilter.java7��     ִ��request�����й���
 *                        SesitiveFilter.java8��
 *                        FilterChain.java17��        index==filters.size()  return
 *                        SesitiveFilter.java9��     ִ��response�����й���
 *                        HTMLFilter.java9��     ִ��response��HTML����
 */
public class Main {
	public static void main(String[] args) {
		String msg = "��Һ�:)��<script>,���У�������....";
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
