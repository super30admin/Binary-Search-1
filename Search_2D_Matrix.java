/*
* Time Complexity : O(M)+O(logN)
* Space Complexity: O (1)
* */
public class Search_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int low = 0 , high = matrix[0].length - 1;
            if(matrix[i][low] <= target && target <= matrix[i][high]){
                while(low <= high){
                    int mid = low + (high-low)/2;
                    if(matrix[i][mid] == target){
                        return true;
                    } else if(target > matrix[i][mid]){
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}//-----------------------------------------------------------------------

/* Optimized Code
*  Time Complexity:  O(log m + n )
*  Space Complexity: O(1)
*  */

public class Search_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Checking base condition
        if(matrix == null || matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;

        while(low <= high){
            int middle = low + (high-low)/2;
            int row = middle / n;
            int col = middle % n;

            if(matrix[row][col] == target){
                return true;
            } else if(target < matrix[row][col]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return false;
    }
}