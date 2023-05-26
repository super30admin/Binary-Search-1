// Time Complexity :O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No -->

// Perform binary search, since it is sorted and rotated, one of the two subarray left-to-mid or mid-to-right will be already sorted, this would reduce the search space by half. Next, we check if the target is within the sorted array. It it is not then move the left/right accordingly  

public class Problem2 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) { // 4 5 6 7 0 1 2
                if (target >= nums[left] && target < nums[mid]) { // say 5
                    right = mid - 1;
                } else { // 0 or 1
                    left = mid + 1;
                }
            } else { // 6 7 0 1 2 4 5
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem2 s = new Problem2();
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(" Target found at: " + s.search(arr, 7));
    }
}
