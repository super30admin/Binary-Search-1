// Time Complexity : O(log n) since binary search
// Space Complexity : O(1) - no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Initially, I made a mistake in row and col computation from mid

// Approach:
// 1. Consider the 2D matrix as a 1D array
// 2. Do binary search on the array
// 3. Calculate row and col index from the 1D array as
//            int row = idx / cols;
//            int col = idx % cols;

public class SearchMatrix {
    private static boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int len = matrix.length * cols;
        int l=0, h= len -1;

        while(l <= h) {
            int mid = l + (h-l)/2;
            int r = mid / cols;
            int c = mid % cols;

            if(matrix[r][c] == target) {
                return true;
            }
            else if(matrix[r][c] > target) {
                h = mid-1;
            }
            else {
                l = mid+1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(mat, 16));
        System.out.println(searchMatrix(mat, 1));
        System.out.println(searchMatrix(mat, 23));
        System.out.println(searchMatrix(mat, 60));
        System.out.println(searchMatrix(mat, 160));
        System.out.println(searchMatrix(mat, 2));
    }
}
