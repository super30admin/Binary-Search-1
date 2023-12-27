//702. Search in a Sorted Array of Unknown Size


/*
Binary search implementation

Time complexity: O(Log N)
Space complexity: O(1)

*/

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
    int search(const ArrayReader& reader, int target) {

        int low = 0;
        int high = 1;
        while(reader.get(high) < target){
            low = high;
            high = high * 2;
        }

        while(low <= high){
            int mid = low+(high-low)/2;

            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target) high = mid - 1;
            else low = mid +1;
        }

        return -1;
        
    }
};