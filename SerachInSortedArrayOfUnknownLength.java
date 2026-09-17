

/**
First find the range in which target lies and then apply binary search on that range.
// Time Complexity :log (m+n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
 */
class SerachInSortedArrayOfUnknownLength {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right = right * 2;

        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (target < reader.get(mid)) {
                right = mid - 1;

            } else {
                left = mid + 1;

            }
        }

        return -1;
    }
}