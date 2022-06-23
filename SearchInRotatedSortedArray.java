/*
 * Time Complexity : O(Log N)
 * Space Complexity: O(1)
 * */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int numsLength = nums.length;
        int low = 0;
        int high = numsLength - 1;

        while (low <= high) {
            //Calculating middle element
            int middle = low + (high - low) / 2; // To avoid integer overflow condition
            // Checking whether the element present at middle is equal to target
            if (nums[middle] == target) {
                return middle;
            } // left part is sorted
            else if (nums[low] <= nums[middle]) {
                // Checking target lies in left part
                if (target >= nums[low] && target < nums[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            } else {
                // Checking target is lying in the right half
                if (target > nums[middle] && target <= nums[high]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }
        return -1;
    }
}
