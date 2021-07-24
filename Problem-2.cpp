//Time Complexity = O(log n)
//Space Complexity = O(1)

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ArrayReader {
 *   public:
 *     int get(int index);
 * };
 */

class Solution {
public:
    int BinarySearch(ArrayReader reader, int l, int h, int target)
    {
        int low = l, high = h, mid;
        while(low <= high)
        {
            mid = low + (high - low)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) < target)
                low = mid + 1;
            else
                high = mid -1;
        }
        return -1;
    }
    int search(const ArrayReader& reader, int target) {
        int low = 0, high = 1;
        while(reader.get(high) < target)
        {
            low = high;
            high = 2 * low;
        }
        return BinarySearch(reader, low, high, target);
    }
};
