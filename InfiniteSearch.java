/**
Time Complexity : O(logn)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class InfiniteSearch {
    /**
    Approach:
    - This function is to determine the upper bound for the array.
    - Loop through the array till we don't hit the Integer.MAX_VALUE
    */
    public int search(ArrayReader reader, int target) {
        int high = 1;
        while(reader.get(high) != Integer.MAX_VALUE) {
            high = high * 2;
        }
        return binarySearch(reader, target, 0, high);
    }
    
    public int binarySearch(ArrayReader reader, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
