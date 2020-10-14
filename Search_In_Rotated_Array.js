// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Challengin part was figuring out how to get the Big numbers. Google helped me out much. 
//                                           But in the end I was able to understand.

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {

    const len = nums.length;
    
        if(len === 0){
            return -1
        }
    
        let low = 0, high = len -1;
        let first = nums[0];
        while(low <= high){ 
            let mid = low + Math.floor((high - low) / 2);
            let value = nums[mid];
            if(value === target){
                return mid
            }
            
            //finding midpoint of two sorted sub arrays, compare mid element to first element
            //If target is not in big, then go to small 

            const midInBig = first <= value;
            const targetInMid = first <= target;
    
            if(midInBig === targetInMid){
    
                if(value > target){
                    high = mid -1;
                }
                else {
                    low = mid +1;
                }
            }
            else {
                if(targetInMid) {
                    high = mid -1;
                }
                else {
                    low = mid + 1
                }
            }
        }
    
        return -1;
    
    }


    
