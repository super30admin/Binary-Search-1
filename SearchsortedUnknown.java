/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int search(ArrayReader reader, int target) {
        int low=0;
        int high =1;
        //for empty array return -1
        if(reader.get(low) == Integer.MAX_VALUE) return -1;
        
        while(reader.get(high)<target){
            low=high;
            high= high *2;//double the high
        }
        return binarySearch(reader,target,low,high);//do binary search
    }
    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid) ==target){
                return mid;
            }
            else if(target>reader.get(mid)){
                low=mid+1;
            }
            else high=mid-1;
        }
        return -1;
    }
    
}