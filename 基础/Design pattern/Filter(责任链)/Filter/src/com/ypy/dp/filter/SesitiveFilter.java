package com.ypy.dp.filter;

public class SesitiveFilter implements Filter {

	@Override
	public String doFilter(String str) {
		String r = str.replace("����", "");    //�������滻Ϊ""
		return r;
	}

}
