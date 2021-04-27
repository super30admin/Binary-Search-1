// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In this approach rather than thinking the elements as 2d array, we consider the input as a one dimensional array.
// Since we are assuming the array as 1D we can apply basic binary search.
// Only when we fetch the element by the index to compare to the target, we convert the index into respective row & col.
// index / no.of cols -> gives the corresponding row of the element.
// index % no.of cols -> gives the corresponding col of the element.

class Search2D {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Extract the row and col value from the calculated mid.
            int row = mid / n;
            int col = mid % n;

            // Search for the target value in the 
            if (matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60, 10}};
        System.out.println(searchMatrix(matrix, 10));
    }
}