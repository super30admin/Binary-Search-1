// TC :  O(log n + log m)
// SC :  O(1)
class SeachInInfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        while(reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = reader.get(mid);

            if(midElement == target) return mid;
            else if(target < midElement) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}