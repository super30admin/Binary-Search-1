// Time Complexity : O log(2n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
	/*
	 * Traversing after the first sorted array is 
	 * found and then switching to unsorted array 
	 * target not existing in sorted section 
	 */

// Your code here along with comments explaining your approach
/*
 * Partition array into sorted and unsorted sections
 * Firstly check if target exists in sorted array and 
 * then start binary search else
 * move into unsorted array and if target exists in
 * that range then perform binary search there 
 * and return index of target
 * 
 */

public class SearchRotatedSortedArray {
	class Solution {
	    public int search(int[] nums, int target) {
	        int start = 0;
	        int end = nums.length -1;
	        int mid;
	        
	        while(start<= end){
	            mid = start + (end-start)/2;
	            
	            if(target == nums[mid]) return mid;
	            
	            if(nums[mid] >= nums[start]){
	                if(target >= nums[start] && target < nums[mid]){
	                    end = mid-1;
	                }else{
	                    start = mid+1;
	                }
	            }else {
	                if(target <= nums[end] && target > nums[mid]){
	                    start = mid+1;
	                }else{
	                    end = mid-1;
	                }
	            }
	            
	        }
	        return -1;
	    }
	}

}
