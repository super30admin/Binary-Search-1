package BinarySearch1;

public class problem6_searchRotatedArray {

    /*
        Time Complexity: O(log n)
     */

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // we have to check which side is sorted.
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[low]) { //if left side is sorted.
                if (nums[mid] > target && nums[low] <= target) high = mid - 1;
                else low = mid + 1;
            } else {
                if (nums[mid] < target && nums[high] >= target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /*
        Sample 1:
            Input: nums = [4,5,6,7,0,1,2], target = 0
            Output: 4

        Sample 2:
            Input: nums = [4,5,6,7,0,1,2], target = 3
            Output: -1
         */
    }
}
