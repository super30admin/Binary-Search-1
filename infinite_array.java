// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not sure
// Any problem you faced while coding this : No


public class infinite_array {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) return mid;
            if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

