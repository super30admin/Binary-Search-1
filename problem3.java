"""
    Explanation: I used binary seach to find the target. The binary search finds the mid point first,
    then the mid point is compared with the target to get the value. Edge cases added for checking
    whether the first / last element is the target.
    Time Complexcity: O (log n)
    Space Complexcity: O(1)
""";


class Solution {
    public int search(ArrayReader reader, int target) {

        int start = 0, end = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == reader.get(mid)) {
                return mid;
            } else if (target < reader.get(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (reader.get(start) == target) {
            return start;
        } else if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}