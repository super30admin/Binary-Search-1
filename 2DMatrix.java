// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //check null
        if(matrix == null || matrix.length==0)
            return false;

        //number of rows and columns
        int n = matrix.length;
        int m = matrix[0].length;

        int low=0;
        int high=m*n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            //index of mid element
            int rowIndex = mid/m;
            int colIndex = mid%m;

            //check if mid is the target
            if(matrix[rowIndex][colIndex] == target)
                return true;
            else if(matrix[rowIndex][colIndex] > target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}