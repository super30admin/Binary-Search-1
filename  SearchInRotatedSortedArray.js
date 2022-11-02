// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Failed a test case, resolved with correcting the condition check at line 37

// Your code here along with comments explaining your approach

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  if (nums === null || nums.length === 0) {
    return false;
  }
  var low = 0;
  var high = nums.length - 1;

  while (low <= high) {
    var mid = Math.floor((high + low) / 2);
    console.log(nums[low], nums[high], nums[mid], target);
    if (nums[mid] === target) {
      return mid;
    }
    //Check if left side is sorted
    if (nums[low] <= nums[mid]) {
      //Check if target is on left side
      if (target >= nums[low] && target < nums[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    //right side must be sorted
    else {
      if (target > nums[mid] && target <= nums[high]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
  }
  return -1;
};
