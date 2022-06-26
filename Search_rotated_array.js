// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
  if (!nums || !nums.length) return -1;

  let low = 0;
  let high = nums.length - 1;

  while (low <= high) {
    let mid = low + (high - low / 2);
    if (nums[mid] === target) return mid;
    if (nums[low] < nums[mid]) {
      if (target >= nums[low] && target < nums[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    } else {
      if (target > nums[mid] && target <= nums[high]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
  }
  return -1;
};
