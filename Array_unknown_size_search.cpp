// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No :)

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
        int l = 0;
        int r = 1;
        int m;
        while(l<=r){
            m = l + (r-l)/2;
            if(reader.get(m)==target){
                return m;
            }
            else if(target>reader.get(m)){
                r = r*2;
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return -1;
    }
};
