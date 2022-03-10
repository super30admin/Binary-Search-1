// Time Complexity : O(logn) (where n = size of matrix)
// Space Complexity : O(n) (size of array)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :N/A
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int low=0, high = m*n-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int r = mid/n;
            int c = mid%n;
            if(target==matrix[r][c])
                return true;
            else if(target < matrix[r][c])
                 high = mid-1;
            else
                 low = mid+1;
        }
        return false;
    }
}