// Time Complexity : O(log(m*n)) Binary search applied for searching the index in 2d matrix
// Space Complexity : O(1) no extra space used other than constants
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach in three sentences only

public class SearchMatrixIn2D {

    public boolean searchMatrix(int[][] matrix, int target) {
        //base case
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; //to avoid integer overflow
            int row =  mid / n;
            int col = mid % n;
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 1;
        SearchMatrixIn2D searchMatrixIn2D = new SearchMatrixIn2D();
        boolean result = searchMatrixIn2D.searchMatrix(matrix, target);
        System.out.println(result);
    }

}
