// Time Complexity : O(log(n) + log(m))
// Space Complexity : O(1)

// Approach
// Visualize 2d array to 1d array and calculate mid point by low and high
// Row and Column index can be calculated as follows
//  row = mid / n  where is number of columns in the array
// col = mid % n where is number of columns in the array

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }

        return false;
    }
}