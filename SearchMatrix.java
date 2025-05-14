/*
Intution: As we know that the matrix is sorted, we need to be smart and search for a point
from where values can increase and decrease in diff directions.
here, I have used left bottom most element as my pivot and I am using binary search to detect the target.

Time Complexity: O(log (m x n))
Space Complexity : O(1)
 */
public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        int i = row - 1, j = 0;
        while(i >= 0 && j < column){
            if(matrix[i][j] == target){
                return true;
            } else if (matrix[i][j] > target){
                i--;
            } else {
                j++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = -3;

        System.out.println(searchMatrix(matrix, target));
    }
}
