/*
 * Time Complexity: O(log(m*n))
 * Space Complexity: O(1)
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = rowSearch(matrix, target);
        System.out.println(row);
        if(row == -1)
            return false;
        int low = 0;
        int high = matrix[0].length;
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if (matrix[row][mid] > target){
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
           
           
    public int rowSearch(int[][] matrix, int target){
        int low = 0;
        int cols = matrix[0].length;
        System.out.println("cols: "+ cols);
        int high = matrix.length - 1;
        int mid;
        while(low <= high){
               mid = low + (high - low) / 2;
               System.out.println("mid "+ mid);
               if(matrix[mid][0] <= target && matrix[mid][cols -1] >= target){
                   return mid;
               }
               else if(matrix[mid][0] > target){
                   high = mid - 1;
               }
               else {
                   low = mid + 1;
               }
           }
        return -1;
    }
}