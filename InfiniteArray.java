/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */


// Time Complexity : O(log n) Its log to the base 2
// Space Complexity : O[1]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {
        int high = 1;
        int low=0;
        
        while(reader.get(high)<target){
            low = high;
            high = high*2;
            
        }
         return binarySearch( reader, target, low, high);
        
        
    }
    
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(high>=low){
            int mid = low + (high -low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(reader.get(mid)>target){
                high = mid-1;
                
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}