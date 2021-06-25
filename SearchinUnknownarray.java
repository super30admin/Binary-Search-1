/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
 // Time Complexity :O(log N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        if(reader.get(low)==target) return low;
        while(reader.get(high)<=target)
        {
            low = high;
            high = high + 2;
        }
      return  Binarysearch(reader,target,low,high);
    }

    public int Binarysearch(ArrayReader reader, int target , int low, int high)
    {
        
        while(low<=high)
        {
        int mid = low + (high-low)/2;
        if(reader.get(mid) == target) 
            return mid;
        if(reader.get(mid)>target)
        {
            high = mid -1;
        }
        else
        {
            low = mid + 1;
        }
        }
        return -1;
    }
}