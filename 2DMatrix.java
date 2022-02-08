//time complexity: O(log mn)//linear search on array of size m*n
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        //treating matrix as one linear 2D array
        //get left and right most indices
        int l = 0, r =(m*n)-1;
        
        while(l <= r){
            int mid = l + (r-l)/2;
            
            int i = mid/n; //get row index
            int j = mid%n; //get col index
            
            
            //apply generic binary search
            if (matrix[i][j] == target) {
                return true;
            } else if ( target > matrix[i][j]) {
                //if target is greater than item, then search right array
                l = mid+1;
            } else {
                //else search left array
                r = mid-1;
            }
        }
        return false;
    }

}