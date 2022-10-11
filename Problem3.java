// Time Complexity : 3 ms (faster than 81.7% submissions)
// Space Complexity : 54.2MB (less than 58.7% submissions)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {

        if (reader.get(0) == target) {
            return 0;
        }

        int left = 0;
        int right = 1;

        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        while (left <= right) {

            int mid = left + (right - left) / 2;
            int element = reader.get(mid);

            if (element == target) {
                return mid;
            }
            if (element < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return -1;
    }
}