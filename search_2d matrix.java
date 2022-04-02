// this is a binary search approach; there is a there pointer approach also
// Time Complexity : O(log(m*n)) because we applying binary search to matrix of length m * n
// Space Complexity : O(1) cuz everything is inplace
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {  
       //base case
       if(matrix == null || matrix.length == 0) {
           return false;
       } 
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0;
        int high = m * n - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2; // (not low+high)/2 to prevent integer overflow error  
            int row = mid / n; // we are assuming that the matrix is flattened in to a array of elements and since
            // every row has elements sorted in increasing order we can see that for every row elements increase with increasing column number
            // / rowlength gives us the row while %rowlength gives us the column position
            int column = mid % n;
            if(matrix[row][column] == target) {
                return true;
            }
            else if(matrix[row][column] > target ) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;        
    }
}