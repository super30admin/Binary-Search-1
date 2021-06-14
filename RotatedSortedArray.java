/*
    Time Complexity
    O(log(n))
    Space Complexity
    O(1)
*/

class RotatedSortedArray {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = (high - low) + low / 2;

            if (nums[mid] == target) {
                return mid;

            } else if (nums[low] <= nums[mid]) {

                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {

                if (nums[high] >= target && nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return -1;

    }

}