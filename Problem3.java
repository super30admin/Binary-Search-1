// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.*;

public class Problem3 {
    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     * public int get(int index) {}
     * }
     */

    public static int search(List<Integer> reader, int target) {
        int start = 0;
        int end = 10;
        while (target > reader.get(end)) {
            start = end + 1;
            end = end * 2; // increasing the search window by multiple of 2
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < reader.get(mid)) {
                end = mid - 1;
                continue;
            }
            // if(reader.get(mid) == null){
            // end = mid - 1;
            // }
            else if (reader.get(mid) == target) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> reader = new ArrayList<>(Arrays.asList(-1, 0, 5));
        int target = 0;
        System.out.println(search(reader, target));
    }
}
