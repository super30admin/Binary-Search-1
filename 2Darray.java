// Time Complexity :O(log N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : yes , did not knew the formula to calculate the index of array


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0 , mid ;
        int midelement ;
        int high = m*n - 1;
        if(m == 0) return false;
        while(low <= high)
        {
            mid = (low+high)/2;
            midelement = matrix[mid / n][mid % n];
            if(target == midelement) 
                return true;
            else 
            {
                if(target < midelement) 
                high = mid - 1;
            else 
                low = mid+1;
            }
            
        }
        return false;
    }
}