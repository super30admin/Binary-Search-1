/*
Time: O(logN) where N=length of the array
Space: O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class SearchArray {

    public int search(int[] nums, int target) {
        if (nums.length < 1 || nums == null)
            return -1;

        int left = 0;
        int right = nums.length - 1;

        // Find where the start(smallest) element is
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else
                right = mid;

        }

        // Array is now [left,.....start,....right]
        int start = left;
        left = 0;
        right = nums.length - 1;

        // Find on which side the target is located in
        if (target >= nums[start] && target <= nums[right])
            left = start;
        else
            right = start;

        // Binary search on that side
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid])
                return mid;

            else if (target < nums[mid])
                mid = right - 1;

            else
                mid = left + 1;

        }
        return -1;

    }

}
