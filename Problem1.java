/* Problem 1: search 2d matrix
*/

// Time Complexity : O(log mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We have to find if target exist in 2d matrix, where m-number of rows, n-number of columns
//There are 4 approaches to solve: 1. Brute force (m*n) 2. Two pointer algorithm(m+n) 3. m + log n or n + logm
//4. log m + log n(searching on row first and then on column): order matters
//In last approach, we will create 1d matrix of m*n-1 elements and convert into 2d matrix by assigning row = mid / n and column = mid % n

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //null case
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length; int n = matrix[0].length;
        int low = 0; int high = m*n - 1;
        //converting 1d matrix to 2d matrix
        while(low <= high){
            int mid = low + (high-low)/2;
            int r = mid / n;
            int c = mid % n;
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
}