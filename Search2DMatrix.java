//Time: O(number of column * log(number of column) + number of rows)
//Space: O(1)
//Leetcode: https://leetcode.com/submissions/detail/616276873/

class Solution {
   public boolean searchMatrix(int[][] matrix, int target) {

        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        for(int i = 0; i < rowLength; i++) {
            if(target <= matrix[i][columnLength -1] && target >= matrix[i][0]){
                return binarySearch(matrix, i, columnLength, target);
            }
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix, int row, int columnLength, int target) {
        int left = 0;
        int right = columnLength - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] == target) {
                return true;
            }
            else if(target < matrix[row][mid]){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return false;
    }
}