// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I initially used wrong while condition in the first loop


// Your code here along with comments explaining your approach in three sentences only
/*
 * We start with low = 0 and high = 1
 * in the first while loop, we keep on doubling our search space and the terminating condition would be when target becomes larger than the high value
 * Once we know the search space, we apply regular binary search
 */

public class Problem3 {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = low+1;

        while(reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        while(low <= high) {
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target) {
                return mid;
            } else if(reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
