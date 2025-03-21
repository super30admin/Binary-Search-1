// Time Complexity: O(log n) where n is the index of the target element
// Space Complexity: O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



interface ArrayReader {
    int get(int index);
}

class InfiniteArray {
    public int Search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        while(reader.get(high) < target) {
            low = high; // move low to current high
            high *= 2; // expand the range, double the size
        }

        // search in the range
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = reader.get(mid);
            if(midValue == target) return mid; // main logic
            if (midValue > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader() {
            private int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41};

            @Override
            public int get(int index) {
                if (index >= arr.length) {
                    return Integer.MAX_VALUE;
                }
                return arr[index];
            }
        };

        InfiniteArray searcher = new InfiniteArray();
        int target = 19;
        int result = searcher.Search(reader, target);
        System.out.println("Index of " + target + ": " + result);
    }
}
