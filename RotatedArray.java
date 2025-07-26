 // Time Complexity : O(log n) — binary search over rotated sorted array
 //Space Complexity : O(1) — constant space
 //Did this code successfully run on Leetcode : Yes
 //Any problem you faced while coding this : No

 // Approach:
 //Perform binary search by determining which half of the array is sorted at each step.
 //Based on the sorted half, decide whether the target lies within that range and adjust start/end pointers accordingly.
 //This leverages the rotated sorted array property to achieve O(log n) performance.

public class RotatedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[mid] >= nums[start]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    // Main method to test edge cases
    public static void main(String[] args) {
        RotatedArray ra = new RotatedArray();

        // Test case 1: target is present
        System.out.println(ra.search(new int[]{4,5,6,7,0,1,2}, 0)); // Output: 4

        // Test case 2: target is not present
        System.out.println(ra.search(new int[]{4,5,6,7,0,1,2}, 3)); // Output: -1

        // Test case 3: single-element array
        System.out.println(ra.search(new int[]{1}, 1)); // Output: 0
        System.out.println(ra.search(new int[]{1}, 0)); // Output: -1

        // Test case 4: array with pivot at end
        System.out.println(ra.search(new int[]{2,3,4,5,6,7,1}, 1)); // Output: 6

        // Test case 5: array with pivot at start
        System.out.println(ra.search(new int[]{6,7,8,1,2,3,4,5}, 8)); // Output: 2
    }
}