// Time Complexity : O(log n) where n is the index of the target element
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : how to implement arrayreader

// Your code here along with comments explaining your approach in three sentences only 
//Double the high index until the target is within range. then Perform binary search between low and high.


public class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) return mid;
            if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 12, 15, 20};
        ArrayReader reader = new ArrayReader(arr);
        int target = 9;

        Solution sol = new Solution();
        int idx = sol.search(reader, target);
        System.out.println(idx);
    }

    static class ArrayReader {
        private final int[] data;

        public ArrayReader(int[] arr) {
            this.data = arr == null ? new int[0] : arr.clone();
        }
        public int get(int index) {
            if (index < 0 || index >= data.length) return Integer.MAX_VALUE;
            return data[index];
        }
    }
}