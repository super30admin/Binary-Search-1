//time complexity: O(logn)
//space complaexity : O(1)

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
        int l=0;
        int r=target-reader.get(0);

        if(reader.get(r)==target)
            return r;
        
        while(l<=r)
        {
            int mid=l+(r-l)/2;

            if(target==reader.get(mid))
                return mid;
            else if(target<reader.get(mid))
                r=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
};