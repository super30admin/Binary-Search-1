//Search a target in a 2D matrix.

/*
Time complexity: log(m*n) where m is the number of rows and n is the number of columns in the matrix.
space complexity: O(1)
 */

//Ran successfully in leetcode and local IDE. No challenges faced so far.

class BinarySearch2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; //number of rows
        int n = matrix[0].length; //number of columns
        int low = 0;
        int high = m*n - 1; //total number of elements in the matrix

        while(low <= high){
            int mid = low + (high - low)/2;
            int row = mid / n;
            int col = mid % n;
            
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target){
                low = mid + 1;
            } else{
                high = mid - 1;
            }
        }
        return false;
    }
}
