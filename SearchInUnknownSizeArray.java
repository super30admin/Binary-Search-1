// Time Complexity : O(logm + logn), m -> time taken to find range, n -> binary search in that range
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

public class SearchInUnknownSizeArray {
    public int search(ArrayReader reader, int target) {
        // lets start by checking the if first element is the target element and ofcourse null checks
        if(reader == null) {
            return -1;
        }

        if(reader.get(0) == target){
            return 0;
        }

        // Idea: find the range using slow and fast pointer, then do a binary search on that part
        // 1. find range
        int low = 0;
        int high = 1;

        while(target > reader.get(high)) {
            // keep moving fast until our high becomes more than target
            // update low to high
            low = high;
            // update high to twice high
            high = 2 * high;
        }

        // now we have pointers, do a binary search
        int tIndex = binarySearch(reader, low, high, target); // tIndex is target index or -1
        return tIndex;
    }

    public int binarySearch(ArrayReader reader, int low, int high, int target){
        if(high < low){
            // if cross over of high and low happens then return -1, not found
            return -1;
        }
        int mid = (low + high)/2;
        if(reader.get(mid) == target){
            return mid;
        }
        if(reader.get(mid) > target) {
            high = mid - 1;
            return binarySearch(reader, low, high, target);
        } else {
            low = mid + 1;
            return binarySearch(reader, low, high, target);
        }
    }
}