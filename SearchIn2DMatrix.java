// Time Complexity : O(log m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only

// This code performs a binary search on a 2D matrix by treating it as a single, sorted 1D array of length times n.
// It calculates the 2D coordinates using mid / n and mid % n to check the target, efficiently finding the value in O(log(m x n)) time.

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int low = 0, high = m*n-1;

            while(low <= high){
                int mid = low + (high - low)/2;

                int r = mid / n;
                int c = mid % n;

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