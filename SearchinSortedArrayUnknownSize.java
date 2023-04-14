// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only
/*
 * We find high bound that's bigger than target
then we can use low = 0, high to start binary search to check.
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
