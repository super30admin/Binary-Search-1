/**
 * You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 */

 /**
  * Brute Force Approach
  Iterate across all the elemets in each row and column to find the target.
  */

  class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row =0;
        int column = matrix.length * matrix[0].length -1;
        while(row <= column){
            int pivotIdx = (row + column)/2;
            int pivotElement = matrix[pivotIdx/matrix[0].length][pivotIdx % matrix[0].length];
            if(pivotElement == target) 
            return true;
            else{
                if (target < pivotElement) column = pivotIdx - 1;
                else row = pivotIdx + 1;
            }
        }
        return false;
    }
}