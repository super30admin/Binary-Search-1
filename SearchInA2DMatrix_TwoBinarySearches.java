// Time Complexity : O(log m + log n) ~ O(log(m*n)). m is the number of rows and n is the number of columns 
// Space Complexity : O(1) as we do not use any extra space

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Search in a 2D array
 */

/*
* Approach: Two Binary Searches
* In the following approach, we leverage the fact that the columns and rows both are in the strict
* increasing order. We apply binary searches twice, first over the rows to find the target row and 
* second over the columns in a row found as a result of first binary search to locate the exact position of target. 
* If we fail to locate the target within any row or column, we return false;
*/

public class SearchInA2DMatrix_TwoBinarySearches {
    public boolean searchMatrix(int[][] matrix, int target) {
        // We return false if matrix is null or empty
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // binary search to find the row
        int startRow = 0;
        int endRow = m-1;
        int rowFound = -1;
    
        while (startRow <= endRow) {
            int midRow = startRow + (endRow - startRow)/2;
            if (target >= matrix[midRow][0] && target <= matrix[midRow][n-1]) {
                rowFound = midRow;
                break;
            } else if (target < matrix[midRow][0]) {
                endRow = midRow - 1;
            } else {
                startRow = midRow + 1;
            }
        }

        if (rowFound == -1) {
            return false;
        }

        // binary search to find the column in the correct row
        int startCol = 0;
        int endCol = n-1;
        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol)/2;
            if (matrix[rowFound][midCol] == target) {
                return true;
            } else if (matrix[rowFound][midCol] < target) {
                startCol = midCol + 1;
            } else {
                endCol = midCol - 1;
            }
        }

        return false;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target1 = 3;
        int target2 = 100;

        SearchInA2DMatrix_TwoBinarySearches searchInA2DMatrix = new SearchInA2DMatrix_TwoBinarySearches();
        System.out.println(searchInA2DMatrix.searchMatrix(matrix, target1));
        System.out.println(searchInA2DMatrix.searchMatrix(matrix, target2));
    }
}