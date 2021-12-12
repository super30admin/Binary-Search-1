/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
/**
 Time complexity: O(logn)
 S:C O(1)
 Approach: here to find out the low and high boundries for binary search we are updating the gap between low and high everytime by 2.
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        while(reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}