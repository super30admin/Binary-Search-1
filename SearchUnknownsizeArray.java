// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NO -(dont have premium leetcode)
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
import javax.lang.model.util.ElementScanner6;

public class SearchUnknownsizeArray {
    public int search(ArrayReader reader, int target) {
        int high = 1, low = 0, mid = -1;
        while (reader.get(high) != Integer.MAX_VALUE) {
            high = high * 2;
        }

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
