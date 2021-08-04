// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0, high = nums.length-1, mid;
        while(low <= high) {
            mid = low + (high - low)/2;
            if(target == nums[mid])
                return mid;
            //left side is sorted 
            if(nums[low] <= nums[mid]) {
                //target is in the sorted side (left)
                if(nums[low] <= target && nums[mid] > target)
                    high = mid - 1;
                //target is in the unsorted side (right)
                else
                    low = mid + 1;
            }  
            //right side is sorted array
            if(nums[mid] <= nums[high]) {
                //target is in the sorted side (right)
                if(nums[mid] < target && target <= nums[high])
                    low = mid + 1;
                //target is in the unsorted side (right)
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}


