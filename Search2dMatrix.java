// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// treat matrix as array. index/n will give row and index%n will give column


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        int l = 0;
        int r = m*n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int i = mid/n;
            int j = mid%n;
            if(target == matrix[i][j]) return true;
            if(target > matrix[i][j]) l = mid+1;
            else r = mid -1;
        }
        return false;
    }
    
}