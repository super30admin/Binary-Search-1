// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Didn't get chance to run on leetcode as I don't have leetcode premium
// Any problem you faced while coding this :Didn't understand the usecase of this much and also how can I try this out running locally



// Your code here along with comments explaining your approach in three sentences only


class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int val = reader.get(middle);
            if (val == target) return middle;
            else if (val < target && high > target) low = middle + 1;
            else high = middle - 1;
        }
        return -1;
    }
}