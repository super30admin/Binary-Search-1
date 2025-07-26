
 //Time Complexity : O(log(m * n)) → where m = number of rows, n = number of columns
 //Space Complexity : O(1) → constant space, no additional storage used
 //Did this code successfully run on Leetcode : Yes
 //Any problem you faced while coding this : No
 //
 //Approach:
 //The 2D matrix is treated as a 1D sorted array by mapping 2D indices using (mid / n) for row and (mid % n) for column.
 //A standard binary search is applied on this virtual 1D array to find the target.
 // This reduces the 2D search problem to a logarithmic-time 1D search.

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Edge case: matrix is null or empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length;         // Number of rows
        int n = matrix[0].length;      // Number of columns

        int start = 0;                 // Starting index in virtual 1D array
        int end = (m * n) - 1;         // Ending index in virtual 1D array

        while (start <= end) {
            int mid = start + (end - start) / 2;   // Prevents integer overflow

            int r = mid / n;          // Row index derived from 1D index
            int c = mid % n;          // Column index derived from 1D index

            if (matrix[r][c] == target) {
                return true;          // Target found
            } else if (matrix[r][c] < target) {
                start = mid + 1;      // Search right half
            } else {
                end = mid - 1;        // Search left half
            }
        }

        return false;
    }

    // Sample main method covering various edge cases
    public static void main(String[] args) {
        SearchMatrix sm = new SearchMatrix();

        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int[][] matrix2 = new int[0][];
        int[][] matrix3 = {{1}};

        // Test cases
        System.out.println(sm.searchMatrix(matrix1, 3));     // true
        System.out.println(sm.searchMatrix(matrix1, 13));    // false
        System.out.println(sm.searchMatrix(matrix2, 1));     // false (empty matrix)
        System.out.println(sm.searchMatrix(matrix3, 1));     // true (single element matrix)
        System.out.println(sm.searchMatrix(matrix3, 2));     // false (single element matrix, target not present)
    }
}