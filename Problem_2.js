// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// ## Problem1 
// Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
    // Set the low and high index to start and end of array
    let low = 0;
    let high = nums.length - 1;
    while (low <= high) {
        // Find mid index
        let mid = Math.floor(low + ((high - low) / 2));
        // If target found, return
        if (nums[mid] === target) {
            return mid;
        }
        // Check if right half is sorted
        if (nums[mid] <= nums[high]) {
            // If target is in between mid and end, set low index as mid+1
            if (nums[mid] < target && target <= nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        } else {
            // Left half is sorted
            // If target is in between 0 and mid index, set high index as mid-1
            if (nums[low] <= target && target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
    return -1;
};

let nums = [4, 5, 6, 7, 0, 1, 2];
let target = 0;
console.log(search(nums, target));
