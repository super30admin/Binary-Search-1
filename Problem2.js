// Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)
// accepted in LeetCode
// tc is O(log n) and sc is O(1)

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {

    let left =0;
    let right = nums.length-1;
    
    while(left<= right){
        let mid = Math.floor(left+(right-left)/2);
        if(nums[mid] == target) return mid;

        if(nums[left]<= nums[mid]){
              if(nums[left] <= target && target<= nums[mid]) right = mid-1;
            else left = mid+1;
        }
        else{
             if(nums[mid] <= target && target <= nums[right]) left = mid+1;
            else right = mid-1;
        }
    }
    
    return -1;
};