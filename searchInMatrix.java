class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    //treat matrix like an array 
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    return false;
}

       
        int numberofrows = matrix.length;
        int noOfCols = matrix[0].length;

         int low = 0;
        int high = numberofrows * noOfCols-1;

        while(low <= high) {

            int mid = low + (high-low)/2;

            int r = mid / noOfCols;
            int c = mid % noOfCols;

            if(target == matrix[r][c]) {
                return true;
            
            } 

            if(target > matrix[r][c]){
                low = mid + 1;

            }
            else{
            high = mid - 1;
            }
        }
        return false;

    }

