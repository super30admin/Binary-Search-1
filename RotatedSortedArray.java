//time complexity O(log(n))
//space complexity O(1)
class RotatedSortedArray {
    public int search(int[] nums, int target) {

        int low = 0;
        int i = 0;
        int high = nums.length - 1;
        int mid = (high + low) / 2;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;

            } else {
                if (target <= nums[high] && target >= nums[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

        }
        return -1;

    }
}