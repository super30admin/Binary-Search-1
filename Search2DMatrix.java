// Time Complexity : O(log(N)) where N = m*n (no.rows * no. of columns)
// Space Complexity : O(1), No extra data structure used.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
Consider the 2d array as flattened. The search space is from 0 to m*n-1
Next find the element in 2d array- row=mid/n and col=mid%n
Remaining is regular Binary search template.
 */

class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix==null) return false;

        int m=matrix.length;
        int n=matrix[0].length;

        int low=0, high=m*n-1, mid,row, col;
        while(low<=high){
            mid=low+(high-low)/2;
            row= mid/n;
            col=mid % n;

            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return false;
    }
}