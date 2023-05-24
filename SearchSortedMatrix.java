// Time Complexity : O(log(n)+log(m))
    //n and m are the number of rows and columns of the matrix respectively

// Space Complexity : O(1)

// Did this code successfully run on Leetcode :
    //Yes. It beats 100% of all the Java submissions in terms of TC and 98.90% of them in terms of SC.

// Any problem you faced while coding this :
    //No.

// Your code here along with comments explaining your approach in three sentences only
    //We perform two binary searches.
    //First search is to find out which row the target would be present in.
    //Second search is to find if the target is present in the selected row.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0, high = n-1;
        int rowToSearch = -1;
        //Finding the row in which the target would be present
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
        //Searching the selected row
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