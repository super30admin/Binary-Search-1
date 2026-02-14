// Search a 2D Matrix
// Time Complexity : O(log (r*c))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// 

// Your code here along with comments explaining your approach in three sentences only

//Approach 
// 1) Get rows from size of matrix and columns from each row of matrix
// 2) Binary search on indexes
// 3) convert into row and column

public class BinarySearch1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0;
        int right = rows * cols - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int row = mid / cols;
            int col = mid % cols;
            
            int value = matrix[row][col];
            
            if (value == target) {
                return true;
            } 
            else if (value < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}