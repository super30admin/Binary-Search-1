// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes: Iterate over to find values of low and high pointer increasing by 2^n times, to find the target using Binary Search in the sub-array starting from low to high.

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

public class SearchInInfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        
        int low = 0;
        int high = 1;
        
        while(reader.get(high) < target){
            low = high;
            high = high * 2;
        }
        
        if(reader.get(low) == target){
            return low;
        } else if( reader.get(high) == target){
            return high;
        } else {
            while(low <= high){
                int mid = low + (high - low)/2;
                
                if(target == reader.get(mid) ){
                    return mid;
                } else if (reader.get(mid) > target){
                    high = mid - 1;
                } else{
                    low = mid + 1;
                }
            }
        }
        
        return -1;
    }   
}
