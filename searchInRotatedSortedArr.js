// Time Complexity : O(n log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding a proper algorithm was really hard

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    if(nums[0] === target) return 0;
    if(nums[nums.length - 1] === target) return nums.length - 1;
    if(nums.length === 0) return -1;
    
    let left = 0;
    let right = nums.length - 1;
    let mid = Math.floor(right / 2);
    while(left < right) {
        if(nums[mid] > nums[right]) left = mid + 1;
        else right = mid
        mid = Math.floor((right + left)/2);
    }
    if(nums[right] === target) return right;
    else if(target > nums[right] && target < nums[nums.length - 1]) {
        left = right;
        right = nums.length - 1;
    }
    else {
        left = 0;
        right = right - 1;
    }
    while(left <= right) {
        mid = Math.floor((right + left)/2);
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) {
            right = mid - 1;
        }
        else {
            left = mid + 1;
        }
    }
    return -1;
};