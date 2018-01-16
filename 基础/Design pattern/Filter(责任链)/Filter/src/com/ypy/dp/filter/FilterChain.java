package com.ypy.dp.filter;
//过滤链
import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {   //实现Filter接口，使得过滤链也能添加过滤链
	List<Filter> filters = new ArrayList<Filter>();
	
	public FilterChain addFilter(Filter f) {  //可以在添加的时候，一直用链条式的.添加
		this.filters.add(f);
		return this;
	}
	
	public String doFilter(String str) {
		String r = str;
		
		for (Filter f : filters) {
			r = f.doFilter(r);
		}
		
		return r;
	}
}
