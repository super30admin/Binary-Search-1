/*package whatever //do not write package name here */
// Time Complexity :O(logn)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Index out of bound
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    //sample input to test our approach
		int[] arr1={1,2,3,4,5,6,7,8,9,10};
		int element=5;
		int idx= modifiedBinarySearch(arr1,element);
		System.out.println("Idx::"+idx);
	}
	public static int binarySearch(int[] nums,int target,int low,int high)
	{
	   //simple binary search function
	    while(low<=high)
	    {   //updating mid at each iteration
	        int mid=low+(high-low)/2;
	        //if element at mid is target, return that
	        if(nums[mid]==target)return mid;
	        //if mid element is greater than target,take left part
	        else if(nums[mid]>target)
	        {
	            high=mid-1;
	        }
	        //else take the right one
	        else low=mid+1;
	    }
	    //return -1 if element is not found
	    return -1;
	}
	private static int modifiedBinarySearch(int[] nums,int target)
	{//taking variables 
	    int low=0;
	    int high=1;
	    int temp=nums[0];
	    //if temp is smaller than the target,move foreward
	    while(temp<target){
	        //assign high to low
	        low=high;
	        //increase high to two times itself
	        high=2*high;
	        //assign the element at high as temp to check it further
	        temp=nums[high];
	    }
	    //if we reach at temp>target,we got our part to apply simple binary search
	    return binarySearch(nums,target,low,high);
	}
}