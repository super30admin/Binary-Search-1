// Time Complexity : O( logn + log k), n is the length of the array and k is the range in which we perform binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        // check the range, if the high is grater than target, if not then change the
        // low and high values. increament high twice
        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        // binary search on the range generated
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}