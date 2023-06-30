
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class rotatedSortedArray {
    public int search(int[] nums, int target) {



        if (nums == null || nums.length == 0) return -1;


        int left = 0, right = nums.length - 1;


        while (left < right)
        {
            int midpoint = left + (right - left) / 2;

            if (nums[midpoint] >= nums[left])
            {

                // Left Side is sorted

                if (target <= nums[midpoint] && target >= nums[left])
                    right = midpoint;
                else
                    left = midpoint + 1;
            }

            else
            {
                // Right Side is sorted

                if (target > nums[midpoint] && target <= nums[right])
                    left = midpoint + 1;
                else
                    right = midpoint;
            }
        }


        return nums[left] == target ? left : -1;

    }
}