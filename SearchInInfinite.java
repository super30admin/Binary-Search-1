import java.util.*;

public class SearchInInfinite {

    // Since we don't know the size of the array. Until we cross the target keep on
    // multiple by 2(could be anything but 2 will give log time. As it reduced the range.)
    // We know both low and high so we can do the normal binary search.
    // TC:O(logN) where N is number of elements in the ArrayReader
    // SC: O(1) We are not using any extra space.
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high *= 2;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) < target) {
                low = mid + 1;
            } else if (reader.get(mid) > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInInfinite searchInInfinite = new SearchInInfinite();
        int result = searchInInfinite.search(new Reader(), 9);
        System.out.println("The result: " + result);
    }
}
