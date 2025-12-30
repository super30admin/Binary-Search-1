/**
 * @param {number[]} nums
 * @return {number}
 * 
 * Intution:
 * 
 * I am using binary search in here.
 * Covered edge case before the while loop.
 * nums[right] < nums[mid] this condition decides to move the pointers
 */
var findMin = function(nums){
    let left = 0, right = nums.length - 1;
    // edge case where the element is not roatated or the element rotated to its original place
    if(nums[left] <= nums[right]) return nums[left];
    while(left <= right){
        const mid = Math.floor((left+ (right-left)/2));
        //  condition to return mid
        if(nums[mid] < nums[mid-1]){
            return nums[mid];
        }else if(nums[right] < nums[mid]){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
    }
    return left;
};