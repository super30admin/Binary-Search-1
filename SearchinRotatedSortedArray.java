/*
Approach: In a rotated sorted array one side of the mid will always be sorted! 
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

*/
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            //check which side of the array is sorted

            if(nums[mid] == target)
                return mid;

            //check if left half is sorted
            if(nums[low] <= nums[mid]){
                // condition to validate where to go
                if(nums[low] <= target && nums[mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            //check if right half is sorted
            else{
                if(nums[high] >= target && nums[mid] < target)
                    low = mid + 1;
                else
                    high = mid - 1; 
            }
        }
        return -1;
    }
}