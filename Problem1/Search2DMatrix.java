package Problem1;
// Time Complexity : O(log(m * n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class Search2DMatrix {

    static boolean searchMatrix (int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m*n - 1;

        while(low <= high) {
            int mid = (high - low) / 2 + low;

            if(matrix[mid / n][mid % n] ==  target) return true;

            if(target < matrix[mid / n][mid % n]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 60}};
        int target = 3;

        if(searchMatrix(matrix, target)) {
            System.out.println(target + " is present int the matrix");
        } else {
            System.out.println(target + " is not present in the matrix");
        }
    }
}
