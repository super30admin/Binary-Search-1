// Search in infinite array
// S30 Big N Problem #6 {Medium}
// Time Complexity :O(log n) binary search
// Space Complexity :
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this :None
// Ran successfully on web-based IDE


// Your code here along with comments explaining your approach
// Iterative solution
import java.io.*;

public class Solution{
	
	public static void main (String[] args) {
	    int [] array={3,5,7,10,15,18,20,25}; // assume it to be infinite
	    int target=3;
		int index=mbsearch(array,target);
		System.out.println("Index found > "+index);
	}
	
	private static int mbsearch(int[] nums, int target){
	    int low=0;
	    int high=1;
	    //logic O(n) type
	    while(target>nums[high]){
	        low=high;
	        high=high*2;
	    }
	    //binary search
	    while(low<=high){
	        int mid=low+(high-low)/2;
	        if(nums[mid]==target) return mid;
	        else if(nums[mid]>=target){
	            high=mid-1;
	        }else{
	            low=mid+1;
	        }
	    }
	    return -1;
	}
}