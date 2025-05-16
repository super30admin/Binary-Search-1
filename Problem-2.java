// Time complexity -  O(log n)
// Space complexity - O(1)
// Did you face any issues - No
// Executed on leetcode - Yes

// The basic result of binary search is to search in 1/2 time, every time we are rejected 1/2 part of array.
// Since, atleast one part of the array will be sorted, we are checking if target is present in it.
// if yes rejecting the other half of the array else viceversa.

class Solution {
    public int search(int[] nums, int target) {
        int low =0, high = nums.length-1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                return mid;
            } 
            if(nums[low] <= nums[mid]) {
                //left sorted
                if(nums[low]<=target && nums[mid]> target) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                //right sorted
                if(target > nums[mid] && target <=nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
