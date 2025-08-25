// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// First we run a while loop to find the bounds of the array by doubling the high pointer and to check which low-high range to perform binary search in.
// Next, we run a normal binary search loop to find the target using the reader.get() method.
// If we don't find the element, return -1.

class Solution {
public:
    int search(ArrayReader& reader, int target){
        int low = 0;
        int high = 1;
        while(reader.get(high) < target){ // to get the range for our binary search
            low = high;
            high = high * 2; // double the high 
        }
        while(low <= high){ // standard binary search
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1; // not found
    }
};