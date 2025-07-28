// I used binary search by treating the 2D matrix as a flat 1D sorted array.
// The mid index is mapped back to 2D indices using row = mid / n and col = mid % n.
// This helps achieve O(log(m*n)) time complexity without extra space.

// Time Complexity : O(log (m * n)) — where m is rows, n is columns
// Space Complexity : O(1) — no extra space used
// Did this code successfully run on Leetcode : Yes

import java.util.*;

public class Search2DMatrix {
    public static boolean Search2DMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1;

        // Perform binary search over the 1D view of 2D matrix
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert 1D index to 2D coordinates
            int r = mid / n;
            int c = mid % n;

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Target not found
        return false;
    }
}
