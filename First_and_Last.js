// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Finding the first occurance of the element was a challenge.
//                                           Find the indexes was easy after that.  




/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    
    const BinarySearch = (low, high, left) => {
         while(low < high){
        let mid = Math.trunc((low + high) / 2);
        if(nums[mid] > target || left && target === nums[mid]) {
            high = mid;
            }
             else {
                 low = mid + 1
             }
        }
        return low
    };
    
    const result = [-1,-1];
    const first = BinarySearch(0,nums.length, true);
    if(result >= nums.length || nums[result] != target){
        return result
    }
    
    result[0] = [first];
    result[1] = BinarySearch(0, nums.length, false) - 1;
    return result;
    
    // let len = nums.length;
    // let low = 0, high = len;
    
    
   
};