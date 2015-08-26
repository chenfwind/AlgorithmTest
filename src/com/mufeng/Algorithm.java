package com.mufeng;

import java.util.*;

public class Algorithm {
	
	//��������
	/*
	 * ������a�ĵ�n��������ǰn-1�����У�ע��ǰn-1�����Ѿ����ź������
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
			System.out.println("��"+ i+"�Σ� ");
			System.out.println(Arrays.toString(arr));
		}
	}
	
	//��������[�ݹ�]
	/*
	 * �ݹ���룬����׳˵�˼��һ����ǰn-1���ź�������飬�ǽ�����ǰn-2���ź��������Ļ����ϲ������
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

	//ð������
	/*
	 * ԭ�����ٽ��������������бȽ�,���մ�С������ߴӴ�С��˳����н���,
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
					 * λ���㷨����
					 * */
					arr[j] = arr[j + 1] ^ arr[j];
					arr[j+1] = arr[j + 1] ^ arr[j];
					arr[j] = arr[j + 1] ^ arr[j];
				}
			}
		}
	}
	
	//ѡ������
	/*
	 * ���������������ҵ���С�ģ�Ȼ��ŵ���һ��λ�á�֮���ٿ�ʣ��Ԫ������С�ģ��ŵ��ڶ���λ�á����Դ����ƣ��Ϳ�������������������ˡ�
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
	
	//�鲢����
	/*
	 * ���ȿ�������ν��������������кϲ�������ǳ��򵥣�ֻҪ�ӱȽ϶������еĵ�һ������˭С����ȡ˭��ȡ�˺���ڶ�Ӧ������ɾ���������
	 * Ȼ���ٽ��бȽϣ����������Ϊ�գ���ֱ�ӽ���һ�����е���������ȡ������
	 * 
	 * */
		
//	 public void Merge(int[] array, int low, int mid, int high) {
//
//	        int i = low; // i�ǵ�һ�����е��±�
//
//	        int j = mid + 1; // j�ǵڶ������е��±�
//
//	        int k = 0; // k����ʱ��źϲ����е��±�
//
//	        int[] array2 = new int[high - low + 1]; // array2����ʱ�ϲ�����
//
//
//
//	        // ɨ���һ�κ͵ڶ������У�ֱ����һ��ɨ�����
//
//	        while (i <= mid && j <= high) {
//
//	            // �жϵ�һ�κ͵ڶ���ȡ�������ĸ���С���������ϲ����У�����������ɨ��
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
//	        // ����һ�����л�ûɨ���꣬����ȫ�����Ƶ��ϲ�����
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
//	        // ���ڶ������л�ûɨ���꣬����ȫ�����Ƶ��ϲ�����
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
//	        // ���ϲ����и��Ƶ�ԭʼ������
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
//	        // �鲢gap���ȵ����������ӱ�
//
//	        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
//
//	            Merge(array, i, i + gap - 1, i + 2 * gap - 1);
//
//	        }
//
//	        
//
//	        // ���������ӱ����߳���С��gap
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
//	    // ��ӡ��������
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
//	        System.out.print("����ǰ:\t\t");
//
//	        merge.printAll(array);
//
//	        merge.sort(array);
//
//	        System.out.print("�����:\t\t");
//
//	        merge.printAll(array);
//
//	    }

	
		/**
		 * �鲢����
		 * ���:�����������������ϣ������ϲ���һ���µ������ ���Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�Ȼ���ٰ����������кϲ�Ϊ������������
		 * ʱ�临�Ӷ�ΪO(nlogn)
		 * �ȶ�����ʽ
		 * @param nums ����������
		 * @return �����������
		 */
		public static void mergeSort(int[] nums, int low, int high) {
			int mid = (low + high) / 2;
			
			if (low < high) {
				// ���
				mergeSort(nums, low, mid);
				// �ұ�
				mergeSort(nums, mid + 1, high);
				// ���ҹ鲢
				merge(nums, low, mid, high);
			}
		}

		
		public static void merge(int[] nums, int low, int mid, int high) {
			int[] temp = new int[high - low + 1];
			int i = low;// ��ָ��
			int j = mid + 1;// ��ָ��
			int k = 0;

			// �ѽ�С�������Ƶ���������
			while (i <= mid && j <= high) {
				if (nums[i] < nums[j]) {
					temp[k++] = nums[i++];
				} else {
					temp[k++] = nums[j++];
				}
			}

			// �����ʣ�������������
			while (i <= mid) {
				temp[k++] = nums[i++];
			}

			// ���ұ߱�ʣ�������������
			while (j <= high) {
				temp[k++] = nums[j++];
			}

			// ���������е�������nums����
			for (int k2 = 0; k2 < temp.length; k2++) {
				nums[k2 + low] = temp[k2];
			}
		}

		/***
		 * ��������
		 * 1���ȴ�������ȡ��һ������Ϊ��׼����
		 * 2���������̣���������������ȫ�ŵ������ұߣ�С�ڻ����������ȫ�ŵ�������ߡ�
		 * 3���ٶ����������ظ��ڶ�����ֱ��������ֻ��һ������
		 */
		/**
		 * @param arr ����
		 * @param left ���
		 * @param right �ұ�
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
		 * ��������
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
