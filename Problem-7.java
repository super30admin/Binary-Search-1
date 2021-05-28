// Time Complexity : O (log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// First we find end index by performing binary search
// Second we perform normal binary search to find target
class Solution {
    public int search(ArrayReader reader, int target) {

        int end = getEndIndex(reader);

        if (end == -1)
            return -1;

        int start = 0;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (reader.get(mid) == target) {
                return mid;
            }

            if (target < reader.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private int getEndIndex(ArrayReader reader) {
        int start = 0;
        int end = 10000;

        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (reader.get(mid) != 2147483647) {
                // touched array find end
                start = mid + 1;
            } else {
                // array out of bounds: go further left side
                end = mid - 1;
            }
        }
        return start - 1;
    }
}
