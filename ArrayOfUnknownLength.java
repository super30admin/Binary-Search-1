// Time Complexity : m+log(k)
// Space Complexity : O(1)
//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target)
            return 0;
        int low = 0;
        int high = 1;
        // first we need to set the limit of low and high
        // so we start with 1 and keep moving forward
        while (reader.get(high) <= target) {
            low = high + 1;
            high = high * 2;
        }
        // now we have are our low and high boundaries
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int num = reader.get(mid);

            if (num == target) {
                return mid;
            }
            if (num > target) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return -1;
    }
}
