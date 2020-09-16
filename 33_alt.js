// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
Algorithm :
Binary Search.

The rotated array has to fall into 2 categories: smallest on the left side or right side:
4, 5, 6, 7 | 8, 1, 2, 3
7, 8, 1, 2 | 3, 4, 5, 6

Compare:
If nums[head] < nums[mid], first case.
If nums[head] > nums[mid], second case.
So check when target falls onto left side : tail = mid -1
Else, it must be on right side :  head = mid+1

**/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    //Blind Line
    if (nums.length === 0) return -1;
    
    var index = -1, head = 0, tail = nums.length - 1, mid;
    
    while (head <= tail) {
        mid = Math.floor((head + tail) / 2); // find the mid point
        if (nums[mid] === target) {
            index = mid;
            break;
        } else 
            if ((nums[head] <= target && target < nums[mid]) || //when target lies between head and mid
                (nums[head] > nums[mid] && 
                 (nums[head] <= target || target < nums[mid]))) { //target lies between head mid but this condition is when head > mid due to rotation
                tail = mid - 1;
            } 
        else {
            head = mid + 1;
        }
    }
    
    return index;

};