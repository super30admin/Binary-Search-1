// Time Complexity : O(log T), where T is the index at which the target would be placed
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Not sure(*don't have leetcode premium*)
// Any problem you faced while coding this : Had to create ArrayReader interface

// Your code here along with comments explaining your approach in three sentences only:
// Since the array size is unknown, we use exponential search to find the search boundaries.
// Once we find the high boundary such that reader.get(high) >= target, we do binary search in that range.
// This ensures we maintain logarithmic time complexity even for very large arrays.

interface ArrayReader {
    int get(int index);
}

class SearchInUnknownSizedArray {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;

        // Expand the boundary exponentially until we pass or reach the target
        while (reader.get(high) < target) {
            low = high;          // shift low to current high
            high = high * 2;     // double the high for exponential growth
        }

        // Standard binary search within the determined range
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) return mid;   // found target
            if (reader.get(mid) > target) {
                high = mid - 1;   // target lies in the left half
            } else {
                low = mid + 1;    // target lies in the right half
            }
        }

        return -1; // not found
    }

    // Main method with mock implementation of ArrayReader
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 13, 20, 27, 31, 35, 42};

        // Mock ArrayReader using anonymous inner class
        ArrayReader reader = new ArrayReader() {
            public int get(int index) {
                return (index >= nums.length) ? Integer.MAX_VALUE : nums[index];
            }
        };

        SearchInUnknownSizedArray solution = new SearchInUnknownSizedArray();

        System.out.println(solution.search(reader, 13));  // Output: 5
        System.out.println(solution.search(reader, 42));  // Output: 10
        System.out.println(solution.search(reader, 8));   // Output: -1 (not found)
    }
}