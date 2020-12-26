import java.util.Arrays;
/*
https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
Search in Infinite sorted array:
Given an integer array sorted in ascending order, write a function to search target in nums.
If target exists, then return its index, otherwise return -1. However, the array size is unknown to you.
You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.
*/

// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No
public class Problem3 {
    int arr[];

    public binarySearch(int t[]) {
        arr = Arrays.copyOf(t, t.length);
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;

        return arr[index];
    }

    public int search(int target) {
        int low = 0;
        int high = 1;

        while (get(high) < target) {
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = get(mid);

            if (value == target) {
                return mid;
            }

            if (value == Integer.MAX_VALUE) {
                high = mid - 1;
            } else if (value > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 10, 20, 40, 50 };
        Problem3 prob = new Problem3(arr);

        System.out.println(Arrays.toString(arr));

        for (int element : new int[] { -20, 1, 40, 50, 200 }) {
            int customBSIndex = prob.search(element);
            int StandardBSIndex = Arrays.binarySearch(prob.arr, element);
            boolean testCasePassed = (customBSIndex < 0 && StandardBSIndex < 0) || (StandardBSIndex == customBSIndex);
            System.out.println("--------------------------");
            System.out.println("Searching for element :\t" + element);
            System.out.println("Element found at index :\t" + customBSIndex);
            System.out.println("Test Passed :\t" + testCasePassed);
            System.out.println("--------------------------");
        }

    }
}