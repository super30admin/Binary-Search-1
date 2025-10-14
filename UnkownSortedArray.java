class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        // Expand the search window exponentially
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        // Binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = reader.get(mid);

            if (val == target) {
                return mid; // ✅ found
            } else if (val > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; // not found
    }
}
