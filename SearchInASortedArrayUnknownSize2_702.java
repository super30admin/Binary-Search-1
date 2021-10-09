// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SearchInASortedArrayUnknownSize2_702 {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        while(reader.get(high) < target && reader.get(high) != Integer.MAX_VALUE ){
            low = high;
            high = high *2;
        }
        
        return binarySearch(reader, low, high, target);
    }
    
    public int binarySearch(ArrayReader reader, int low, int high, int target){
        
        while(low <= high){
            
            
            int mid = low + ( high- low) /2;
            
            if(reader.get(mid)==target){
                return mid;
            } else if (reader.get(mid) < target){
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        
        return -1;
    }
}