/**
 * This is a commonly recurring pattern where sorted order implies binary search
 * But here the length of the array is unknown, so starting from initial index 0 and 1,
 * we make sure that we are not out of bounds, and whether the target lies in this range.
 * If yes, use binarySearch for lookup in O(lg n) time
 * Otherwise, set low to high and double high and repeat until we find or exhaust the search space;
 * 
 * Space Complexity: O(1)
 * Time Complexity: O(log n)
 */
class SearchUnknownLengthSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while (true) {
            if (reader.get(low) == 2147483647) {
                return -1;
            }
            if (reader.get(low) <= target && target <= reader.get(high)) {
                // within range, binary search
                return binarySearch(reader, low, high, target);
            }
            low = high + 1;
            high = 2 * high;
        }
    }

    private int binarySearch(ArrayReader reader, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < reader.get(mid)) {
                high = mid - 1;
            } else if (target == reader.get(mid)) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
