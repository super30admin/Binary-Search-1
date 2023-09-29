class Solution {

   
    // Time Complexity : O(log m) + O(log n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Did not run as i do not have premium but ran through all the test cases.
    // Any problem you faced while coding this : No
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        //First step to find the range
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        //binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) < target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
