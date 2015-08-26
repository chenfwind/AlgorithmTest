package com.mufeng;

import java.util.*;

public class Algorithm {
	
	//插入排序
	/*
	 * 把数组a的第n个数插入前n-1个数中，注意前n-1个数已经是排好序的了
	 * */
	public static void insertSort(int[] arr){
		int len = arr.length;
		int key;
		int i,j;
		for(i = 1; i < len; i++){
			j = i;
			key = arr[i];
			
			while(j > 0 && key < arr[j-1]){
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = key;
			System.out.println("第"+ i+"次： ");
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//插入排序[递归]
	/*
	 * 递归插入，跟求阶乘的思想一样，前n-1个排好序的数组，是建立在前n-2个排好序的数组的基础上插出来的
	 * */
	public static void insertSortRecursively(int[] arr, int index){
		int len = arr.length;
		int i;
		if(index >= len){
			return;
		}
		int key = arr[index];
		for(i = index -1; i >= 0 && key < arr[i]; i--){
			arr[i + 1] = arr[i];
		}
		arr[i + 1] = key;
		insertSortRecursively(arr, index+1);
	}

	//冒泡排序
	/*
	 * 原理是临近的数字两两进行比较,按照从小到大或者从大到小的顺序进行交换,
	 * */
	public static void bubbleSort(int[] arr){
		int len = arr.length;
		int i, j;
//		int item;
		for(i = len; i > 0; i--){
			for(j = 0; j< i-1; j++){
				if(arr[j] > arr[j + 1]){
//					item = arr[j + 1];
//					arr[j + 1] =arr[j];
//					arr[j] = item;
					/*
					 * 位运算法交换
					 * */
					arr[j] = arr[j + 1] ^ arr[j];
					arr[j+1] = arr[j + 1] ^ arr[j];
					arr[j] = arr[j + 1] ^ arr[j];
				}
			}
		}
	}
	
	//选择排序
	/*
	 * 从所有序列中先找到最小的，然后放到第一个位置。之后再看剩余元素中最小的，放到第二个位置……以此类推，就可以完成整个的排序工作了。
	 * */
	public static void selectSort(int[] arr){
		int len = arr.length;
		int i, j;
		int min;
		for(i = 0;i < len; i++){
			min = arr[i];
			for(j = i + 1; j < len; j++){
				if(min > arr[j]){
					min = arr[j] ^ min;
					arr[j] = arr[j] ^ min;
					min = arr[j] ^ min;
				}
			}
			arr[i] = min;
		}
	}
	
	//归并排序
	/*
	 * 首先考虑下如何将将二个有序数列合并。这个非常简单，只要从比较二个数列的第一个数，谁小就先取谁，取了后就在对应数列中删除这个数。
	 * 然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可
	 * 
	 * */
		
//	 public void Merge(int[] array, int low, int mid, int high) {
//
//	        int i = low; // i是第一段序列的下标
//
//	        int j = mid + 1; // j是第二段序列的下标
//
//	        int k = 0; // k是临时存放合并序列的下标
//
//	        int[] array2 = new int[high - low + 1]; // array2是临时合并序列
//
//
//
//	        // 扫描第一段和第二段序列，直到有一个扫描结束
//
//	        while (i <= mid && j <= high) {
//
//	            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
//
//	            if (array[i] <= array[j]) {
//
//	                array2[k] = array[i];
//
//	                i++;
//
//	                k++;
//
//	            } else {
//
//	                array2[k] = array[j];
//
//	                j++;
//
//	                k++;
//
//	            }
//
//	        }
//
//
//
//	        // 若第一段序列还没扫描完，将其全部复制到合并序列
//
//	        while (i <= mid) {
//
//	            array2[k] = array[i];
//
//	            i++;
//
//	            k++;
//
//	        }
//
//
//
//	        // 若第二段序列还没扫描完，将其全部复制到合并序列
//
//	        while (j <= high) {
//
//	            array2[k] = array[j];
//
//	            j++;
//
//	            k++;
//
//	        }
//
//
//
//	        // 将合并序列复制到原始序列中
//
//	        for (k = 0, i = low; i <= high; i++, k++) {
//
//	            array[i] = array2[k];
//
//	        }
//
//	    }
//
//
//
//	    public void MergePass(int[] array, int gap, int length) {
//
//	        int i = 0;
//
//	        
//
//	        // 归并gap长度的两个相邻子表
//
//	        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
//
//	            Merge(array, i, i + gap - 1, i + 2 * gap - 1);
//
//	        }
//
//	        
//
//	        // 余下两个子表，后者长度小于gap
//
//	        if (i + gap - 1 < length) {
//
//	            Merge(array, i, i + gap - 1, length - 1);
//
//	        }
//
//	    }
//
//
//
//	    public int[] sort(int[] list) {
//
//	        for (int gap = 1; gap < list.length; gap = 2 * gap) {
//
//	            MergePass(list, gap, list.length);
//
//	            System.out.print("gap = " + gap + ":\t");
//
//	            this.printAll(list);
//
//	        }
//
//	        return list;
//
//	    }
//
//
//
//	    // 打印完整序列
//
//	    public void printAll(int[] list) {
//
//	        for (int value : list) {
//
//	            System.out.print(value + "\t");
//
//	        }
//
//	        System.out.println();
//
//	    }
//
//
//
//	    public static void main(String[] args) {
//
//	        int[] array = { 9, 1, 5, 3, 4, 2, 6, 8, 7};
//
//	        Algorithm merge = new Algorithm();
//
//	        System.out.print("排序前:\t\t");
//
//	        merge.printAll(array);
//
//	        merge.sort(array);
//
//	        System.out.print("排序后:\t\t");
//
//	        merge.printAll(array);
//
//	    }

	
		/**
		 * 归并排序
		 * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
		 * 时间复杂度为O(nlogn)
		 * 稳定排序方式
		 * @param nums 待排序数组
		 * @return 输出有序数组
		 */
		public static void mergeSort(int[] nums, int low, int high) {
			int mid = (low + high) / 2;
			
			if (low < high) {
				// 左边
				mergeSort(nums, low, mid);
				// 右边
				mergeSort(nums, mid + 1, high);
				// 左右归并
				merge(nums, low, mid, high);
			}
		}

		
		public static void merge(int[] nums, int low, int mid, int high) {
			int[] temp = new int[high - low + 1];
			int i = low;// 左指针
			int j = mid + 1;// 右指针
			int k = 0;

			// 把较小的数先移到新数组中
			while (i <= mid && j <= high) {
				if (nums[i] < nums[j]) {
					temp[k++] = nums[i++];
				} else {
					temp[k++] = nums[j++];
				}
			}

			// 把左边剩余的数移入数组
			while (i <= mid) {
				temp[k++] = nums[i++];
			}

			// 把右边边剩余的数移入数组
			while (j <= high) {
				temp[k++] = nums[j++];
			}

			// 把新数组中的数覆盖nums数组
			for (int k2 = 0; k2 < temp.length; k2++) {
				nums[k2 + low] = temp[k2];
			}
		}

		/***
		 * 快速排序
		 * 1．先从数列中取出一个数作为基准数。
		 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
		 * 3．再对左右区间重复第二步，直到各区间只有一个数。
		 */
		/**
		 * @param arr 数组
		 * @param left 左边
		 * @param right 右边
		 */
		public static void quickSort(int[] arr,int left,int right){
			if(left < right){
				int pivo = arr[left];
				int low = left;
				int high = right;
				while(low < high){
					while(arr[high] > pivo && low < high){
						high--;
					}
					arr[low] = arr[high];
					while(arr[low] < pivo && low < high){
						low++;
					}
					arr[high] = arr[low];
				}
				arr[low] = pivo;
				quickSort(arr, left, low-1);
				quickSort(arr, low+1, right);
			}
		}
		
	
		/**
		 * 计数排序
		 * @param arr
		 * @param k
		 * @return
		 */
		public static int[] countingSort(int[] arr,int k){
			int n = arr.length;
			int B[] = new int[n];
			int C[] = new int[k+1];
			int i;
			for(i = 0;i < k; i++){
				C[i] = 0;
			}
			
			for(i = 0;i < n; i++){
				C[arr[i]]++;
			}
			
			for(i = 1; i < k; i++){
				C[i] = C[i] + C[i - 1];
			}
			
			for(i = n-1; i >= 0; i--){
				System.out.println(i);
				B[C[arr[i]]-1] = arr[i];
				C[arr[i]]--;
			}
			return B;
		}
	
	
	
	
	
	
	
}
