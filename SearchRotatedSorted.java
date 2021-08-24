// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null)
            return -1;

        int lower = 0;
        int upper = nums.length - 1;
        int mid = 0;

        while(lower<=upper){
            mid = lower + (upper - lower) / 2;

            if(nums[mid] == target)
                return mid;

            //check of the lower half is sorted, and check if target lies in the range
            //if not sorted, assume that the upper half is sorted
            if(nums[lower] <= nums[mid]){
                if(target >= nums[lower] && target <= nums[mid])
                    upper = mid - 1;
                else
                    lower = mid + 1;
            }
            else{
                //check if target lies in the upper half range
                if(target <= nums[upper] && target >= nums[mid])
                    lower = mid + 1;
                else
                    upper = mid - 1;
            }
        }
        return -1;
    }
}
