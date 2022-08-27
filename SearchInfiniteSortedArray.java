// Time Complexity : O(log n + log m) - where n is values given as input and m is number of times we're expanding
//                   the search area by moving the high point by 2 times
// Space Complexity : O(1) as we're not using any auxiliary space
// Did this code successfully run on Leetcode : No as its only for leetcode premium subscribers
// Any problem you faced while coding this : No

public class SearchInfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        while (low<=high) {
            int mid = low + (high-low) / 2;
            if (reader.get(mid) == target ) return mid;
            else if (reader.get(mid) > target) {
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}