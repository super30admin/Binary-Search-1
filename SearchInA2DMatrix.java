// Time Complexity : O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Approach: We flatten the 2D matrix into a 1D array and then perform binary search
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length==0) return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int low = 0; int high=m*n-1; //last index
        // total no of elements = total no of rows * total no of cols
        
        while(low <= high){
            int mid=low + (high-low)/2; //mid of imaginary flattened array
            int r=mid/n;
            int c= mid%n;
            
            if(matrix[r][c]==target) return true;
            else if(matrix[r][c]>target){
                high=mid-1;
            } else {
                low = mid+1;
            }
            
            
        }
        return false;
        
    }
}