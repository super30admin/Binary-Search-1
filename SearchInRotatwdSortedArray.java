

class SearchInRotatwdSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // If the target lies in this range: nums[lo]≤target<nums[mid]
            if (nums[mid] >= nums[lo]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            // If the target lies in this range: nums[mid]<target≤nums[hi]
            else {
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatwdSortedArray sol = new SearchInRotatwdSortedArray();

        int[] nums1 = {0, 1, 2, 3, 4, 5, 6, 7, 8};  // normal sorted
        int[] nums2 = {9, 0, 1, 2, 3, 4, 5, 6, 7, 8}; // rotated sorted

        int target1 = 7;
        int result1 = sol.search(nums1, target1);
        System.out.println("Index of " + target1 + " in nums1: " + result1); // Expected: 7

        int result2 = sol.search(nums2, target1);
        System.out.println("Index of " + target1 + " in nums2: " + result2); // Expected: 9
    }
}
