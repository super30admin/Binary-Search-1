
// Time Complexity :O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int m = matrix.length;
        int n = matrix[0].length;
        int high= m*n-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            int r = mid/n;
            int c = mid%n;
            if(matrix[r][c] == target) return true;
            else if (matrix[r][c] <target) {
                low = mid+1;
            }
            else high = mid-1;

        }
        return false;
    }

}
