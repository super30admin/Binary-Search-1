// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


//Check for target based on which side of the array is sorted. 

class Solution {
    public int search(int[] nums, int target) {
        int low, mid, high;
        low = 0;
        high = nums.length - 1;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) { // found target in mid
                return mid;
            } else if ( nums[low] <= nums[mid]) { //left side is sorted
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;//target is in left side
                } else {
                    low = mid + 1;//target is in right side
                }
            } else {//right side is sorted
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;//target is in right side
                } else {
                    high = mid - 1;//target is in left side
                }
            }

        }
        return -1;//not found
    }
}
