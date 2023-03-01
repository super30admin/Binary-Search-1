// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to look at the approach for the opimized solution. I was able to code a solution which in avarage case, would cost O(logmn) but in worst case would be O(mn)


// Your code here along with comments explaining your approach



class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n - 1;
        while( left <= right ) {
            int pivot = left + (right-left)/2;
            int x = (pivot/n);
            int y = pivot % n;
            if( matrix[x][y] == target ) {
                return true;
            } else if ( target > matrix[x][y] ) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return false;
    }
}