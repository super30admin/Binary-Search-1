//Amazon interview Question
//Time complexity =O(logm*n)
//Space complexity = O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //check if matrix is null return false
        if(matrix == null || matrix.length ==0) return false;
        //Check if matrix is not null return true
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while(low<=high){
            int mid = low+(high-low)/2;//To avoid integer overflow
            int row = mid/n;
            int column = mid%n;
            //check if target value = m*n integer matrix value
            if(matrix[row][column]==target){
                return true;
                
            } else{
                //check if target value < m*n integer matrix value
                //if(target<matrix[row][column]){
                if(matrix[row][column]>target){
                    high=mid-1;
                }else{
                    low = mid+1;
                }
            }
            
        } 
        
        return false;
    }
}