// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int search(ArrayReader reader, int target) {

        int start = 0;
        int end = 1;

        while(reader.get(end) < target) {
            
            start = end + 1;
            end = end * 2;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (reader.get(mid) == target) {
                return mid;
            }
            else if (reader.get(mid) < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
