package com.ypy.dp.filter;

public class SesitiveFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.requestStr = request.requestStr.replace("����", "") + "----SesitiveFilter";
		chain.doFilter(request, response, chain);
		response.responseStr = response.responseStr.replace("����", "") + "----SesitiveFilter";
	}

}
