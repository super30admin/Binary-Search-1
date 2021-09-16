//Given an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :none

class BinarySearch2 {
  public int search(int[] nums, int target) {

    int low = 0, high = nums.length - 1;

    while (low <= high) {
      // finding the midpoint
      int mid = (low + high) / 2;
      // returning if element is found at mid
      if (nums[mid] == target) return mid;

      // if the subarray with first and mid seems to be sorted
      if (nums[low] <= nums[mid]) {
        // checking range for the search element
        if (target >= nums[low] && target <= nums[mid]) {
          // if target lies between range then consider this subarray
          high = mid - 1;
        } else { // if target doesn't lie here then checking the other half
          low = mid + 1;
        }
      } else { // if the subarray with first mid is not in a sorted order i.e mid>first

        if (target >= nums[mid] && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }
}