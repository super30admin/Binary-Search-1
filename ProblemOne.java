//Ran on leetcode: Yes
//TC: O(log n*m) where n is number of rows and m is the number of cols
//SC: O(1)
//Imagine the 2D matrix as a 1D array and then apply binary search on it
class ProblemOne {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int low = 0;
        int high = (rowLen * colLen) - 1;

        //Binary search on the imaginary 1D array
        while(low <= high){
            int mid = low + (high - low) / 2;
            // Convert to the row and col index of the matrix to compare
            int row = mid / colLen;
            int col = mid % colLen;
            if(matrix[row][col] == target){
                return true;
            }
            if(target < matrix[row][col]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}