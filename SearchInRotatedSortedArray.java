
public class SearchInRotatedSortedArray {
    /*
     * Time Complexity: O(log(n))
     * Space Complexity: O(1)
     *
     * Search in a rotated sorted array
     *
     * Author: Aditya Mulik
     */

    public static int search(int[] nums, int target) {

        // base case
        if (nums.length == 0) return -1;

        // Get the low, high and mid of nums array
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (nums[mid] == target) {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        int solution = search(nums, target);
        System.out.println(solution);
    }
}
