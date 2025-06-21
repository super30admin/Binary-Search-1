// Time Complexity : O(log(n))
// Space Complexity : O(1) 
class Solution {
     public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = 1;

        // Keep increasing high exponentially until we know target's will be in bounds.
        while (reader.get(high) < target) {
            low = high;
            high *= 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == reader.get(mid)) {
                return mid;
            }

            if (target < reader.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            
        }

        return -1;
    }
}