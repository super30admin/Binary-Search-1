/**
Problem: Search in an infinite sorted array
https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

Time Complexity : log (n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
*/
class SearchInInfiniteSortedArray {
    public final int outOfBounds = (int)(Math.pow(2, 31) - 1);
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == outOfBounds) {
            return -1;
        }

        int low = 0, high = 1;

        while (reader.get(high) < target) {
            low = high;
            high *= 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) {
                return mid;
            }

            if (target > reader.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}