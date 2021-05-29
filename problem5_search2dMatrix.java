package BinarySearch1;

public class problem5_search2dMatrix {

    /*
        Time Complexity: O(n^2) ----> Since there are two for loops
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int row = 0 ; row < matrix.length ; row++) {
            for(int col = 0 ; col < matrix[0].length ; col++) {
                if(matrix[row][col] == target) return true;
            }
        }
        return false;
    }

    /*
        Time Complexity: O(log n) ----> Binary Search Technique
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix == null) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m*n) - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        /*
        Sample 1:
            Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
            Output: true

        Sample 2:
            Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
            Output: false
         */
    }
}