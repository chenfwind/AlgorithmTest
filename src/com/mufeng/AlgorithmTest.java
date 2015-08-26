package com.mufeng;

import java.util.Arrays;


/**
 * @author mufeng
 *
 */
public class AlgorithmTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 7, 8, 3, 1, 6, 9, 0, 5, 4 };
		System.out.println(Arrays.toString(arr));
		/*
		 * ≤Â»Î≈≈–Ú
		 * */
//		Algorithm.insertSort(arr);
		/*
		 * µ›πÈ≈≈–Ú
		 * */
//		Algorithm.insertSortRecursively(arr, 0);
		/*
		 * √∞≈›≈≈–Ú
		 * */
//		Algorithm.bubbleSort(arr);
		/*
		 * —°‘Ò≈≈–Ú
		 * */
//		Algorithm.selectSort(arr);
		/*
		 * πÈ≤¢≈≈–Úµƒ µœ÷
		 * */
//		Algorithm.mergeSort(arr, 0, arr.length-1);
		/***
		 * øÏ≈≈≈≈–Ú
		 */
//		Algorithm.quickSort(arr, 0, arr.length-1);
		/***
		 * º∆ ˝≈≈–Ú
		 */
		arr = Algorithm.countingSort(arr, 100);
		System.out.println(Arrays.toString(arr));
				
		
	}

}
