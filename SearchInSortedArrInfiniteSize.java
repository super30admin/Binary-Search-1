//Exercise_7 : Search in a Sorted Array of Unknown Size
// Time Complexity : O(log(t)), here t is the target's value index because here elements are traversed for building array window until the target element index is found.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach
/**** Steps ****/
/*
  1) First just find the start and end until target value comes under the array window
  2) Once start and end are finalised, just implement binary search. 
*/

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution7 {
    public int search(ArrayReader reader, int target) {
        
        int start = 0;
        int end   = 1;
        
        while(target>reader.get(end)){
            start = end;
            end   = 2 * end;
        }
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(target==reader.get(mid)){
                return mid;
            }else if(target<reader.get(mid)){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return -1;
    }
}