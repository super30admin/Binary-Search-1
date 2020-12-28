// Time Complexity :O(log k + log m) highest of log k or log m
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


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
        int low=0; int high=1;
        while(reader.get(high)<INT_MAX && reader.get(high)<target){
            low=high;
            high=2*high;
        }
        return binarySearch(reader,target,low,high);
    }
    int binarySearch(ArrayReader reader,int target, int low, int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(reader.get(mid)==target) return mid;
            else if(reader.get(mid)>target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
};