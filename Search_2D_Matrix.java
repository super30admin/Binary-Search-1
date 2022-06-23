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
}
