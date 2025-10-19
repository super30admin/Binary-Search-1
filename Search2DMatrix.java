/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 * Time Complexity: O(log(m) + log(n)) where m is number of rows and n is number of columns
 * Space Complexity: O(1)
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int left = 0;
        int right = matrix.length;

        int row = 0;
        if (matrix.length > 1) {
            while (left < right) { // < for checking the final row
                int mid = left + (right - left) / 2; // find mid
                if (matrix[mid][0] == target) return true; // mid in the first column, lucky
                if (matrix[mid][0] < target && matrix[mid][matrix[mid].length - 1] >= target) { // check whether its in a single row. search space reduced to row
                    row = mid;
                    break;
                }
                if (target < matrix[mid][0]) {
                    right = mid;
                } else left = mid + 1;
            }
            left = 0;
            right = matrix[row].length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (matrix[row][mid] == target) return true;
                if (target <= matrix[row][mid]) {
                    right = mid;
                } else left = mid + 1;
            }
        } else {
            left = 0;
            right = matrix[row].length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (matrix[row][mid] == target) return true;
                if (target <= matrix[row][mid]) {
                    right = mid;
                } else left = mid + 1;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}, {17, 18, 19, 20}};
        boolean b = new Search2DMatrix().searchMatrix(input, 8);
        System.out.println(b);

        b = new Search2DMatrix().searchMatrix(input, 5);
        System.out.println(b);

        b = new Search2DMatrix().searchMatrix(input, 16);
        System.out.println(b);

        b = new Search2DMatrix().searchMatrix(input, 20);
        System.out.println(b);

        b = new Search2DMatrix().searchMatrix(input, 19);
        System.out.println(b);

        b = new Search2DMatrix().searchMatrix(new int[][]{}, 20);
        System.out.println(b);

        b = new Search2DMatrix().searchMatrix(new int[][]{{1, 2}}, 1);
        System.out.println(b);

        b = new Search2DMatrix().searchMatrix(new int[][]{{1}, {3}}, 0);
        System.out.println(b);
    }

}
