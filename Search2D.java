
class Search2D {
    public boolean search2D(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (target <= matrix[i][columns - 1]) {
                int start = 0;
                int end = columns - 1;

                while (start <= end) {
                    int mid = start + (end - start) / 2;

                    if (matrix[i][mid] == target)
                        return true;
                    else if (matrix[i][mid] > target) {
                        start = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}
