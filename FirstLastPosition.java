/*
Author: Akhilesh Borgaonkar
Problem: Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Approach: Using binary search to find the first and last index having value equal to target. Find the target using binary search then 
    check if its neighbour is possibly equal to target and then follow the binary search in the neghboring left/right sub arrays.
Time Complexity: O(logn) where n is number of elements in the array.
Space complexity: O(1) constant
LC Verified.
*/

class Solution {
    
    private int getLeftMost(int[] nums, int target){
        int low = 0, high = nums.length-1;
        
        while(low<=high){                   //not letting low cross high ptr
            int mid = low + (high-low)/2;   //calculating mid
            
            if(target == nums[mid]){          //target found
                if(mid == low || nums[mid-1]<nums[mid]) //now checking left of mid
                    return mid;
                else
                    high = mid - 1;         //if left of mid also equal to mid then again search in left sub array
            }
            
            if(target > nums[mid])
                low = mid + 1;
            
            if(target < nums[mid])
                high = mid - 1;
        }
        return -1;
    }
    
    private int getRightMost(int[] nums, int target){
        int low = 0, high = nums.length-1;
        
        while(low<=high){                   //not letting low cross high ptr
            int mid = low + (high-low)/2;   //calculating mid
            
            if(target == nums[mid]){          //target found
                if(mid == high || nums[mid+1]>nums[mid])    //now checking right of mid
                    return mid;
                else
                    low = mid + 1;          //if right of mid also equal to mid then again search in right sub array
            }
            
            if(target > nums[mid])
                low = mid + 1;
            
            if(target < nums[mid])
                high = mid - 1;
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int left = getLeftMost(nums, target);
        int right = getRightMost(nums, target);
       
        return new int[]{left, right};
        
        
    }
}