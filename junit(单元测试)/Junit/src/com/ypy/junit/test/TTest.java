package com.ypy.junit.test;

import static org.junit.Assert.*;//引入静态类中的方法

import org.junit.Test;

import com.ypy.junit.T;

public class TTest {

	@Test
	public void testAdd() {
		int z = new T().add(3, 5);
		assertEquals(8, z);//判断结果是不是8
	}

}
