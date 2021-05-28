// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No

public class SortedUnknownArrayLen {

    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        while (target > reader.get(right)) {
            left = right;
            right = 2 * right;
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == reader.get(mid)) {
                return mid;
            } else if (target > reader.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
