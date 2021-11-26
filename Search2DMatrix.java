/* Time Complexity : O(log mn) Binary Search where m is the number of rows and n is the number of columns
 Space Complexity : O(1) Constant Space
 Did this code successfully run on Leetcode : Yes 
 Any problem you faced while coding this : No
 Approach trick to find the whats the row and column if we are using the binary search
	mid/columns; this will gives the row
 	mid%columns;  this will gives the column
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length <=0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target){
                return true;
            }
            else if(target < matrix[r][c]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return false;
}
}
