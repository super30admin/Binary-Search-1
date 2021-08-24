// Time Complexity :  O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.

public class rotatedArrSolution {
    public int search(int[] nums, int target) {
        //Binary Search approach
        int left, right, mid;
        left  = 0;
        right = nums.length - 1; 

        // empty input
        if(nums == null || nums.length == 0) return -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            // Sorted left
            else if (nums[left] <= nums[mid]){
                // move left
                if (nums[left] <= target && nums[mid] > target)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // Sorted right
            else
                // move right
                if (nums[mid] < target && nums[right] >= target)
                    left = mid + 1;
                else
                    right = mid - 1;
        }

        // Target not found
        return -1;

        
    }

}