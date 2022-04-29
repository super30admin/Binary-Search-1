//Time complexity: O(log (rc))
//Space complexity: O(1)
//Leetcode : yes.
//Problem: No, had to debug the edge condition couple of times.
public class Search2DMatrix {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            if (row == 0) {
                return false;
            }
            int col = matrix[0].length;

            int left = 0;
            int right = (row * col) - 1;
            int r,c, middle;

            while (left <= right) {

                 middle = left + (right - left) / 2; //take care of overflow
                //calculate the row and column using middle
                //you can find this condition by observation of the matrix.
                 r = middle / col;
                 c = middle % col;

                if (matrix[r][c] == target) {
                    return true;
                } else if (matrix[r][c] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            return false;
        }
}
