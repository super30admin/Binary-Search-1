/*time complexity : O(log(mn))
space complexity : O(1)
*/
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, had problems with analyzing and processing 2d array
// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix==null){
            return false;
        }
        int m = matrix.length; // number of rows
        int n = matrix[0].length; // number of  cols or elements in each row
        int low=0, high=m*n-1; //determine the low and high in the matrix by considring the matrix as a 1d array
        
        while(low <= high){
            int mid = low+(high-low)/2; // this formula is used to avoid integer overflow
            // to determine the mid in matrix determine the row and col indices by div by number of cols.
            int row = mid / n;
            int col = mid % n;
            // binary search conditions
            if(matrix[row][col] == target){
                return true;
            }
            if(target < matrix[row][col]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}