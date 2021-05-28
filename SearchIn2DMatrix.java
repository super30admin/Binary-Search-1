// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : calculating row nd column

class SearchIn2DMatrix{
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;

        int n = matrix[0].length;
        int low = 0;
        int high = m * n-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            if( matrix[mid/n][mid%n] == target)
                return true;

            if(matrix[mid/n][mid%n] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}