/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    // rotated => 
    // binary search wont work - since its rotated
    // for sure one half will be sorted - either left or right
    // check if right or left sorted array
    // even if rotated right or left either way logic remains same


    let low = 0;
    let high = nums.length-1;
    while(low<=high) {
        let mid = Math.floor((low+high)/2);
        if(nums[mid] === target) {
            // can be the target
            return mid
        } else if (nums[mid] >= nums[low] ) {
            // first find if its left sorted 
            //left sorted array
            
            // now find if target is within the range of left sorted arra
            if(target >= nums[low] && target< nums[mid]) {
                // its in the range and it follows usual binary search flow
                high = mid - 1;
            } else {
                // here means what???
                low = mid+1;

            }
        } else  {
            // right sorted array
            
            //now find i    f target is within the range of right sorted array;
            if(target > nums[mid] && target <= nums[high]) {
                // its in the range and follows usual binary search flow
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
    return -1;

};