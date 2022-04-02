class SearchIn2DMatrix
{

    // Time Complexity : 0(log N) where N= m*n
    // Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I found out the no. of rows and columns in the given 2-D
    //matrix and stored in m and n because in the later stage of the program, while applying binary search, I will need to
    // point out the exact spot in the 2-D matrix where my middle element lies. After that, I applied binary search
    //to the array and eliminating half array at each stage got the output if target value exists or not.

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n -1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            int row = mid / n;
            int column = mid % n;
            if(matrix[row][column] == target){
                return true;
            }
            else if(matrix[row][column] < target){
                low = mid +1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}