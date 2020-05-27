// Time Complexity : O(logn)
// Space Complexity : O(logn) considering stack usage for recursion
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    
    /*
       find pivot recursively, if pivot not present, use simple binary search
       if pivot found, do simple binary search in one of the half of an array
    */
    
    public int search(int[] nums, int target) {
        int pivot = pivot(nums, 0, nums.length - 1);
        
        if(pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        
        if(nums[pivot] == target)
            return pivot;
        
        if( target >= nums[0])
            return binarySearch(nums, 0, pivot - 1, target);
        else
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        
    }
    
    //simple binary search using recursion
    public int binarySearch(int[] nums, int low, int high, int key) {
        
        if(low <= high){
            int mid = (low + high)/2;
            
            if(nums[mid] == key){
                return mid;
            }
            
            if(key < nums[mid]) {
                return binarySearch(nums, low, mid - 1, key);
            } else
                return binarySearch(nums, mid + 1, high, key);
        } else
            return -1;
    }
    
    private int pivot(int[] nums, int low, int high) {
        
    		//pivot not found
        if(high < low)
            return -1;
        
        if(high == low)
            return high;
        
        int mid = (low + high) / 2;
        
        if(mid < high && nums[mid] > nums[mid + 1])
            return mid;
        
        if(mid > low && nums[mid] < nums[mid - 1])
            return mid - 1;
        
        //pivot is on the right side of mid
        if(nums[mid] >= nums[low]) 
            return pivot(nums, mid + 1, high);
        //pivot is on the left side of the mid
        else
            return pivot(nums, low, mid - 1);
        
    }
}