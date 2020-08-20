package BinarySearch;

import Problem2.ArrayReader;

/*
 * Search in Infinite sorted array:

Given a sorted array of unknown length and a number to search for,
 return the index of the number in the array. Accessing an element out of bounds 
 throws exception. If the number occurs multiple times, return the index of any occurrence. 
If it isn’t present, return -1.
 * */

public class Problem2 {
	/**
	 * // This is ArrayReader's API interface.
	 * // You should not implement it, or speculate about its implementation*/
	 class  ArrayReader {
	     public int get(int index) {}
	 }
	 

	
	    public int search(ArrayReader reader, int target) {
	       if (reader == null) {
	            return 0;
	        }
	        int left = 0;
	        int right = 1;
	      
	        while (reader.get(right) < target) {
	         
	            left = right;
	            right = 2*right;
	        }
	        return binarySearch(reader, target, left, right);
	    }
	     private int binarySearch(ArrayReader reader, int target, int left, int right) {
	     
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            if (reader.get(mid) > target) {
	                right = mid-1;
	            } else if (reader.get(mid) < target) {
	                left = mid + 1;
	            } else {
	                return mid;
	            }
	        }
	        return -1;
	    }
	
	     public static void main(String args[]) {
	    	 ArrayReader reader= new ArrayReader();
	    	 int target=5;
	    	 
	    	 reader.get(0);
	    	 reader.get(2);
	    	 reader.get(3);
	    	 reader.get(4);
	    	 reader.get(5);
	    	 reader.get(8);
	    	 int res= search(reader,target);
	    	 
	    	 System.out.println("result: "+res);
	     }
}
