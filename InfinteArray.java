/*package whatever //do not write package name here */
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes on GeeksforGeeks
// Any problem you faced while coding this : First here we will find the boundary/Searchspace where the target may lie.
// Once we find the searchspace we will use the binary search to find thr taget.

import java.io.*;

class GFG {
	public static void main (String[] args) {
		System.out.println("GfG!");
		int[] arr = {3,5,7,9,10,11,13,15,18,21,23,26,29};
		int target = 10;
		int answer = findTarget(arr, target);
		System.out.println("Target Index = " + answer);
	}
	
	private static int findTarget(int[] arr, int target){
	    int low = 0;
	    int high = 1;
	    while(arr[high] < target){
	        low =  high;
	        high = high * 2;
	    }
	    
	    while(low <=high){
	        int mid = low + (high - low)/2;
	        if(arr[mid] == target){
	            return mid;
	        }
	        
	        if(arr[mid] < target){
	            low = mid + 1;
	        }
	        else{
	            high = mid - 1;
	        }
	    }
	    return -1;
	}
}