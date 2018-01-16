package com.ypy.dp.filter;
//������
import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {   //ʵ��Filter�ӿڣ�ʹ�ù�����Ҳ����ӹ�����
	List<Filter> filters = new ArrayList<Filter>();
	
	public FilterChain addFilter(Filter f) {  //��������ӵ�ʱ��һֱ������ʽ��.���
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
