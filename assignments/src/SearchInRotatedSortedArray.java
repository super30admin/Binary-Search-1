public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left <= right) {
            int pivot = left + (right - left) / 2;

            if (nums[pivot] == target) return pivot;
            else if (nums[left] <= nums[pivot]) {
                // go left
                if (nums[left] <= target && target < nums[pivot]) right = pivot - 1;
                else left = pivot + 1;
            }
            else {
                // go right
                if (nums[right] >= target && target > nums[pivot]) left = pivot +1;
                else right = pivot - 1;
            }
        }
        return -1;
    }
}
