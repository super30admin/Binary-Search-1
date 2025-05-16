// Time complexity - O(log mn)
// Space Complexity - O(1)
// Solved the problem on leetcode - yes
// Did you face any issue - no

// Imagining 2D array as a 1D and simple doing the binary search
// To calculate the row and column from 1D index we just divide by coulm size and modulo by solumn size
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int low =0;
        int high = m*n -1;

        while(low<=high) {
            int mid = low + (high-low)/2;
            int r = mid/m;
            int c = mid%m;

            if(matrix[r][c] == target) return true;
            if(target < matrix[r][c]) {
                    high = mid-1;
            } else {
                    low = mid+1;
            }
        }
        return false;
    }
}
