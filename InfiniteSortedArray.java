/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time Complexity : O(log n) for reducing search space by half
// Space Complexity :O(1) -> only pointers are used for left, right, mid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class InfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
       
        int left=0;  // assign left to 0
        int right=1; // assign right to 1
        
        
        
        while(reader.get(right)<target){ // check until u reach a point where right pointer will be less than target

            left=right;                   // which makes it a finite space. Keep doubling right pointer to
            right=right*2;                  // make it finite
        }
        
        while(left<=right){                 // start binary search as now the space is finite
        int mid=left+(right-left)/2;        // find mid element
        
        if(reader.get(mid)==target) return mid;     // if target is mid then return mid
        
        if(reader.get(mid)>target)     // if mid greater than target move high pointer to mid-1 (left side)
            
            right=mid-1;
            
            else
                left=mid+1;         // else move low pointer to mid+1 ( right side)
            
            }
          
        return -1;  // default value if no match
    }
}