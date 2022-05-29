class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int k = 0;
        while (l < r) {
            int mid = (int) (l + r) / 2;
            if (nums[mid] > nums[l] && nums[mid] > nums[r])
                l = mid;
            else
                r = mid;
        }
        int res = 0;
        if (target <= nums[r] && target >= nums[0])
            res = binarySearch(nums, 0, r, target);
        else
            res = binarySearch(nums, r + 1, nums.length - 1, target);

        return res;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}