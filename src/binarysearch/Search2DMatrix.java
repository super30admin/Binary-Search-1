/*
Treat the 2D matrix as a 1D sorted array using index mapping (mid / n, mid % n).
Apply binary search on this 1D view of the matrix.
Compare the target with the mid-element and adjust the low and high pointers accordingly.
Time Complexity : O(log m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
Space Complexity:
  O(1)
 */

package binarysearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low =0;
        int high = m*n - 1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int i = mid / n;
            int j = mid % n;
            if(target == matrix[i][j]){
                return true;
            }
            else if(matrix[i][j] < target){
                low = mid + 1;
            }
            else if(matrix[i][j] > target){
                high = mid - 1;
            }
        }

        return false;
    }
}
