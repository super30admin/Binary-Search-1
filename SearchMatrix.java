// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We will not convert but treat our 2D array as a 1D array
// low = 0; high = m(cols)*n(rows)-1

class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //null
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m*n - 1;
        while(low <= high){
           int mid = low + ((high - low)/2);
           int r = mid/n;
           int c = mid%n;
           if( matrix[r][c] == target) return true;
           else if(matrix[r][c] > target) high = mid-1;
           else low = mid + 1;
        }
        return false;
    }
}