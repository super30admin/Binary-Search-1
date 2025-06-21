// Time Complexity: O(log n)
// Space Complexity: O(1)

// First find the lastIndex of the array by applying the constraints of max length
// Once we know last index we can apply simple binary search

class Solution {
    public int search(ArrayReader reader, int target) {
        int lastIndex = findLastIndex(reader);

        int low = 0, high = lastIndex;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (target == reader.get(mid)) return mid;

            if (target > reader.get(mid)) {
                low = mid + 1;
            } else if (target < reader.get(mid)) {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int findLastIndex(ArrayReader reader) {
        int low = 0, high = 10000-1;
        while (low<=high) {
            int mid = low + (high-low)/2;

            if (reader.get(mid) == Integer.MAX_VALUE) {
                // last element lies on the left
                high = mid - 1;
            } else {
                // last element lies on the right
                low = mid + 1;
            }

            if (reader.get(low) == Integer.MAX_VALUE)
                return low;
        }
        return -1;
    }
}