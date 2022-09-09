/*
TC - O(logn)
SC - O(1)

*/

class Search_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) { 
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m * n - 1; 
                                       
        while (low <= high) { 
            int mid = low + (high - low) / 2;
            int r = mid / n; 
            int c = mid % n;
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}