/**
 * Time complexity: O(log(m) + log(n)) where m is the steps to find the range, n is the size of the range
 * Space: O(1) no extra space used
 */
public class SearchInInfiniteSortedArray {
    public int search(ArrayReader reader, int target) {

        if (reader == null) {
            return -1; // Invalid input
        }

        if (reader.get(0) == target) {
            return 0;
        }

        int low = 0;
        int high = 1;

        while (target > reader.get(high)) {
            low = high;
            high = high * 2;
        }
        // Once we get out of loop, we know that target <= reader.get(high)
        // Hens we can do binary search on [low, high]
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (reader.get(mid) == target) {
                return mid;
            }
            if (target < reader.get(mid)) {
                // Going to left part of selected range
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }




    public static void main(String[] args) {
        // Example usage
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        ArrayReader reader = new ArrayReaderImpl(arr);

        SearchInInfiniteSortedArray solution = new SearchInInfiniteSortedArray();
        int target = 10;
        System.out.println("Index of " + target + ": " + solution.search(reader, target));
        // Test with a target that doesn't exist
        target = 175;
        System.out.println("Index of " + target + ": " + solution.search(reader, target));
    }
}

interface ArrayReader {
    int get(int index);
}

class ArrayReaderImpl implements ArrayReader {
    private int[] arr;

    public ArrayReaderImpl(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int get(int index) {
        if (index >= arr.length) {
            return Integer.MAX_VALUE;
        }
        return arr[index];
    }
}



