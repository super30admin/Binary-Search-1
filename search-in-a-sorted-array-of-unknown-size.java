//Time Complexity: O(logn)
//Space Complexity: O(1)
//Submitted on leetcode successfully
class Solution {
    public int search(ArrayReader reader, int target) {
        int lo = 0, hi = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int val = reader.get(mi);
            if (val == target) return mi;
            else if (val < target) lo = mi + 1;
            else hi = mi - 1;
        }
        return -1;
    }
}