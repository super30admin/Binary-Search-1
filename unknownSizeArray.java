/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time: O(Log n)(n = target)
//Space = O(1)
 
class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return 0;
        int lo = 0 ; int hi = 1;
        // increment right at speed of 2x until it becomes greater then target
        while(reader.get(hi)<target){
            lo = hi;
            hi = hi *2;
        }

        //binary searching
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            int cur = reader.get(mid);
            if(cur == target) return mid;
            if(cur>target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
            }

        
        return -1;
        
    }
}