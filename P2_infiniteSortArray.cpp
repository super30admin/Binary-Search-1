//time complexity: O(log n), binary search
//space compexity: O(1), constant space used
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


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
        int low=0, high=1;
        /* intially get valid range by doubling high index */
        getRange(reader, low, high, target);
        /* run binary search over found range*/
        return binarySearch(reader, low, high, target);
        
    }
private:
    void getRange(const ArrayReader& reader, int& low, int&high, int target) {
        while(target > reader.get(high)){
            low = high;
            high = 2*high;
        }
    }
    
    int binarySearch(const ArrayReader& reader, int& low, int&high, int target) {
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target == reader.get(mid)){
                return mid;
            } else if(target < reader.get(mid)){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    
    
};
