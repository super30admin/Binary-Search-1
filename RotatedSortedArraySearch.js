/*
* TC: O(log n)
* SC: 0(1)
*
* Approach:
* In a rotated stored array we know that one side of the array is always sorted.
* to find if the left side is sorted
*   we can check if nums[low] <= nums[mid]
* else we can go to the right side and perform binary search
*
* */

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {

  if (!nums) return -1;

  let low = 0 ;
  let high = nums.length - 1;

  while (low <= high) {
    let mid = Math.floor(low + (high - low)/2);

    if (nums[mid] === target) {
      return mid;
    }

    if (nums[low] <= nums[mid]) { // here we do <= in consideration that if there is just a single element in the array
      //left half is sorted
      if (target >= nums[low] && target < nums[mid]) {
        high = mid -1;
      } else {
        low = mid + 1;
      }
    } else {
      if (target > nums[mid] && target <= nums[high]) {
        low = mid + 1;
      } else {
        high = mid -1;
      }
    }
  }
  return -1;

};