/*
Time Complexity :  O(n), here I am confussed like I am checking all elements only for row 
how to count time complexity of this could you please guid me on this ?

Space:  O(1) // as we are not using any auxillary space.

// Problem faced : how to with log(n).
// worked on Leetcode. no errors.

*/

class Solution_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0) {

            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        boolean result = false;

        for (int i = 0; i < row; i++) {

            if (matrix[i][0] <= target && matrix[i][col - 1] >= target) {

                result = targetCheck(i, col, matrix, target);
                return result;
            }

        }
        return result;

    }

    public boolean targetCheck(int row, int col, int[][] matrix, int target) {

        for (int k = 0; k < col; k++) {

            if (matrix[row][k] == target) {

                return true;
            }
        }

        return false;
    }
}