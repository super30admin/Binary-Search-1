class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        if(mat == null || mat.length == 0) {
            return false;
        }
        int m = mat.length, n = mat[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / n;
            int c = mid % n;
            if(mat[r][c] == target) {
                return true;
            } else if(mat[r][c] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}