// Time Complexity : 2 * O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class ArrayOfUnknownLength{
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        //Searching a range to search for a target value. Time Complexity: O(log n)
        while (reader.get(high) != 2147483647 && reader.get(high) <= target) {
            low = high;
            high = high * 2;
        }

        //binary search. Time Complexity: O(log n)
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) return mid;

            else if (target > reader.get(mid)) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return -1;
    }
}