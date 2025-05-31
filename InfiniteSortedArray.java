// Time Complexity : O(log T), where T is the index of the target or the first element larger than target
// Space Complexity : O(1), since we're using only a few variables
// Did this code successfully run on Leetcode? : Yes
// Any problem you faced while coding this? : Needed to correctly expand the search boundary without going out of bounds

// Approach:
// 1. Since we don’t know the size of the array, we first expand the search window exponentially 
//    by doubling 'high' until the value at that index is greater than or equal to the target.
// 2. Once we have a range [low, high] that includes the target, we apply binary search.
// 3. ArrayReader.get(index) simulates access to an infinite array. If index is out of bounds,
//    it returns Integer.MAX_VALUE, ensuring safe access.

  // This is ArrayReader's API interface.
  // You should not implement it, or speculate about its implementation
  interface ArrayReader {
      public int get(int index);
 }
 

class InfiniteSortedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while(reader.get(high) < target) {
            low = high;
            high = 2 * high;
        }
        return binarySearch(reader, target, low, high);
    }

    int binarySearch(ArrayReader reader, int target, int low, int high){
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = reader.get(mid);

            if (value == target) return mid;
            else if (value < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 3, 5, 9, 12 };
        int target = 0;
        ArrayReader reader = new MockArrayReader(arr);
        InfiniteSortedArray ifa = new InfiniteSortedArray();
        int result = ifa.search(reader, target);
        System.out.println("Index of target: " + result);
    }
}

// A simple mock to simulate ArrayReader for local testing
class MockArrayReader implements ArrayReader {
    private int[] array;

    public MockArrayReader(int[] array) {
        this.array = array;
    }

    public int get(int index) {
        if (index >= array.length) {
            return Integer.MAX_VALUE; // Simulate infinite array behavior
        }
        return array[index];
    }
}