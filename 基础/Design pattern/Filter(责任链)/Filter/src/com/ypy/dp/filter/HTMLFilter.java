package com.ypy.dp.filter;

public class HTMLFilter implements Filter {

	@Override
	public String doFilter(String str) {
		String r = str.replace("<", "[")   //½«<>Ìæ»»Îª[]
				.replace(">", "]");
		return r;
	}

}
