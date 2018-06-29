package com.ypy.arithmetic.test;

import java.util.Arrays;

import com.ypy.arithmetic.Sort.Sort;

public class Test {

	public static void main(String[] args) {
		Integer[] arr = {3,0,-99,88,1};
		Sort.binaryInsertSortDesc(arr);
		System.out.println(Arrays.toString(arr));
	}

}
