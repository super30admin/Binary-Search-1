class Solution {
    public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low)/2;

            int midVal = reader.get(mid);
            // we went too far, go back
            if(midVal == Integer.MAX_VALUE) {
                high = mid - 1;
            }
            else if(midVal == target) return mid;
            else if (midVal > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
