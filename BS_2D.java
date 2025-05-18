/*
 * T.C: O(log m*n) where m: rows, n: cols of the matrix.
 * S.C: O(1) no extra spaces used except the pointers.
 * 
 * Approach: I am considering the 2D array as a 1D array and then performing Binary Search. 
 */


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int low = -1;
        int high = r*c;

        while(high - low > 1){
            int mid = (high+low)/2;
            int row = mid/c;
            int col = mid%c;

            if(matrix[row][col] == target) return true;
            if(matrix[row][col] < target) low = mid;
            else high = mid;
        }

        return false;
    }
}