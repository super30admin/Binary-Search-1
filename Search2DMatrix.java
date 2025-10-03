
class Search2DMatrix {

    /**
     * 1. In this solution, we will first find the row where our target can be found
     * 2. Then we do binary search in that row.
     * 3. Time complexity : r + log(c)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] currentArray : matrix) {
            if (target >= currentArray[0] && target <= currentArray[currentArray.length - 1]) {
                int start = 0;
                int end = currentArray.length - 1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (currentArray[mid] == target) return true;
                    if (currentArray[mid] < target)
                        start = mid + 1;
                    else
                        end = mid - 1;
                }
            }
        }
        return false;
    }

    /**
     * In this solution we imagine matrix as flattened array.
     * 1. We do binary search in Row*Column range.
     * 2. To get position of any index in 2d matrix we do
     *      a) row = (index/columns)
     *      b) column = (index % columns)
     * 3. Time complexity : O(log r*c)
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int start = 0;
        int end = (rows * columns) - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int r = mid / columns;
            int c = mid % columns;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return false;
    }

    /**
     * 1. In this solution, we will first find the row where our target can be found using binary search on the rows.
     * 2. Then we do binary search in that row.
     * 3. Time complexity : O(log r + log c)
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid][n - 1] == target) return true;
            if (matrix[mid][n - 1] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (low >= m) return false;

        return binarySearch(matrix[low], target);
    }

    private boolean binarySearch(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}