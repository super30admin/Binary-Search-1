// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
//Approach: We will treat the matrix as a flattened array and apply the binary search. To get the location of an element we find the 
//row index and column index. The row index will be mid/number of elements in the row and column index will be mid%number of elements.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n= matrix[0].length;
        int low =0;
        int high = m*n-1;
        while (low<= high) {
            int mid = low+(high-low)/2;
            int r = mid/n;
            int c =mid%n;
            if (matrix[r][c] == target) {
                return true;
            }
            else if (matrix[r][c] < target) {
                low = mid +1;
            }
            else{
                high=mid-1;
            }

        }
        return false;
    }   
}