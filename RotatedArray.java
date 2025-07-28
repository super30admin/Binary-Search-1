// I used modified binary search to find the target in a rotated sorted array.
// By checking which half is sorted, I narrowed down the search space efficiently.
// This avoids linear scan and works in logarithmic time even after rotation.

// Time Complexity : O(log n) — Binary search halves the space each time.
// Space Complexity : O(1) — No extra space used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to be careful about handling sorted vs unsorted halves correctly.

// Your code here along with comments explaining your approach

import java.util.*;

public class RotatedArray {

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        // Standard binary search with rotation awareness
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Found target
            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[low] <= nums[mid]) {
                // If target lies in left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Else right half must be sorted
            else {
                // If target lies in right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}
