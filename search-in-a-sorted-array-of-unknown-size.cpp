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
        if(reader.get(0)==target)return 0;
        if(reader.get(1)==target)return 1;

        int low =0, high = 1;
        while(low<=high){
            if(target > reader.get(high)){
                low = high;
                high *= 2;
            }
            else if(target<=reader.get(high)){
                int mid = low+(high-low)/2;
                if(reader.get(mid)==target)return mid;
                else if(target > reader.get(mid))low=mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
};
