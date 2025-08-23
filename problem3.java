// Time Complexity : log (mn) where m is for finding the window and n is for doing binary search within that window
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach in three sentences only

/**
 * Using the API to find the window where the data may lie first and then performing the binary search on the window
 */
class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        // finding the window where the target may lie
        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        // binary search within that window
        while (left <= right) {
            int mid = left + (right - left) /2;
            int current = reader.get(mid);

            if (current == target)
                return mid;
            else if (current < target)
                left = mid + 1;
            else
                right = mid -1;
        }

        return -1;
    }
}