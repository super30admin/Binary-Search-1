package BinarySearch;

/*
  Time complexity : o(log n)
  Space complexity : o(n)
  Did this code run succesfully in leetcode : yes
  problems faces : no
  Increase the search space by 2x , each time we ae unable to find the target. once the range is identified apply binary search
  we increase search space by 2x because we use binary search later to find teh target, where we reduce the search space each time exactly by half
*/

public class SearchSortedArrayUnkownSize {

    public static int searchArrayOfUnkownSize(ArrayReader reader, int target) {
        if (reader.get(0) == target) {
            return 0;
        }

        int left = 0, right = 1;
        while (reader.get(right) != Integer.MAX_VALUE && reader.get(right) < target) {
            left = right;
            right = right * 2;
        }

        return binarySearch(reader, left, right, target);
    }

    private static int binarySearch(ArrayReader reader, int low, int high, int target) {
        int pivotIndex;
        while (low <= high) {
            pivotIndex = low + (high - low) / 2;

            if (reader.get(pivotIndex) == target) {
                return pivotIndex;
            } else if (reader.get(pivotIndex) > target) {
                high = pivotIndex - 1;
            } else {
                low = pivotIndex + 1;
            }
        }
        return -1;
    }

}

interface ArrayReader {
    default int get(int index) {
        return index;
    }
}
