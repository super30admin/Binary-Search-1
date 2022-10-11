// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



// Your code here along with comments explaining your approach
// Checking which side is sorted -- mid to end or start to mid and then check if the target lies
// in the sorted range or not. Try with an example


class Solution {
  public int search(int[] nums, int target) {
    int res = findIndex(nums, target);
    return res;
  }

  private int findIndex(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while(start <= end) {
      int mid = start + (end-start)/2;
      if(nums[mid] == target)
        return mid;
        // Checking which side is sorted -- mid to end or start to mid and then check if the target lies in the sorted range or not. Try with an example
      else if(nums[mid] <= nums[end]) {
        if(target > nums[mid] && target <= nums[end])
          start = mid + 1;
        else
          end = mid - 1;
      }
      else if(nums[mid] >= nums[start]) {
        if(target >= nums[start] && target < nums[mid])
          end = mid -1;
        else
          start = mid + 1;
      }
    }
    return -1;
  }
}