//Time Complexity O(logn)
//Space Complexity O(1)
class Solution1 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
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
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] matrix = {4, 5, 6, 7, 0, 1, 2};
        Solution1 solution1 = new Solution1();
        int abc = solution1.search(matrix, 4);
        System.out.println("Value find in matrix " + abc);
    }

}