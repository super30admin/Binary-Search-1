// Time Complexity : O(log (mn)) where m is the number of rows and n is the number of columns in the given 2D matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class TwoDimMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        //null check
        if(matrix == null || matrix.length == 0)
            return false;

        int m = matrix.length; //row
        int n = matrix[0].length; //column

        int low = 0;
        int high = m*n -1;

        while(low <= high){

            int mid = low + (high-low)/2;

            int r= mid / n;
            int c= mid % n;

            if(matrix[r][c] == target)
                return true;

            else if(matrix[r][c] > target)
                high = mid -1;

            else low = mid+1;
        }
        return false;
    }
}