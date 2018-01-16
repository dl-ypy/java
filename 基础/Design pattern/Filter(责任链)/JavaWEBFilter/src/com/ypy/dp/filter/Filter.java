package com.ypy.dp.filter;
//过滤方法的接口
public interface Filter {
	void doFilter(Request request, Response response, FilterChain chain);
}
