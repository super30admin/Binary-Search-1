
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Referred https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

class Solution {
    public int search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) 
            return -1;
        
        int left = 0;
        int right = nums.length -1;
        
        while (left < right)
        {
            int mid = left + (right - left)/2; // To avoid Integer Overflow
            if (nums[mid] > nums[right])
            {
                left = mid + 1;
            }
            else
                right = mid;
        }
        int start = left;
        left = 0;
        right = nums.length -1;

        
        if (target >= nums[start] && target <= nums[right]) // Start the search of sorted array from left
        {
            left = start;
        }
        else 
        {
            right = start;           // Start the search of sorted array from right
        }
        
         while (left <= right)  // Binary Search
        {
            int mid = left + (right - left)/2;
             
             if (nums[mid] == target)
             {
                 return mid;
             }
             else if(nums[mid] < target)
             {
                 left = mid + 1;
             }
             
             else
             {
                 right = mid -1;
             }
         
        }
        return -1;
        
}
}
