// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// 1: For a rotated sorted array, at least either left or right half of the array will be sorted
// 2: We use this property to determine which pointers to move to find the target
// 3: For a left sorted array, we move the high pointer closer, for a right sorted array, we move the low pointer closer
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + ((high-low)/2);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                // left sorted
                if(nums[low] <= target && nums[mid] > target){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                // right sorted
                if(nums[high] >= target && nums[mid] < target){
                    low = mid + 1;
                }
                else
                    high = mid - 1;
            }
        };
        return -1;
    }
}