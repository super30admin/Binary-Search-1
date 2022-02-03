// Time Complexity : O(Log Rows*Col), since we are applying Bin search on linear arr visualization with matrix elements. 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// My Notes : Vizualize like linear array and try to remember base address calculation approach.
public class TwoDMatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Checking if the matrix is not empty
        if (matrix.length > 0) {
            int rows = matrix.length, col = matrix[0].length;
            int total_elems = rows * col;
            int start = 0, end = total_elems - 1;
            System.out.println(" Total elems : "+end +" Rows : "+rows +" Col : "+col);
            // Traditional iterative binary search
            while (start <= end) {
                int mid = start + (end - start) / 2;
                // Convert mid to the 2D array
                int row_idx = mid / col; // Getting row idx value
                int col_idx = mid % col; // Getting col position
                //System.out.println("val :  "+row_idx+","+col_idx +" - MID "+mid);
                int mid_val = matrix[row_idx][col_idx];
                //System.out.println(" MID VALUE : "+mid_val);
                if (target == mid_val) {
                    return true;
                } else if (target < mid_val) {
                    end = mid - 1;
                } else if (target > mid_val) {
                    start = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(" Hey there!!!");
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        TwoDMatrixSearch obj = new TwoDMatrixSearch();
        System.out.println(obj.searchMatrix(matrix, 60));
    }
}
