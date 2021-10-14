// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No, I don't have premimum subscription
// Any problem you faced while coding this :
import java.util.*;

class SearchSortedArrayUnknownSize {
        /**
         * // This is ArrayReader's API interface.
         * // You should not implement it, or speculate about its implementation
         * interface ArrayReader {
         *     public int get(int index) {}
         * }
         */

    public static int search(ArrayReader reader, int target) {
        int start = 0;
        int end = 1;
        int mid;
        //find target range
        while(reader.get(end) <= target && reader.get(end) != Integer.MAX_VALUE) {
            start = end;
            end = end * 2;
        }
        //apply binary search on found range
        while(start <= end) {
            mid = start + (end-start)/2;
            if(reader.get(mid) == target) {
                return mid;
            }
            if(reader.get(mid) < target) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }

        }
        return -1;
    }
    
}
