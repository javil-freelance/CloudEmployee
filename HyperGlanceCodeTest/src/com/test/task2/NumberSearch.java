package com.test.task2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberSearch {
	public static void countLessThan(int[] nums, int x) {
		
		/**
		 * Convert array to collections for us to use lambda expression
		 */
		List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		
		/**
		 * Use forEach operation to run through the collections and use it in condition
		 */
		numList.forEach(n -> { if(n < x) System.out.println(n); });
	}
	
	public static void main(String[] args) {
		NumberSearch.countLessThan(new int[] {1,2,3,4,5,6,7,8,9}, 7);
	}
}