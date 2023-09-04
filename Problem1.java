//Search in 2D Array
public class Problem1 {
    public boolean searchMatrix(int[][] matrix, int target) {

        //writing base case
        if(matrix == null || matrix.length == 0){
            return false;
        }

        //define low and high
        int low = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int high = n * m - 1;

        while(low <= high){
            int mid = low + (high-low)/2; //avoid integer overflow
            int row = mid/n;
            int col = mid%n;
            if(matrix[row][col] == target){
                return true;
            }else if(target < matrix[row][col]){
                high = mid - 1;
            }else{
                low = mid  + 1;
            }

        }

        return false;
    }
}
