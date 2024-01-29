
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

//Since the size is unknown we have to first increase the search space from one size of the array by a factor of 2 and implement binary search on the same.

class ArrayReader {

    private int[] array;

    public ArrayReader(int[] arr) {
        this.array = arr;
    }

    public int get(int index) {
        if (index < 0 || index >= array.length) {
            // Handle index out of bounds appropriately, throw an exception, or return a
            // default value
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }
}

public class SearchSortedArrayOfUnknownSize {

    public int search(ArrayReader reader, int target) {

        if (reader.get(0) == target) {
            return 0;
        }

        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }

}
