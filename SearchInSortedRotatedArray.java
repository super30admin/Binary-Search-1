
// Time Complexity : Log(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearchInSortedRotatedArray {
    public static int search(int[] nums, int target) {
        int mid;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] >= target)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (nums[right] >= target && nums[mid] <= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = { 4, 5, 6, 7, 0, 1, 2 };
        int target_1 = 0;
        int result_1 = search(a, target_1);
        System.out.println("Target '" + target_1 + "'' found in Array a at index : " + result_1);

        int target_2 = 3;
        int result_2 = search(a, target_2);
        System.out.println("Target '" + target_2 + " found in Array a at index : " + result_2);
    }
}
