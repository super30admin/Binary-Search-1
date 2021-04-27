// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * The main idea behind this approach is, when we divide the array in the center one half of the array is always sorted.
 * Two things can happen after we divide the array into half.
 *      1. The target element can be present in the sorted part of the array. 
 *         If that's the case then we updated the range pointers to the sorted part of array.
 *      2. The target element can be present in the non-sorted part of the array.
 *         If this happens then we update the range accordingly.
 * We repeat the above process until we reach a point where the range of the search space becomes 1.
 * If we reach the above scenario and don't find the element at the final range, we return -1.
*/
public class SearchRotSortArr {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) { // left half of the array is sorted
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { //right half of the array is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{1}, 0));
        System.out.println(search(new int[]{2, 1}, 1));
        System.out.println(search(new int[]{2, 1}, 2));
        System.out.println(search(new int[]{2, 1}, 0));
    }
}