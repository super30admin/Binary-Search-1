// Time Complexity : log (m) + log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only

/*
first we run binary search on first column to identify which row our target might be in.
At the end of first binary search our bottom will have the row number.
If target is not present, then bottom variable might be negative hence need to handle the case
After this point, we apply binary search on the row and try to find the target

 */

class SearchIn2dArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix[0].length;
        int n = matrix.length;

        int top=0;
        int bottom=n-1;
        while(top<=bottom)
        {
            int mid=top + (bottom - top)/2;
            if(matrix[mid][0]==target)
                return true;
            if(matrix[mid][0]>target)
                bottom=mid-1;
            else
                top=mid+1;
        }
        int bucketStart=0;
        int bucketEnd=m-1;
        while(bucketStart<=bucketEnd && bottom>=0)
        {
            int mid=bucketStart + (bucketEnd - bucketStart)/2;
            if(matrix[bottom][mid]==target)
                return true;
            if(matrix[bottom][mid]>target)
                bucketEnd=mid-1;
            else
                bucketStart=mid+1;
        }
        return false;
    }
}
