// Time Complexity : log(mn) where m is the size of the row and n is the size of the column
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int colLength = matrix[0].length;
        int high = (colLength * matrix.length)-1;
        
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            int row = mid/colLength;
            int col = mid%colLength;
            
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return false;
    }
}
