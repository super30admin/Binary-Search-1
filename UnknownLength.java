/**
 * Time complexity O(logn). Space complexity O(1)
 * Keep doubling the high pointer and move the low pointer to high until target is less than
 * high and lower than low pointer. Once the range is fixed, do a binary search in the range
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while (reader.get(high) < target)
        {
            low = high;
            high = high * 2;
        }
        
        return binarySearch(reader, low, high, target);
        
    }
    
    int binarySearch(ArrayReader reader, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low)/2;
            if ( target == reader.get(mid))
            {
                return mid;
            }
            if (target < reader.get(mid))
            {
                high = mid-1;
            }
            if (target > reader.get(mid))
            {
                low = mid +1;
            }
        }
        return -1;
    }
}
