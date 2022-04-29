// Time Complexity : O(mn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; //no of rows
        int n = matrix[0].length; //no of columns
        
        int start = 0; //starting point of matrix
        int end = m*n-1; //ending point of matrix
        
        while(start<=end){
            int mid = start + (end-start)/2;  //midpoint in matrix
            int midValue = matrix[mid/n][mid%n]; //midpoint value of matrix
            if(midValue==target){
                return true;
            }else if(midValue<target){
                start = mid+1;;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}