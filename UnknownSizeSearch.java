// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// We first exponentially expand the high bound until it exceeds or equals the target.
// Then we apply binary search between the low and high bounds.
// This allows efficient searching in an array of unknown size using only valid accesses.
// Took help of Chatgpt for implementing interface part 


interface ArrayReader {
    int get(int index);
}

class ArrayReaderImpl implements ArrayReader {
    private int[] arr;

    public ArrayReaderImpl(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index < 0 || index >= arr.length) {
            return Integer.MAX_VALUE; 
        }
        return arr[index];
    }
}

public class UnknownSizeSearch {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = reader.get(mid);

            if (x == target) {
                return mid;
            } else if (x > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 12, 15, 18};
        ArrayReader reader = new ArrayReaderImpl(nums);
        int target = 15;

        UnknownSizeSearch ob = new UnknownSizeSearch();
        int result = ob.search(reader, target);

        System.out.println("Index of " + target + ": " + result);
    }
}
