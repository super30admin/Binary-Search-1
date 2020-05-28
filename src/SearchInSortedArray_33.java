//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
// Time Complexity : O(logn)
// Space Complexity : O(logn) considering stack usage for recursion
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
    	   //base conditions
       if(nums == null || nums.length == 0) return new int[]{-1, -1};
       if(nums[0] == target && nums[nums.length -1] == target) return new int[]{0, nums.length - 1};
        
       int leftIndex = binarySearchLeft(nums, target);
       int rightIndex = binarySearchRight(nums, target);
       return new int[]{leftIndex, rightIndex};
        
    }
    
    private int binarySearchLeft(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) {
            	    //if mid is 0 or greater than previous then its first instance of target
                if(mid == 0 || nums[mid] > nums[mid - 1]) {
                    return mid;
                //else if is non first instance and first instance is to the left    
                }else if (nums[mid] == nums[mid - 1]) {
                    high = mid - 1;
                }
            }
            //first instance is to the right    
            if(nums[mid] < target) {
                low = mid + 1;
            //first instance is to the left    
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        
        return -1;
        
    }
    
    private int binarySearchRight(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]) {
                    return mid;
                }else if (nums[mid] == nums[mid + 1]) {
                    low = mid + 1;
                }
            }
                
            if(nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        
        return -1;
    }
}