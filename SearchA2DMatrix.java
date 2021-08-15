public class SearchA2DMatrix {


    //As the given array is sorted, for log time, we can do binary search.
    //But We need to assume that given matrix into a 1D array.
    //If an index / column length - gives row  and index % column length - gives column
    //TC: O(logMN) where M is number of rows, and N is numer of columns
    //SC: O(1) We are not using any extra space.
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = matrix[mid / n][mid % n]; // Assuming that o
            if (midElement < target) {
                low = mid + 1;
            } else if (midElement > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        searchA2DMatrix.searchMatrix( new int[][] {
            {1,3,5,7},{10,11,16,20},{23,30,34,60}
        }, 3);
    }
}