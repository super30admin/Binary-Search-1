// ✅ Class to simulate reading from an infinite sorted array
class ArrayReader {
    int[] arr;

    // Constructor to initialize the array
    public ArrayReader(int[] arr) {
        this.arr = arr;
    }

    // ✅ Method to simulate accessing elements in the array
    public int get(int index) {
        if (index >= arr.length) return Integer.MAX_VALUE;
        return arr[index];
    }
}

public class SearchInfiniteSortedArray {
  
    // ✅ Function to search for a target in an infinite sorted array
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) return 0;

        // ✅ Step 1: Find the search range using exponential growth
        int left = 0, right = 1;
        while (reader.get(right) < target) {
            left = right;
            right <<= 1; // Double the search range using left shift operator (same as right * 2)
        }

        // ✅ Step 2: Perform binary search within the established range
        while (left <= right) {
            int pivot = left + ((right - left) >> 1);
            int num = reader.get(pivot);

            if (num == target) return pivot;
            if (num > target) right = pivot - 1;
            else left = pivot + 1;
        }

        // ✅ Step 3: If element is not found, return -1
        return -1;
    }

    // ✅ Main function to test the code
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 12, 15, 18, 21, 30, 45, 60, 75, 90, 100, 110};
        ArrayReader reader = new ArrayReader(arr);

        SearchInfiniteSortedArray searcher = new SearchInfiniteSortedArray();

        int target = 21;
        int result = searcher.search(reader, target);
        System.out.println("Target found at index: " + result); // Output: 8

        target = 100;
        result = searcher.search(reader, target);
        System.out.println("Target found at index: " + result); // Output: 14

        target = 8;
        result = searcher.search(reader, target);
        System.out.println("Target found at index: " + result); // Output: -1
    }
}
