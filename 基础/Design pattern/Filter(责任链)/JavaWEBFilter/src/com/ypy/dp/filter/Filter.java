package com.ypy.dp.filter;
//���˷����Ľӿ�
public interface Filter {
	void doFilter(Request request, Response response, FilterChain chain);
}
