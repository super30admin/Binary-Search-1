// Time Complexity : O(log(mn))
// Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Approach: Since all rows, columns are sorted and the first element of the row is > last element of previous row
//we can think of this 2D array as a 1D array
public class Search2DMatrix {

    /**
     *
     * @param matrix given a 2-D matrix of size m * n
     * @param target the target to find
     * @return       true if target exists in the matrix, false otherwise
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0, high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) high = mid - 1;
            else low = mid + 1;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        final Search2DMatrix search2DMatrix = new Search2DMatrix();
        System.out.println(search2DMatrix.searchMatrix(matrix, 23)); //true
        System.out.println(search2DMatrix.searchMatrix(matrix, 41)); //false

        System.out.println(search2DMatrix.searchMatrix(new int[][] {{1, 1}, {2, 2}}, 2)); //true
        System.out.println(search2DMatrix.searchMatrix(new int[][] {{1}}, 3)); //false
    }
}
