// Time Complexity : O(logN) - because I am doing binary search
// Space Complexity : O(1) - No extra space is required
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int search(int[] nums, int target) {
      int start = 0;
      int end = nums.length-1;
        
    // Binary Serach
      while( start <= end )
      {
          int mid = start + (end - start)/2;
          
          if (nums[mid] == target)
              return mid;
          
          // Since it is given that the array is rotated at some point and we don't know the exact rotation point, I am checking if the array is sorted from start and mid, if yes then check if target lies between start and mid, if yes then search in that range otherwise search within mid to end range
          else if (nums[start] <= nums[mid])
          {
              if (nums[mid] > target && nums[start] <= target)
              {
                  end = mid-1 ;
              }
              else
              {
                  start = mid + 1;
              }
          }
          else
          {
              if ( nums[mid] < target && target <= nums[end])
              {
                  start = mid +1 ;
              }
              else
              {
                  end = mid -1 ;
              }
          }    
      }
        return -1;
    }
}
