public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        // here we can use binary search as the matrix
        // looks like sorted array.
        // Instead constructing an array,
        // we can use -> row = idx // n and col = idx % n to get the matrix value.

        int m = matrix.length, n = matrix[0].length;
        int left = 0,  right = m*n-1;
        while (left <= right) {
            int mid =  (left + right) / 2;
            int element = matrix[mid / n][mid % n];

            if(element == target) {
                return true;
            } else {
                if(target > element)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
