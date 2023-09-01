//Time Complexity O(log(m*n)) and space complexity O(1)
class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols - 1;
        while (low <= high){
            int mid = low + (high - low)/2;
            int row = mid/cols;
            int col = mid % cols;
            if(matrix[row][col] == target)
                return true;
            else if (target > matrix[row][col])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;

    }
}