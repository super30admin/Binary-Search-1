class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        if (reader.get(low) == target) return low;
        return -1;
    }
}