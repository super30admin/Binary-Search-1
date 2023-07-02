// Time Complexity : log(m+n)
// Space Complexity : log(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
//Here we are using binary search approach to find an element in 2D matrix array
public class MatrixArraySearch
{
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target) return true;
            if(matrix[0][0] <= target && matrix[r][c] > target){
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
}