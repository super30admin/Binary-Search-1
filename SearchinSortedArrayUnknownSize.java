// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/*
 * We could try imagining 2D matrix as 1d matrix and then map the indexes to 2D row and col.
We are given that last element of row i < first element of row i+1 and thus we could use mod and 
div to get the row and col in range.
 */
public class SearchinSortedArrayUnknownSize {
    public int search(ArrayReader reader, int target) {
        if(reader == null) {
            return -1;
        }
        int low = 0;
        int high = 1;
        while(reader.get(high) < target) {
            high = high*2;
        }
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(target == reader.get(mid)) {
                return mid;
            }
            if(target < reader.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
