class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n -1;

        while(low <= high ) {
            int mid = low + (high-low)/2;
            int row = mid /n;
            int colum = mid %n;
            if(target == matrix[row][colum]) {
                return true;
            } else if (target < matrix[row][colum]) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return false;

    }
}