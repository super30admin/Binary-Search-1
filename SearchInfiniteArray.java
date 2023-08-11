// Binary seach to isolate arrat index with pivot and left, right values
// based on target, T is the index of the target value
// Time Complexity: O(log T)
// Soace Complexity: O(1)


class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;
        
        // search boundaries
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1;
        }

        // Binary search
        int pivot, num;
        while (left <= right) {
            pivot = left + ((right - left) >> 1);
            num = reader.get(pivot);
            
            if (num == target) return pivot;
            if (num > target) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }
}
