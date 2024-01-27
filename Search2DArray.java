// time complexity - O(log(m*n)), space complexity - O(N)
//The matrix is treated as a sorted 1D array by using a binary search approach.
//The binary search is performed on the mid-value of the 1D array, and the mid-value is converted back to matrix coordinates to compare with the target.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row*col -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int midVal = matrix[mid/col][mid%col];
            if(midVal == target){
                return true;
            }
            else if(midVal<= target) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}