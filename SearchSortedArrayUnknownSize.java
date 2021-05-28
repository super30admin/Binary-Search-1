
//Time Complexity: O(2LogN)
//Space Complexity: O(1)
//Runtime: 1 ms, faster than 100.00% of Java online submissions for Search in a Sorted Array of Unknown Size.
//Memory Usage: 40.3 MB, less than 20.77% of Java online submissions for Search in a Sorted Array of Unknown Size.
//Issues: Not sure if this is the correct approach


class Solution {
    public int search(ArrayReader reader, int target) {
        int size = getSizeOfArray(reader);
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target)
                return mid;
            else if (reader.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
    
    private int getSizeOfArray(ArrayReader reader) {
        int left = 1, right = 10000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == 2147483647) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
