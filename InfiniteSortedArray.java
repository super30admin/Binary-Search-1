// Binary Search O(log n) time, O(1) space

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;

        while (reader.get(right) < target) {
            left = right;
            right = right * 2; // increase search space by twice
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (reader.get(mid) ==  target) {
                return mid;
            }
            else if (reader.get(mid) < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }    
}
