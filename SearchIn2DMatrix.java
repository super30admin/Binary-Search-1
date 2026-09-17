// Time Complexity :log (m*n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


/**
Five ways to solve the problem.
1. Brute force: Traverse over all the elements. 
    Time-> o(m*n), Space->o(1)
2. Binary search on each row independently.
     Time-> o(mlogn). space ->o(1)
3. Use binary search to find the exact row that will have given target and then binary search on that row to find exaxt target in the row. 
    Time->o(log m)+log(n). Space ->o(1)
4.Find out which row has target by checking the range for each row. Then do binary search on that row.  
    Time->o(m +logn). Space->o(1)
5. Consider entire matrix as 1D array and apply Binary search.
    Time->log (m*n). Space->o(1)
*/
//Main Idea: consider 2D array as 1D array and apply binary search on it. When we find index on imaginary 1D array convert that to row and column as we know how many columns are there in each row.

class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n-1;

        while(left<=right){
            int mid = left+ (right-left)/2;
            //find r and c for mid;
            int r= mid /n;
            int c= mid%n;
            //if target at mid
            if(matrix[r][c]==target) return true;
            //if target is in  left part
            if(target<matrix[r][c]){
                right = mid -1;
            }else{
                left = mid+1;
            }
        }
        return false;
        
        
    }
}