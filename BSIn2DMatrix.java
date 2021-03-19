// Time Complexity : O(logm + logn) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
	// in case there's only one column, we've already traversed the rows above
	// figuring out: int row = lo-1; 
/**
    Thought process:
        - find the row : logm 
        - find the col in that row: logn 
        
*/
class BSIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length ==0) return false;
        
        int m = matrix.length-1, n = matrix[0].length-1;
        
        //find row
        int lo = 0, hi = m;
        while(lo<=hi){
            //to avoid integer overflow
            int mid = lo + (hi-lo)/2;
            if(matrix[mid][0]==target) return true;
            else if(matrix[mid][0]<target) lo = mid+1;
            else hi = mid-1;
        }

        //in case there's only one column, we've already traversed the rows above
        if (lo == 0) return false; 
        
        //we'll exit the search when lo>hi
        int row = lo-1; 
        lo =0; hi=n;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(matrix[row][mid]==target) return true;
            else if(matrix[row][mid]<target) lo = mid+1;
            else hi = mid-1;
        }
        
        return false;
    }
}