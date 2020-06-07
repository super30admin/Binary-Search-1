// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
        int start =0;
        int end =1;
        
        if(reader.get(start)==target) return start;
        if(reader.get(end)==target) return end;
        
        //defining the boundaries
        while(start<=end){
            
            if(reader.get(start)==target) return end; 
            if(reader.get(end)==target) return end;
            
            if(reader.get(end)>target){
                break;
            }
            
            start = end;
            end = end*2;
        }
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(reader.get(mid)==target) return mid;
            
            if(reader.get(mid)>target)
                end = mid-1;
            
            else
                start = mid+1;
        }
        
        return -1;
        
    }
};
