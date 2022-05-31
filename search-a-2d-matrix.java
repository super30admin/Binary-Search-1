//Time Complexity: O(logmn)
//Space Complexity: O(1)
//Implemented Successfully
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int low = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int high = m*n-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int r = mid / n;
            int c = mid % n;
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) high = mid - 1;
            else 
                low = mid + 1;
        }
        return false;
    }
}