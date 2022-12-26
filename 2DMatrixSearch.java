// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

// Here we are flattening the 2D matrix into a 1D array and then performing binary search
// We do not use additional space we only need to take care of the mapping of the indexes between the matrix and array


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low =0; int high = m*n -1; int mid=0;

        while(low<=high){
            mid = low + (high-low)/2;
            int r = mid/n; //map index to row no
            int c = mid%n; //map index to column no
            if(matrix[r][c]==target)
                return true;
            else if(matrix[r][c]>target)
                high = mid-1;
            else
                low = mid+1;
        }
        
        return false;
    }
}