/*There are multiple ways to solve this problem

Approach 1: Check if the elements belongs to that row, if it does perform BS on that row
Approach 2: Start from either top right or bottom left corner because from there we will have clear idea about where to go
Approach 3: Imagine the array as a 1D array and perform BS on that
// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length; //number of rows
        int n = matrix[0].length; // number of columns

        int start = 0;
        int end = m * n - 1; // total number of elements minus one

        while(start <= end){
            int mid = start + (end - start) / 2;

            //translating 1D array mid to a 2D array mid
            // number of rows is dependent on number of column hence using n as the denominator 
            // division will help with chunking the rows, modulo will help with finding the element
            int r = mid / n;
            int c = mid % n;

            if(matrix[r][c] == target){
                return true;
            }
            else if(matrix[r][c] > target){
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return false;
    }
}
