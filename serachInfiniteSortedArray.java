//Time complexity: O(logn)
// Space complexity: O(1)
//Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach



class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high-low)/2;
            if (reader.get(mid) == target) {
                return mid;
            }
            if (target > reader.get(mid)) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
} 