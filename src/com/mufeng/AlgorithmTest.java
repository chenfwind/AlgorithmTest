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
		 * ��������
		 * */
//		Algorithm.insertSort(arr);
		/*
		 * �ݹ�����
		 * */
//		Algorithm.insertSortRecursively(arr, 0);
		/*
		 * ð������
		 * */
//		Algorithm.bubbleSort(arr);
		/*
		 * ѡ������
		 * */
//		Algorithm.selectSort(arr);
		/*
		 * �鲢�����ʵ��
		 * */
//		Algorithm.mergeSort(arr, 0, arr.length-1);
		/***
		 * ��������
		 */
//		Algorithm.quickSort(arr, 0, arr.length-1);
		/***
		 * ��������
		 */
		arr = Algorithm.countingSort(arr, 100);
		System.out.println(Arrays.toString(arr));
				
		
	}

}
