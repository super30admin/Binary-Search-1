// Time Complexity : O(log N) as the search space is halved after every iteration
// Space Complexity : O(N) where n is the number of elements
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;

            // we check the mid element is target
            if (nums[mid] == target)
                return mid;

            // we search which subarray (the left or right subarray) is sorted
            if (nums[mid] >= nums[left]) {
                // we see if the sorted subarray has the element or not.
                if (nums[left] <= target && target <= nums[mid])
                    right = mid - 1;
                else
                    // check the other subarray
                    left = mid + 1;
            } else {
                // we see if the sorted subarray has the element or not.
                if (nums[right] >= target && nums[mid] <= target)
                    left = mid + 1;
                else
                    // check the other subarray
                    right = mid - 1;
            }
        }

        return -1;
    }
}