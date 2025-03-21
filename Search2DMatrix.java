// Time Complexity : O(log(mxn)) where m is the number of rows and n is the number of columns
// Space Complexity : O(1) as we are not using any extra space
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No



public class Search2DMatrix {

    
    public boolean searchMatrix(int[][] matrix, int target) { // using log(mxn)
        // Get the number of rows in the matrix
        int m = matrix.length;

        // Get the number of columns in the matrix
        int n = matrix[0].length;

        // Initialize the search range for binary search
        int low = 0, high = m * n - 1;

        // Perform binary search
        while (low <= high) {
            // Calculate the middle index
            int mid = low + (high - low) / 2;

            // Convert the 1D index to a 2D row index
            int r = mid / n;

            // Convert the 1D index to a 2D column index
            int c = mid % n;

            // Check if the middle element matches the target
            if (matrix[r][c] == target) {
                return true; // Target found
            } 
            // If the middle element is greater than the target, search the left half
            else if (matrix[r][c] > target) {
                high = mid - 1;
            } 
            // If the middle element is less than the target, search the right half
            else {
                low = mid + 1;
            }
        }

        // If the loop ends, the target is not in the matrix
        return false;
    }

    
    public static void main(String[] args) {
        
        Search2DMatrix obj = new Search2DMatrix();

        // sample 2D matrix
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        // target value to search for
        int target = 3;

        // Call the searchMatrix method and print the result
        System.out.println(obj.searchMatrix(matrix, target));
    }
}
