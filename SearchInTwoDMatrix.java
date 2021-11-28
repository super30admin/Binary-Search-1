// Brute force TC:O(m*n)
// Find row number and then binary search TC:O(m + log n)
// Binary search on row and then binary search on column TC: O(log m + log n)

// Time Complexity :O(1)
// Space Complexity :O(logmn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
public class SearchInTwoDMatrix {

    public boolean searchMatrix(int[][] matrix, int target) 
    {
        if(matrix == null || matrix[0].length == 0)
            return false;

        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n-1;

        while(low <= high)
        {
            int mid = low + (high-low)/2; // avoid integer overflow
            int r = mid / n;
            int c = mid % n;
            if(matrix[r][c] == target)
                return true;
            
            if(matrix[r][c] < target)
            {
                low = mid+1;
            }
            else
                high = mid-1;
        }

        return false;
    }

    
}
