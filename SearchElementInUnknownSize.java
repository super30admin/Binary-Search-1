// Time Complexity : O(M + N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only

// This code finds a target in an array of unknown size by first exponentially expanding the search range until the upper bound exceeds the target.
// Once the boundaries are established, it performs a standard Binary Search within that range to locate the specific index.

class SearchElementInUnknownSize {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (reader.get(mid) == target) {
                return mid;
            } else if (target > reader.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}