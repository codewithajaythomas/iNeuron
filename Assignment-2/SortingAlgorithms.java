package com.fullstack.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortingAlgorithms {

	public static void main(String[] args) {
		int[] arr = {8,5,6,3,4,7,9};
		
		quickSort(arr);
		//bubbleSort(arr);
		//mergeSort(arr);
		//insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		
		//findDuplicates(arr);
		
		/*int[] arr1 = {1,2,3,4,5,6};
		int[] arr2 = {3,2,5};
		isSubset(arr1,arr2);*/
		
	}
	
	public static void findDuplicates(int[] arr) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 
		boolean dupFlag = false;
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i],1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()>1) {
				dupFlag = true;
				System.out.print(entry.getKey() + " ");
			}
		}
		
		if(!dupFlag)
			System.out.println("No duplicates..");
	}
	
	public static void isSubset(int[] arr1,int[] arr2) {
		int count = 0;
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr1.length;j++) {
				if(arr2[i]==arr1[j]) {
					count++;
					break;
				}
			}
		}
		
		if(count == arr2.length)
			System.out.println("arr2 is a subset of arr1");
		else
			System.out.println("arr2 is not a subset of arr1");
	}
	
	public static void insertionSort(int[] arr) {
		int minIndex=0;
		for(int i=0;i<arr.length;i++) {
			minIndex = i;
			for(int j = i;j<arr.length;j++) {
				if(arr[j]<arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr,i,minIndex);
		}
	}
	
	public static void mergeSort(int[] arr) {

		if(arr.length<2)
			return;
			
		int middle = arr.length/2;
		
		int[] left = new int[middle];
		for(int i = 0;i<middle;i++)
			left[i] = arr[i];

		int[] right = new int[arr.length-middle];
		for(int i = middle;i<arr.length;i++)
			right[i-middle] = arr[i];

		mergeSort(left);
		mergeSort(right);	
		
		merge(left,right,arr);
	}
	
	private static void merge(int[] left,int[] right,int[] arr) {

		int i=0,j=0,k=0;
		while(i<left.length && j<right.length) {
			if(left[i]<=right[j])
				arr[k++] = left[i++];
			else
				arr[k++] = right[j++];
		}
		
		while(j<right.length) {
			arr[k++] = right[j++];
		}
		
		while(i<left.length) {
			arr[k++] = left[i++];
		}
		
	}
	
	public static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length;i++)
			for(int j=1;j<arr.length-i;j++) {
				if(arr[j]<arr[j-1]) {
					swap(arr,j,j-1);
				}
			}
	}
		
	public static void quickSort(int[] arr) {			
		quickSort(arr,0,arr.length-1);
	}
	
	private static void quickSort(int[] arr,int start,int end) {	
		
		if(start>=end)
			return;
		
		int boundary = partition(arr,start,end);
	
		quickSort(arr,start,boundary-1);
		quickSort(arr,boundary+1,end);
	}

	private static int partition(int[] arr,int start,int end) {
		int boundary = start - 1;  
		int pivot = arr[end];
		for(int i=start;i<=end;i++) {
			if(arr[i]<=pivot) {
				swap(arr,i,++boundary);
			}
		}
		return boundary;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;	
	}

}
