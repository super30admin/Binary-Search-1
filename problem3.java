// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

// Time Complexity : log(n) + log(m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : We first narrowed down our search area for binary search and once, we got our low & high, we implemented binary search on it

public class problem3 {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }
        while (low <= high) {
            int mid = low + (high + low) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
