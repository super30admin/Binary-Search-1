
// Time Complexity : O(log n) for reducing search space by half
// Space Complexity :O(1) -> only pointers are used for left, right, mid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Search2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m=matrix.length;  // no.of rows
        int n=matrix[0].length; // no.of columns
        
        int low=0;          // first index
        int high=m*n-1;     // last index in 2d array
        
        while(low<=high){    // edge case
            
            int mid=low+(high-low)/2; // find mid element
            int mid_el=matrix[mid/n][mid%n]; // mid/n gives row el and mid%n gives col el
                      
            if(mid_el==target) // found the search so return true
                return true;
            
            if(mid_el>target){ // ignore right side
                high=mid-1;
            }
            else{                 // ignore left side
                low=mid+1;
            }
            
            
        }
        
        return false;     // executes this line if search was not found
        
    }
}