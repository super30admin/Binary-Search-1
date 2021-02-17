// Thought 1 : Brute Force approach is to just iterate through all the elements in the matrix and return true or false 
// depending on whether we found the element or not. This will take O(m*n) time, m - length of row, n - length of col

// Thought 2 : We can push all the elements in the matrix in to a array, then search for the target element in the array. O(n) time and O(n) space

// Thought 3 : Since the elements in the array is actually sorted, we can do a binary search and find the target. O(logn) time and O(n) space

// Thought 4 : We need not have to copy the elements of the matrix to an array, we can perform binary search on the elements in the matrix itself. Thus saving additional space.

// Time Complexity : O(log mn) where m - length of rows, n - length of cols
// Space Complexity : O(1)

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;

        if (row == 0)
            return false;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1])
            return false;

        int left = 0, right = row * col - 1;
        int midIndex, midElem;

        while (left <= right) {
            midIndex = left + (right - left) / 2;
            midElem = matrix[midIndex / col][midIndex % col];
            if (target == midElem)
                return true;
            else if (target < midElem)
                right = midIndex - 1;
            else
                left = midIndex + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix1 = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target1 = 30;

        if (Search2DMatrix.searchMatrix(matrix1, target1)) {
            System.out.println(target1 + " found in the matrix");
        } else {
            System.out.println(target1 + " not found in the matrix");
        }

        int[][] matrix2 = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target2 = 24;


        if (Search2DMatrix.searchMatrix(matrix2, target2)) {
            System.out.println(target2 + " found in the matrix");
        } else {
            System.out.println(target2 + " not found in the matrix");
        }
    }
}
