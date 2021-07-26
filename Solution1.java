// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low<=high){
            int mid = low + (high-low) / 2 ;
            int r = mid/n;
            int c = mid % n;
            if (matrix[r][c] == target){
                return true;
            } else if (target > matrix[r][c]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}