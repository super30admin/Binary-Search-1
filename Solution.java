// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
class SearchMatrixSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length, n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / n;
            int c = mid % n;

            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class RotatedArraySearchSolution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l])
                    l = mid + 1;
                else
                    r = mid - 1;
            } else {
                if (target < nums[mid] || target > nums[r])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }

        return -1;
    }
}

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class ArrayReader {
    private int[] arr;

    public ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}

class InfiniteArraySearchSolution {
    public int search(ArrayReader reader, int target) {
        int l = 0;
        int h = 1;

        while (reader.get(h) < target) {
            l = h;
            h = h * 2;
        }

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (reader.get(mid) == target)
                return mid;
            if (reader.get(mid) > target)
                h = mid - 1;
            else
                l = mid + 1;
        }

        return -1;
    }
}

public class Solution {
    public static void main(String[] args) {
        // Test searchMatrix
        SearchMatrixSolution sms = new SearchMatrixSolution();
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        System.out.println("Search Matrix Result: " + sms.searchMatrix(matrix, 3)); // true

        // Test rotated array search
        RotatedArraySearchSolution rass = new RotatedArraySearchSolution();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Rotated Array Search Result: " + rass.search(nums, 0)); // 4

        // Test infinite array search
        InfiniteArraySearchSolution iass = new InfiniteArraySearchSolution();
        int[] infiniteArray = { 1, 3, 5, 7, 9, 13, 18, 21, 25, 30, 35 };
        ArrayReader reader = new ArrayReader(infiniteArray);
        System.out.println("Infinite Array Search Result: " + iass.search(reader, 21)); // 7
    }
}
