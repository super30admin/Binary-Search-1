// Time Complexity : log n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Consider the entire array as the search space, with low at 0 index and high at n-1 index, mid is calculated using binary search, verify if
// which half is sorted, move the low to mid+1 if right sorted or high to mid-1 if left sorted and continue to search for the key by reducing
// the search space by half at each iteration.


class Solution {
    public int search(int[] nums, int target) {
        // null condition check
        if(nums==null || nums.length==0) return -1;

        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low+(high-low)/2; // to avoid integer overflow
            if(nums[mid]==target) { 
                return mid;
            } else if(nums[low]<=nums[mid]){
                // left sorted
                if(nums[low]<=target && target<nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {  // right sorted
                if(target> nums[mid] && target<= nums[high]){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}