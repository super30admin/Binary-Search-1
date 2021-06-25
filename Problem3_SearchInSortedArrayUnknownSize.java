/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
// Time Complexity : o(logn)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int search(ArrayReader reader, int target) {
         if (reader == null) {
            return 0;
        }
        int low=0;
        int high=1;
        // iterate reassign low and high till high less than target.
        // suppose 1 < 9(target) we will ignore all elemets less than 1 and start low from 2.
        while(reader.get(high)<target)
        {
            low=high;
            high=high*2;
        }
        return  binarySearch(reader, target, low, high);
    }
    
    private int binarySearch(ArrayReader reader,int target,int left,int right)
    {
        while (left <= right) 
        {
          int mid=left+(right-left)/2;
            if (reader.get(mid) > target) {
                right = mid-1;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}