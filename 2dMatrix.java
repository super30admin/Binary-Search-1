// Time Complexity : O(2.logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m=matrix.length;
        int n=matrix[0].length;
        //Binary search to find the row
        int low=0;
        int high=m-1;
        int mid1=low+(high-low)/2;
        while(low<=high){
            mid1=low+(high-low)/2;
            if(matrix[mid1][0]<=target && matrix[mid1][n-1]>=target)
                break;
            if(matrix[mid1][0]<target)
                low=mid1+1;
            else
                high=mid1-1;
        }
       //Binary search to find the column in the above found row
        low=0;
        high=n-1;
        int mid2;
        while(low<=high){
            mid2=low+(high-low)/2;
            if(matrix[mid1][mid2]==target)
                return true;
            if(matrix[mid1][mid2]<target)
                low=mid2+1;
            else
                high=mid2-1;
        }
        return false;
    }
}
