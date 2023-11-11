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
        if(reader.get(0)==target) return 0;

        int low=0,high=1;
        while(reader.get(high)<target) {
            low=high;
            high=high*2;
        }

        while(low<=high) {
            int mid=low+((high-low)/2);
            int midVal=reader.get(mid);
            if(midVal==target) return mid;
            else if(midVal>target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
};