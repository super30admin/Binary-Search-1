/***
 Problem 1: Search in a Rotated Sorted Array https://leetcode.com/problems/search-in-rotated-sorted-array/
 Time Complexity : O(n)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 ***/

public class Problem_1 {
    public int search(int[] arr, int target) {

        //null check
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[low] <= arr[mid]) {
                //left side is sorted
                if (arr[low] <= target && arr[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                //right sorted
                if (arr[mid] < target && arr[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}


