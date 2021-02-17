// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach

class Solution {
    public int search(ArrayReader reader, int target) {

        // checking if the starting value of reader is target value or not
        // if so returning position 0
        if (reader.get(0) == target) {
            return 0;
        }

        // initializing left and right pointers to 0 and 1 simultaneously
        int left = 0;
        int right = 1;

        // iterating through reader to find the appropriate left and right pointers to
        // implement binary search
        while (reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        // Implementing Binary Search to check the target value
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // if the target value is not present, return -1
        return -1;
    }
}
