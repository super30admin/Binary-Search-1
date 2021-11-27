// Time Complexity : O(logn)
// Space Complexity : O(1)

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class searchInfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int i = 0;

        // logarithmic complexity, sorted array gives a hint towards binary search.
        // in case of binary search we either divide by 2 or multiple it by 2, in either
        // case we will acheive logarithmic complexity. Since we do not know the length
        // we multiply the right index by 2 everytime we do not find the target.

        int left = 0;
        int right = 1;

        while (reader.get(right) <= target) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
