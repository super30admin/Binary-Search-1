// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RotatedSortedArraySearchSolution {
    public int search(int[] nums, int target) {
        //Initilize low and high
        int low = 0; 
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //Check if mid is target
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[low]) { //Check whic half is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
