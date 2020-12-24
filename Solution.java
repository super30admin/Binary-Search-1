// Time Complexity : log(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l= 0, h = m * n -1;
        int mid =0;
        
        while(l<=h)
        {
            mid = l +(h-l)/2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target)
            {
                return true;
            }
            else if (matrix[row][col] > target){
                 h = mid - 1;
            }
            else
                l = mid + 1;
            }
        return false;
    }
}