//time complexity: o(logmn)
// space complexity: o(1)


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix ==null || matrix.length == 0) return false;

        // row length
        int m = matrix.length;
        // column length
        int n = matrix[0].length;

        //lower bound, higher bound
        int low = 0;
        int high = m*n - 1;

        while(low <= high){
            // to avoid integer overflow
            int mid = low + (high - low)/2;

            int row = mid / n;
            int column = mid % n;

            if(matrix[row][column] == target){
                return true;
            }
            else if(target < matrix[row][column]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}