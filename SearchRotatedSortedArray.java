/*
Leet Code Problem 33
Search in a rotated sorted array
Language Used : Java
Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
Memory Usage: 38.5 MB, less than 23.13% of Java online submissions for Search in Rotated Sorted Array.

Logic: THe split will be somewhere in the middle, perform binary search on the sorted part to fetch the element
*/
class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high= nums.length-1;
        int mid;
        //   Edge Case if empty      
        if(nums==null||nums.length==0)
            return -1;
        while(low <= high){
            mid= low + (high-low)/2;
            // Check for the element in mid
            if(nums[mid]==target)
                return mid;
            else if(nums[low]<=nums[mid])
            {
                //Left is sorted
                // Basic check for Binary
                if(nums[low]<= target && nums[mid]>target)
                    high=mid-1;
                else
                    low=mid+1;
            }
            else
            {
                //Right is sorted
                if(nums[mid]< target &&nums[high]>=target)
                    low = mid+1;
                else
                    high = mid-1;
            }                                
        }
        return -1;
    }
}