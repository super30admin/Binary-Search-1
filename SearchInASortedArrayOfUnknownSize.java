// Time Complexity : O(logn) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SearchInASortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {
        int lo=0, hi=1;
        
        while(reader.get(hi)<target){
            lo=hi;
            hi=hi*2;
        }
        
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(reader.get(mid)==target) return mid;
            else if(reader.get(mid)>target)hi=mid-1;
            else lo=mid+1;
        }
        
        return -1;
    }
}