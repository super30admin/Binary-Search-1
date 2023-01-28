// Problem 74

// in 2d matrices, if it is sorted you can treat it as single array
// where row = index/no of columns and col = index%no of columns
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int low = 0;
        int high = rows*columns - 1;
        while(low<=high){
            int mid = low +(high-low)/2;
            int r = mid/columns;
            int c = mid%columns;
            if(matrix[r][c] == target){
                return true;
            }
            else if(matrix[r][c]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}