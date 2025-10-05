// Search in rotated sorted array of unknown size
// time complexity: log (n)
// Space Complexity: O (1)

class Solution {

    public int searchMatrix(ArrayReader arrayReader, int target) {
        int low = 0;
        int high = 1;

        while (arrayReader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (arrayReader.get(mid) == target) {
                return mid;
            }

            if (arrayReader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}