// Time Complexity :O(log (mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0;
        int high=m*n-1;
        
        while(low<=high){
            int mid = low + (high - low) / 2; //to prevent integer flow
            int row = mid/n;
            int column=mid%n;
            if(matrix[row][column] == target){
                return true;
            }
            else if(target < matrix[row][column]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }
}