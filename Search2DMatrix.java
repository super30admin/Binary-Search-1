class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length, low = 0, high = m*n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2, r = mid / n, c = mid % n;
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) high = mid - 1;
            else low = mid + 1;
             
        }
        return false;
    }
}
