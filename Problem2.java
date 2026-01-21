//Search in a Rotated Sorted Array
// (https://leetcode.com/problems/search-in-rotated-sorted-array/)
// Time Complexity :  O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -

class Solution {

  public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      //left sorted
      else if (nums[low] <= nums[mid]) {
        if (
          nums[low] <= target && nums[mid] > target
        ) { //move to left
          high = mid - 1;
        } else { //move to right
          low = mid + 1;
        }
      }
      //right sorted
      else {
        if (nums[mid] < target && nums[high] >= target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }
}

class Problem2 {

  public static void main(String[] args) {
      Solution sol = new Solution();
      int[] array = new int[] {7,8,9,1,3,4,5,6};
      System.out.println(sol.search(array, 6));
      
  }
}
