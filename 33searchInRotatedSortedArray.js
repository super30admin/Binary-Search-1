// Time Complexity : O(log n)

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this : No

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
  let left = 0,
    right = nums.length - 1;

  while (left <= right) {
    const mid = (left + right) >>> 1;

    if (nums[mid] === target) return mid;
    if (nums[left] <= nums[mid]) // Left half is sorted
    {
      if (target >= nums[left] && target < nums[mid]) // Left side has target
      {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    } else //right half is sorted
    {
      if (target > nums[mid] && target <= nums[right]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
  }
  return -1;
};
