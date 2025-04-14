// Time Complexity : O(lgn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l=0;
        int r=m*n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(target==matrix[mid/n][mid%n])
                return true;
            else if(target>matrix[mid/n][mid%n])
                l=mid+1;
            else
                r=mid-1;
        }
        return false;
    }
}
