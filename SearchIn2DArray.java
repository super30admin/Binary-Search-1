// Time Complexity : O(log (m * n)), where m = number of rows, n = number of columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach in three sentences only
// We treat the 2D matrix as a flattened 1D sorted array since each row is sorted and the first element of each row is greater than the last of the previous row. 
// Using binary search on this virtual array, we map each 1D index to its corresponding 2D (row, col) position.
// This allows us to search in O(log(m * n)) time without using extra space.

public class SearchIn2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
// Step 1: Treat the 2D matrix as a virtual 1D sorted array
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m*n - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

// Step 2: Map the 1D index to 2D coordinates
            int r = mid / n;
            int c = mid % n;

// Step 3: Apply binary search on the virtual 1D array
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
