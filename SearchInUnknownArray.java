interface ArrayReader {
    int get(int index);
}


public class SearchInUnknownArray {

    public int search(ArrayReader reader, int target) {

        if(reader.get(0) == target) return 0;

        int low = 0;
        int high = 1;

        // First find out the good high value.
        // Else keep on updating the low and high pointers
        while(reader.get(high) < target){
            low = high;
            high = 2 * high;

        }

        // Now we have found out the low and high indexes, use the usual binary search for searching
        return binarySearch(reader, target, low, high);
    }

    private int binarySearch(ArrayReader reader, int target, int low, int high) {

        while(low <= high){
            int mid = low + (high - low)/2;

            if(reader.get(mid) == target)
                return mid;
            if(reader.get(mid) > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
