package com.ypy.junit.test;

import static org.junit.Assert.*;//���뾲̬���еķ���

import org.junit.Test;

import com.ypy.junit.T;

public class TTest {

	@Test
	public void testAdd() {
		int z = new T().add(3, 5);
		assertEquals(8, z);//�жϽ���ǲ���8
	}

}
