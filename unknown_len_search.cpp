//TC: O(log(T)) where T is the length of array we find initially
//SC: O(1)

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
        
        //first find the upper bound. Start with 1 and increase till upper bound
        //becomes greater than the target
        
        int lo = 0;
        int hi = 1;
        
        while(reader.get(hi) < target ){
            hi = hi*2;
        }
        
        
        while(lo <= hi){
            
            int mid = lo + (hi - lo)/2;
            
            
            if(target == reader.get(mid))
                return mid;
            
            if(target < reader.get(mid))
                hi = mid-1;
            
            if(target > reader.get(mid))
                lo = mid+1; 
            
        }
        
        return -1;
        
        
    }
};