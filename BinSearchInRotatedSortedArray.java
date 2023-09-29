class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        int n = nums.length;
        int pivot = -1;
        int m = (l + h) / 2;

        while (l < h) {
            m = (l + h) / 2;
            if (nums[m] > nums[h]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        pivot = l;

        if (nums[pivot] == target)
            return pivot;

        l = 0;
        h = nums.length - 1;

        if (target <= nums[h]) {
            l = pivot + 1;
        } else {
            h = pivot - 1;
        }

        while (l <= h) {
            m = (l + h) / 2;
            if (nums[m] == target)
                return m;

            if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;

    }
}