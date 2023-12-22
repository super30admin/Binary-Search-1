// Time Complexity : O(logn)
// Space Complexity : O(1)
// Method used : increasing the search spach by 2x every time starting from 0 and 1 index, applying binary search on range established to get the values

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while(reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(reader.get(mid) == target) return mid;

            if(reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}