// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target)
            return 0;

        // search boundaries
        int left = 0, right = 1;
        while(reader.get(right) < target) {
            left = right;
            right <<= 1;
        }

        // binary search
        int mid, num;
        while(left <= right) {
            mid = left + ((right - left) >> 1);
            if(reader.get(mid) == target) {
                return mid;
            } else if(reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}