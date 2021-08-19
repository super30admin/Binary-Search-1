// Time Complexity :O(log m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // if there are no rows present return false.
        if(matrix.length == 0) return false;
        // Number of rows in the matrix.
        int rows = matrix.length;
        // Number of columns in the matrix.
        int cols = matrix[0].length;
        
        int low = 0;
        // length of the matrix as of 1d array.
        int high = rows * cols -1;
        int mid;
        // binary search to search the target
        while(low <= high){
            // calculating the mid element in the matrix.
            mid = (low + high) / 2;

            // calculating the position of the element in the matrix.
            // i * cols + j = index in the 1d array.
            // Above formula can me changed and used to calculate the postion in the matrix.
            // [index / cols] = row index and [index % cols] = col index.
            int curr = matrix[mid / cols][mid % cols]; 

            if(curr == target){
                return true;
            }
            // if the target is smaller than the mid element search in the lower half of the matrix.
            if(target < curr){
                high = mid - 1;
            }
            // otherwise search in the upper half.
            else{
                low = mid + 1;
            }
        }
        // if the element is not found return false.
        return false;
    }
}