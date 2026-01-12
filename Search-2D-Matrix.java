// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// Treat the 2D matrix as a 1D sorted array using index mapping (mid / n, mid % n).
// Apply binary search on this 1D view of the matrix. compare target with mid nad adjust pointers.

class Solution {
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