// Time Complexity: O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class SearchInInfiniteArray {
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = Integer.MAX_VALUE - 1;
        
        while(start <= end) {
           
            int mid = (start + end) /2;
            
            if(reader.get(mid) == target) {
                return mid;
            } 
            else if(reader.get(mid) > target) {
                end = mid - 1;
            } else if(reader.get(mid) < target) {
                start = mid + 1;
            }
            
        }
        return -1;
    }
}
