//Problem 3: Search a 2D Matrix

// 1st Approach:
// Considering matrix as imaginary 1D array and doing binary search on it
// This approach treats the matrix as a single sorted list.
// Mapping 1D index to 2D: row = index / columns, col = index % columns.
class Solution {
    // Time Complexity: O(log(m) + log(n)) = O(log(mn))
    //Space Complexity: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while(low <= high){
            int mid = low + (high - low)/2; // to avoid integer overflow
            int r = mid / n;
            int c = mid % n;
            if(matrix[r][c] == target){
                return true;
            }
            if(matrix[r][c] > target){
                high = r * n + c - 1;
            }else{
                low = r * n + c + 1;
            }
        }

        return false;
    }
}

// 2nd approach:
// Doing binary search on row first to get the target's possible row. Then perform binary search on columns to search the target
// This is a two-step approach:
// 1. Find the potential row where the target could exist.
// 2. Perform a standard binary search within that specific row.
class Solution2 {
    // Time Complexity: O(log(m) + log(n)) = O(log(mn))
//Space Complexity: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m - 1;
        int mid = 0;
        // perform binary search on rows to get the range
        while(low <= high){
            mid = low + (high - low)/2;
            if(matrix[mid][0] <= target && matrix[mid][n-1] >= target){
                break;
            }
            else if(matrix[mid][0] > target && matrix[0][0] <= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        low = 0;
        high = n - 1;
        int row = mid;
        // perform second binary search to find the target
        while(low <= high){
            mid = low + (high - low)/2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }