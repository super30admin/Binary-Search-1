//Timecomplexity : O(logn)
//spacecomplexity : O(1)
public class searchRotatedSortedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // calculate mid
            int mid = left + (right - left) / 2;

            // if target is element at mid then return mid
            if (target == nums[mid]) {
                return mid;

                // if element at mid is greater than element at left, means first part is
                // //sorted
            } else if (nums[mid] >= nums[left]) {
                // if target is between mid & left, then right becomes mid else left //becomes
                // mid+1
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;
    }

}
