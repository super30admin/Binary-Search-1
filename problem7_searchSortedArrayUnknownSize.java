package BinarySearch1;

import java.util.Arrays;

interface ArrayReader {
    public int get(int index);
}

public class problem5_searchSortedArrayUnknownSize {

    /*
        Time Complexity: O(log n)
     */
    private int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while(reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        return binarySearch(reader, low, high, target);
    }
    private int binarySearch(ArrayReader reader, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        /*
        Sample 1:
            Input: array = [-1,0,3,5,9,12], target = 9
            Output: 4
        Sample 2:
            Input: array = [-1,0,3,5,9,12], target = 2
            Output: -1
         */
    }
}
