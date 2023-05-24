// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = n-1;
        int rowToSearch = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (matrix[mid][0]==target)
            {
                return true;
            }
            else if (matrix[mid][0]<target)
            {
                low = mid+1;
                if ( (mid==n-1) || (matrix[mid+1][0]>target) )
                {
                    rowToSearch = mid;
                    break;
                }
            }
            else
            {
                high = mid-1;
            }
        }   
        if (rowToSearch==-1)
        {
            return false;
        }
        low = 0;
        high = m-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (matrix[rowToSearch][mid]==target)
            {
                return true;
            }
            else if (matrix[rowToSearch][mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return false;
    }
}