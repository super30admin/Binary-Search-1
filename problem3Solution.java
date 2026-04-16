//Time Complexity : O(log m*n)
//Space Complexity : O(1)
//Search a 2D Matrix
public class problem3Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int left = 0;
        int right = (r*c)-1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            int midRow = mid/c;
            int midCol = mid%c;
            if(matrix[midRow][midCol]== target) {
                return true;
            }
            else if(matrix[midRow][midCol]< target) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return false;
    }
}