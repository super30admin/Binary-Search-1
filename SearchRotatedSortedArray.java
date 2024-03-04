// Time Complexity : O(log n), because of binary search
// Space Complexity : O(1), no extra space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : na


// Your code here along with comments explaining your approach in three sentences only

public class SearchRotatedSortedArray {

    public int search(int[] nums, int target) {

        // null checks
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length -1;
        int mid;

        while (high >= low) {
            mid = (low+high)/2;
            // check if targed is at mid
            if(nums[mid] == target){
                return mid;
            }

            // check if array is left sorted, if yes then nums[mid] <= nums[high]
            if (nums[low] <= nums[mid]){
                // great, array is left sorted. Now find if the target element is between mid and low
                if(nums[low] <= target && target < nums[mid]){
                    high = mid-1; // shift high, so we can search in left half
                } else {
                    low = mid + 1; // shift low so we can search in right half
                }
            }
            // check if array is right sorted
            if(nums[mid] <= nums[high]){
                // great, array is right osrted. Now find if the target is between mid and high
                if(nums[mid] < target && nums[high] >= target){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1; // not found
    }
}