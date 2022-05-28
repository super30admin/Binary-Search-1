// Time Complexity : O(logm + log n) where m and n are no of rows and columns
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     int high = matrix.length-1;
     int low =0;
     int rowsize = matrix[0].length;   
     while(low<=high)
     {
       int  mid = low+ (high-low)/2;
         if( matrix[mid][0]<=target && matrix[mid][rowsize-1]>=target)
             return binarySearch(target, matrix[mid]);
         if(matrix[mid][rowsize-1]<target)
             low=mid+1;
         else
             high=mid-1;
     }
        return false;
        
    }
    private boolean binarySearch(int target, int[]arr)
    {
        int low=0, high= arr.length-1;
        while(low<=high)
        {
            int mid= low + (high-low)/2;
            if(arr[mid]==target)
                return true;
            if(arr[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return false;
    }
}