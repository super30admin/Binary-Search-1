// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
// Approach: Use arrayReader API to fetch element and increase high by 2  for O(logN) complexity

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
        
        int low= 0;
        int high= 1;
        
        while ( target > reader.get(high) ){
            low = high;
            high = 2 * low;
        }
        
        return binarySearch( reader, target , low, high);
    }
    
    //helper function for binary search
    int binarySearch(const ArrayReader& reader, int target , int low, int high){
        
        while ( low <= high){
            
            //cal mid taking care of int overflow
            int mid = low + ( high - low)/2 ;
            
            if ( target == reader.get(mid)){
                return mid;
            }
            
            if ( target < reader.get(mid)){
                 high = mid-1;
            }
            else{
                low = mid +1;
            }
            
        }
        return -1;
        
    }
};