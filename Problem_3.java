/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        /*
         * Time Complexity - O(log 10^4), problem states that array size at max
         * will be 10^4
         * Space Complexity - O(1)
         */
        int low = 0, high = 10000;
        while (low <= high) {
            int mid = (low+high)/2;
            if (reader.get(mid) == target) 
                return mid;
            else if (reader.get(mid) > target) {
                high = mid-1;
            } 
            else 
                low = mid+1;
        }
        return -1;
    }
}