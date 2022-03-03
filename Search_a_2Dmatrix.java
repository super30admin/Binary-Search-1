// Time Complexity : O(logn) as we are considering matrix as 1-D array 
// Space Complexity : O(1) ; no auxilary space needed
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//CODE

public class Search_a_2Dmatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) { // null case
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1; // if we consider matrix as 1-D array so there will be m*n elements in array and
                                       // high will lie at the last index
        while (low <= high) { // performing binary search
            int mid = low + (high - low) / 2;
            int r = mid / n; // finding the exact position of mid in the matrix ; each row has n elements ,so
                             // dividing mid index with n will give us the row index and taking modulo of mid
                             // with n will give us the column index
            int c = mid % n;
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
