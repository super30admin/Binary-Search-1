// Time complexity - same as Binary Search - O(log n)
// Works on leetcode

class Solution {
    public boolean searchMatrix(int[][] matrix, int target){
        int n = matrix.length; // Number of rows
        int m = matrix[0].length; // Number of columns

        // Starting Binary Search using the 2D matrix as a 1D array
        int low = 0;
        int high = n * m - 1; // Since there would be n*m elements

        while(low <= high){
            int mid = low + (high - low) / 2;
            int i = mid / m;
            int j = mid % m;
            if (matrix[i][j] == target){
                return true;
            }
            else if (matrix[i][j] > target){
                // Move to the left side of the array
                high = mid - 1;
            }
            else{
                // Move to the right side of the array
                low = mid + 1;
            }
        }
        // When nothing is found
        return false;
    }
}
