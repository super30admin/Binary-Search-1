/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

//TC: log(n)
//SC: O(1);

import java.util.*;


class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int hi = 1;
        while(reader.get(hi) < target) {
            low = hi ;
            hi = hi *2;
        }

        while ( low <= hi) {
            int mid = low + ( hi - low) / 2;
            if(reader.get(mid) == target) return mid;
            if(reader.get(mid) > target) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}