// Time Complexity : O(log(nm))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int low = 0;
        
        // set high to no of elements
        int high = n*m-1;
            
        while(low <= high) {
            
            int mid = low + (high-low)/2;
            
            // find column and row index
            int i = mid / m;
            int j = mid % m;
            
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            
        }
        return false;
    }
}
