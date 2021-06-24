// Problem 2: Search in rotated sorted array

// Approach 1: Brute Force
// Time Complexity : O(N); N = number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// In brute force approach, iterarting and searching target element and returning the index
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                return i;
            }
        }
        return -1;
    }
}

// Approach 2: Optimized
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// Using one pass binary search approach
class Solution {
    public int search(int[] nums, int target) {
        
      int start = 0, end = nums.length - 1;
    while (start <= end) 
    {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) 
          return mid;
      else if (nums[mid] >= nums[start]) 
      {
        if (target >= nums[start] && target < nums[mid]) 
            end = mid - 1;
        else 
            start = mid + 1;
      }
      else 
      {
        if (target <= nums[end] && target > nums[mid]) 
            start = mid + 1;
        else 
            end = mid - 1;
      }
    }
    return -1;
    }
}