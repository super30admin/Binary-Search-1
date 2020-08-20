/**
 * If we know start and end of an array, finding an element's existence in an array is trivial using Binary Search
 * Since the array is indefinite, we start with low=0 and high=1,
 * we increase high in multiples of 2 and move low to high until the desired subarray in target's range is spotted
 * Once these indexes are found, apply BS on the subarray; pretty sweet!
 */

// Time Complexity: log (p) where p is position of target in array; while we determine low and high
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Don't have premium
// Any problem you faced while coding this : NA
public class InfiniteBinarySearch {
    public static void main(String[] args) {

        // testcase 1
        /* int[] nums = new int[]{0, 99, 255, 349, 350, 440,
                599, 612, 624, 666, 982};
        System.out.println(infiniteBinarySearch(nums, 160));    // Prints -1 */

        // testcase 2
        /* int[] nums = new int[]{0, 99, 255, 349, 350, 440,
                599, 612, 624, 666, 982};
        System.out.println(infiniteBinarySearch(nums, 666));    // Prints 9 */

        // testcase 3
        int[] nums = new int[]{-1, 0, 99, 255, 349, 350, 440,
                599, 612, 624, 666, 982};
        System.out.println(infiniteBinarySearch(nums, 0));    // Prints 1
    }

    public static int infiniteBinarySearch(int[] nums, int target) {

        // Determine low and high
        int low = 0, high = 1;
        while (target > nums[high]) {
            low = high;
            if (high * 2 > nums.length)        // How to better handle when length is unknown?
                high = nums.length - 1;
            else
                high *= 2;
        }

        // Apply binary search using nums, low, high, and target
        if (low > high)
            return -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
