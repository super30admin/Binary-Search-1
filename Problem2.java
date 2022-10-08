// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class Problem2 {
    public static void main(String[] args) {
        int[] matrix = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 3;
        System.out.println(search(matrix, target));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                // LHS is sorted
                if ((target < nums[mid]) && (target >= nums[start])) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[end] >= nums[mid]) {
                // RHS is sorted
                if ((target > nums[mid]) && (target <= nums[end])) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
