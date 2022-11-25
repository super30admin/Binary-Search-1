// Time Complexity : O( logn), n is the length of the array- the size decreases by half
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int search(int[] nums, int target) {

        // check base cases
        if (nums.length == 0 || nums == null)
            return -1;

        int start = 0;
        int end = nums.length - 1;

        // run while the start end don't cross each other, binary search
        // since the array is rotated, we need to separately calculate the start and end
        // index if the cndition statisfies
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;

            // if the 1st half is the rotated array,then compare the target value and
            // decrease size by half
            // check which side is sorted by below condition
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // if the 2nd half is increaring order the below runs. right sorted
            else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}
