public class SearchSortedArrayUnknownSize {
    /*
    First find the range in which target could lie, using binary search.
    Perform regular binary search on the found range to find target
    Time: log n
     */
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        // find range within which target could lie
        while (reader.get(high) < target) {
            if (reader.get(low) > target) {
                return -1;
            }
            low = high + 1;
            high *= 2;
        }

        //regular binary search on the found range
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
