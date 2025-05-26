// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// initially picking high as index 1 and then doubling it as we search for target, then implementing binary search within that range.

//interface ArrayReader {
//    public int get(int index) {}
//}
public class ArrUnknownSize {
    public int Search (ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;

            }
        }
        if(reader.get(low) == target) return low;
        return -1;
    }
}
