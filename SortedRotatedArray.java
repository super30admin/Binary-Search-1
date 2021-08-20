// Time Complexity:  O(log n)
// Space Complexity: O(1) since it's a constant space solution.
// Did this code run successfully on leetcode: Yes
// Did u face any difficulty while solvign this problem: No



class Solution {
    public int search(int[] nums, int target) {
       // if the array is null/empty 
      if(nums == null || nums.length == 0)
          return -1;
      int low = 0; // first element index
      int high = nums.length - 1; // last element index
      while(low<=high) {
          // while low is smaller/equal to high find mid and                   perform binary search on that array 
         int mid = low+ (high - low)/2;
         if(nums[mid] == target)//if mid is target, return mid
              return mid;
          else if (nums[low] <= nums[mid]) {
              // which means if left is sorted array
              if(nums[low] <= target && nums[mid] > target) {
                  high = mid -1;
              }
              else {
                  low = mid+1;
              }
          }else {
              // // which means if right is sorted array
             if(nums[mid] < target && nums[high] >= target) {
                  low = mid +1;
              }
             else{
                  high = mid -1;
              } 
      }
    }
        return -1;
  }
}