class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n -1, mid;
        int row, column;
        while(low <= high) {
            mid = low + (high - low) / 2;
            row = mid / n;
            column = mid % n;
            if(matrix[row][column] == target) return true;
            if(matrix[row][column] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}