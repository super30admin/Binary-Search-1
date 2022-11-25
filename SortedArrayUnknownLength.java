/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        while(reader.get(high) < target){
            low = high;
            high = 2*high;
        }
        
        // Binary Search
        
        while(low <= high){
            int mid = low + (high - low)/2;
             
        if(reader.get(mid) == target) return mid;
            
            if(reader.get(mid) > target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}

// Time Complexity : O(logn + logk) = O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//The given array is with size unknown where the array will be sorted for sure. So, In a Bruteforce we can find our target index with O(n) time complexity searching in a linear. 
// Second approach is taking high as Infinty and keep on doing Binary Search. In this approach to find the range we need to do many Iterations. Where our logn will be very high.
// Third Approach is taking low as 0 and high as 1. Multiplying high with 2 till we find the range. Here we are Increasing the search speed by half. TC for getting range is O(logk) after getting range TC for Binary Search is O(logn). We are balancing both here. TC will be O(logn + logk). We are multiplying with only 2 beacause if we multipy with 10 or 20 we get a big range. we need to balance logn and logk.