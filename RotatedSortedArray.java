//time complexity = 0(logn)
//space complexity = 0(1)

public class RotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 5, 6, 7, 8, 9 };

        int target = 3;

        RotatedSortedArray find = new RotatedSortedArray();

        int obj1 = find.search(nums, target);

        System.out.println("find the object" + obj1);

    }

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) {

                if (nums[low] <= target && nums[mid] > target) {

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;

    }

}
