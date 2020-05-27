class Solution {
    
    // Time Complexity : O(log n) where n is the size of the input array
    // Space Complexity : O(1) - 
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Corner Cases 
    
    //Binary Search 
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while( l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            //check if there is rotation based on start value and end value and update l and r
            if (nums[mid] >= nums[l]) {
                if(target >= nums[l] && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            else {
                if(target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
}
