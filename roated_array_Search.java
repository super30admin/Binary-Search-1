// Time Complexity : O(log)n
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0;
        int high = matrix.length -1;
        
        while(low <= high){
            
            int mid = low + (high - low)/2;
            int r = mid/n;
            int c = mid%n;
            
            if(matrix[r][c] == target) return true;
            
            if(target > matrix[r][c]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }   
        }
        return false;
    }
}