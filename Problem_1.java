/* 

Problem 1: Search a 2D Matrix(https://leetcode.com/problems/search-a-2d-matrix/)

Time Complexity : O(log(m*n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : NA


Approach : Implemented binary search by converting the mid element index to the correct index in the matrix. 

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int low = 0;
        int high = rows * columns - 1;
        while (low <= high){
            int mid = low + (high-low)/2;
            int row = mid / columns;
            int col = mid % columns;
            if(matrix[row][col] == target){
                return true;
            }
            if(matrix[row][col] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
}