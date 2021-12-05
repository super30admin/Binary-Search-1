// Time Complexity: O (log n)
// Space Complexity : O (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Problem1 {

    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix==null || matrix.length==0) return false;
        
        int rows=matrix.length;
        int columns=matrix[0].length;
        int low=0;
        int high=rows*columns-1;
        // Convert the 2d array into 1D array format logic
        while(low<=high)
        {
            int mid=(low+high)/2;
            int row_no=mid/columns;
            int col_no=mid%columns;
            int value=matrix[row_no][col_no];
            
            if(value==target)
                return true;
            if(value<target)
                low=mid+1;
            else 
                high=mid-1;
            
        }
    return false;        
        
    }
}