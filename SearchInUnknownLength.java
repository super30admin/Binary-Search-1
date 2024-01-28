// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only

/**
 * We keep on increasing the distance between low and high by twice, so the TC
 * for this operation will be O(log m).
 * After finding the range in which our element lies, for searching in that range will be O(log n)
 */
public class SearchInUnknownLength {
    interface ArrayReader {
        int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return 0;

        int low = 0;
        int high = 1;

        while(reader.get(high) < target) {
            low = high;
            high = 2*high;
        }

        while(low <= high) {
            int mid = (high-low)/2 + low;

            if(target == reader.get(mid)) return mid;
            else if (target < reader.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }
}
