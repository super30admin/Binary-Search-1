// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //base case to check if the matrix is empty
        if(matrix == null || matrix.length == 0){
            return false;
        }
        
        //from the given contraints
        int m = matrix.length, n = matrix[0].length;
        
        //setting low to be the topleft corner of the matrix
        //setting high to be the bottom right corner of the matrix
        int low = 0, high = (m * n) - 1;
        
        //binary search through the matrix like it is a flattened array
        while(low <= high){
            
            //to avoid overflow we don't use (low + high)/2
            int mid = low + (high - low) / 2; 

            //JVM stores index = row*numCols+cols
            int row = mid / n;
            int column = mid % n;
            
            //base case if the middle is the target
            if(matrix[row][column] == target){
                return true;
            }
            else if(matrix[row][column] > target){
                //go to the left side
                high = mid - 1;
            }
            else{
                //go to the right side
                low = mid + 1;
            }
        }
        return false;
    }
}