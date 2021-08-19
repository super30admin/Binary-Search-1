// Search in 2D matrix.

// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : bit difficult to understand the binary search concepts


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[i].length;j++){

                if(matrix[i][j] == target){
                    return true;
                }
            }
        }

        return false;

    }
}