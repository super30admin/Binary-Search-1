/**

Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists, then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).

You may assume all integers in the array are less than 10000, and if you access the array out of bounds, ArrayReader.get will return 2147483647.

 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
 
 
 /**
 
 
Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : YES
Any problem you faced while coding this : NO


Your code here along with comments explaining your approach

    start with low =0 and high =1;
    keep on doubling the high and setting low to previous high till arr.get(high) > target
    get low and high index, run the binary search on this low and high obtained 
Collabedit: http://collabedit.com/bjkxg

**/

class Solution {

    private final int MULTIPLICATION_FACTOR = 2;
    private final int MAX_LENGTH = 10000;
    private final int NOT_FOUND = -1;
    
    
    
    public int search(ArrayReader reader, int target) {
    
        int low = 0;
        
        int high = 1;
        
        while( reader.get(high) < target) {
            
            
            if (high > MAX_LENGTH) {
                return NOT_FOUND;
            }
            low = high;
            
            high = MULTIPLICATION_FACTOR * high;
            
        }
        
        while ( low <= high ) {
        
            int mid = low + (high-low)/2;
            
            if( reader.get(mid) == target) {
                 return mid;  
            }
            else if( reader.get(mid) > target) {
                high = mid -1;
            }
            else
            {
                low = mid + 1;
            }
        
        }
        
        
        return NOT_FOUND;
        
    }
}