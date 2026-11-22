// Time Complexity :O(log(mn)) where m and n are number of rows and columns
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class Problem1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int rowElem = mid / cols;
            int colElem = mid % cols;

            if(matrix[rowElem][colElem] == target) {
                return true;
            }
            else if(matrix[rowElem][colElem] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }
}
