package prog_74_searchIn2DArray;
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length ; //no of rows
        int n = matrix[0].length ; // no of columns
        int low = 0;
        int high = m * n - 1;
        while(low<= high){
            int mid = low + (high - low) / 2 ;
            int r = mid / n ;
            int c = mid % n;
            if(matrix[r][c] == target)
                return true ;
            else{
                if(matrix[r][c]>target){
                    high = mid - 1;
                }
                else{
                    low = mid + 1 ;
                }
            }
        }
        return false ;
    }
}
