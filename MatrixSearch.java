// Time Complexity : O(log n + log m), n for searching the row and m for searching the column.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Confusion in searching the corresponding row and column in 2d array from hypothetical 1D array


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length; //row
        int m = matrix[0].length; //column
        int low = 0;
        int high = n*m-1;
        // we will think of 2d array as a hypothetical 1D array and apply binary search.
        while(low <= high){
            int mid = low + (high-low)/2;
            //System.out.println(mid);

            int r = mid/m; // will provide the row in the 2d matrix
            int c = mid%m; //will provide the column in the 2d matrix

            if(matrix[r][c] == target){
                return true;
            }
            else if(target > matrix[r][c]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return false;
    }
}