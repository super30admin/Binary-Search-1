
// Time Complexity :O(logn)+O(logm)where n is total no of elements and m is range found
// Space Complexity :constant
// Did this code successfully run on Leetcode :NA
// Any problem you faced while coding this :No
import java.io.*;

class infiniteArray {
    public static void main(String[] args) {
        // sample input to test our approach
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int element = 5;
        int idx = modifiedBinarySearch(arr1, element);
        System.out.println("Idx::" + idx);
    }

    public static int binarySearch(int[] nums, int target, int low, int high) {
        int start = low;
        int end = high;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
    }

    private static int modifiedBinarySearch(int[] nums, int target) {// start start pointer with 0 and end with 1
        // increase start to end+! and end=end*2 until target falls between start and
        // end
        int start = 0;
        int end = 1;
        while (nums[end] < target) {
            start = end + 1;
            end = end * 2;
        } // once we get the range, do binary search
        return binarySearch(nums, target, start, end);
    }
}