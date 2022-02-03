// Time Complexity : O(m+n) where m is the number of colums n is number of rows in the matrix 
// Space Complexity : (mn) to store matrix. O(1) for the implemention that is search
// Did this code successfully run on Leetcode : YEs
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//check the whether the first elements of rows are greater than target or not.
//If we find, we would search near rows for the element depending on the value
//return true if found and false if not found.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = matrix.length;
        int w = matrix[0].length;
        int i = 0;
        for(i = 0; i < l; i++){
            if(matrix[i][0] == target)
                return true;
            if(matrix[i][0] > target)
                break;
        }
        if(i == 0){
            return false;
        }
        int row = i-1;
        for(int j = 1; j < w; j++){
            if(target == matrix[row][j])
                return true;
        }
        if(matrix[l-1][0] < target)
            for(int j = 1; j < w; j++){
            if(target == matrix[l-1][j])
                return true;
        }
        return false;
    }
}