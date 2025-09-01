// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : I don't know, I guess I'll have to buy leetcode premium at some point
// Any problem you faced while coding this : No
class Solution {
    public static int infiniteArray(int[] nums, int target) {
        int start = 0;
        int end = 1;

        while (target > nums[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) *2;

            start = newStart;
        }
        return binarySearch(nums, target, start, end);
    }

    static int binarySearch(int arr[], int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}