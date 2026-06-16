// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Search in a sorted array of unknown size
// - Finds a valid search range by exponentially expanding the upper bound until it is greater than or equal to the target
// - Performs binary search within the identified range to locate the target.

class Problem3 {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        while(target > reader.get(high)) {
            low = high;
            high = high * 2;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(reader.get(mid) == target) {
                return mid;
            }
            if(target < reader.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}