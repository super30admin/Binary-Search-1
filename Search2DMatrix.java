//Passed all test cases
/*
    TC - O(log(m*n)) where m is row size, n is the col size of the given matrix
    SC - O(1) (no auxiliary storage is used)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low =0;
        int high= m*n - 1;
        /*
            Since this matrix is in sorted order, perform Binary Search
            Calculate the index (row, col) of the mid element using the / and % operators. Return true if found the element, else false 
        */
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c]==target)
                return true;
            else if(matrix[r][c] > target)
            {
                high = mid-1;
            }
            else 
            {
                low = mid + 1;
            }
        }
        return false;
    }
}