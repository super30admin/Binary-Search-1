/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
class ArrayReader {
    public int search(ArrayReader reader, int target) {
        //get start arr[0], end arr[9999] if not there
        //find mid
        //if arr[mid]==target return
        //else target <arr[mid] end = mid-1
        //else start = mid+1
        int start = 0;
        int end = 9999;

        if(reader.get(start)==target)
        {
            return start;
        }
        if(reader.get(end)==target)
        {
            return end;
        }

        while(start<=end){
            int mid = start + ((end - start)/2);
            int midVal = reader.get(mid);
            if(midVal==target)
            {
                return mid;
            }
            else if(midVal < target)
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return -1;
    }
}