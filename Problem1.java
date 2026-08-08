

// Time Complexity : o(log(mxn) )
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Intially thought of running on  m + log n and struggled implementing and then changed it to o(logmxn)

// Your code here along with comments explaining your approach in three sentences only

// assuming matrix asa as flattened array , do a binary search normally

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    //treat matrix like an array 
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    return false;
}

       
        int numberofrows = matrix.length;
        int noOfCols = matrix[0].length;

         int low = 0;
        int high = numberofrows * noOfCols-1;

        while(low <= high) {

            int mid = low + (high-low)/2;

            int r = mid / noOfCols;
            int c = mid % noOfCols;

            if(target == matrix[r][c]) {
                return true;
            
            } 

            if(target > matrix[r][c]){
                low = mid + 1;

            }
            else{
            high = mid - 1;
            }
        }
        return false;

    }

