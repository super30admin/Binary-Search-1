// Time Complexity : O(log T), where T is the index of the target
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only:
// Since the array length is unknown, I first expand the search boundary exponentially until the value at `high` is >= target.
// Once a valid search window [low, high] is found, I apply binary search within that window to locate the target.

public class SearchinInfiniteSortedArray {
    public int search(ArrayReader reader, int target){
        int low = 0;
        int high = 1;

        if(reader.get(high) < target){
            low = high;
            high = high * 2;
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            int val = reader.get(mid);

            if(val == target) return mid;
            else if(val < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
