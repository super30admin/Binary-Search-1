//Time Complexity = O(log n)
//Space Complexity = O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        //m = no. of rows, n = no. of coloumns
        int m = matrix.length;
        int n = matrix[0].length;
        //low = lower index of binary search, high = higher index of binary search
        int low = 0, high = m*n-1;

        //binary search procedure
        while (low <= high) {
            int mid = low + (high-low)/2;
            //identifying the row and coloumn for checking in binary search
            int r = mid/n;
            int c = mid%n;

            if (matrix[r][c] == target) {
                return true;
            }
            else if (matrix[r][c] < target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return false;
    }
}