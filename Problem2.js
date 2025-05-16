// ## Problem2 
// Search in a Rotated Sorted Array (https://leetcode.com/problems/search-in-rotated-sorted-array/)

// Time Complexity : O(Log (N))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no, this one was very trivial and easy

var search = function(nums, target) {
    //set left and right pointer
    let left = 0
    let right = nums.length-1
    //use Binary Search
    while(left<=right){
        //find mid
        let mid = Math.floor((left+right)/2)
        if(nums[mid]==target) return mid
        if(nums[left]<= nums[mid]){
            //this half is sorted, now we can check if our target fits here
            if(nums[left]<= target && target <= nums[mid]){
                //forget the right subarray
                right = mid-1
            }
            else{
            //if target not in this half, then it might be in the other half.
                left = mid+1
            }
        }
        else{
            if(nums[mid]<=target && target<=nums[right]){
            //this half is sorted, now we can check if our target fits here
            left = mid+1
            }
            else{
                right = mid-1
            }
        }
    }
    return -1
};
