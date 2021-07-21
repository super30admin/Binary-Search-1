// Time Complexity : O(Log2 N). Where N = 10^6.
// Space Complexity : O(1). No extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.


class Solution {
    public int search(ArrayReader reader, int target) {
        // Simple BinarySearch. 
        // Assume the maximum length of array is max that memory can hold
        // I assumed 10^6 elements can be fitted into memory a int[]
        // N continued with BinSearch.. Just extra check as we know reader will return 2^32-1 if index is not present
        // so in that case mid is out of range so update hi = mid -1

        int lo = 0, hi = 100000;
        
        while(lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int midElem = reader.get(mid);
            if(midElem == target)
            {
                return mid;
            }
            else if(midElem == Integer.MAX_VALUE || midElem > target)
            {
                hi = mid - 1;
            }
            else
            {
                lo = mid + 1;
            }
        }
        
        return -1;
    }
}