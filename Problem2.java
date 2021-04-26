
//Problem 2: Search in a Rotated Sorted Array

// Time Complexity : O(log n) ; where n = number of elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach used : binary search
class Solution {
    public int search(int[] nums, int target) {
        
     //initializing the start and the end 
    int start = 0, end = nums.length - 1;
        
     
    while (start <= end) 
    {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) 
          return mid;
       
       //checking if it is sorted
      else if (nums[mid] >= nums[start]) 
      {
         // checking within the sorted range if the element is present 
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
