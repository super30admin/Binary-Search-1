// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Sorted2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int r = 0;
        int c = matrix[0].length-1;
        
        while(r < matrix.length && c >= 0){
            int curr = matrix[r][c];
            
            if(curr == target) return true;
            
            if(curr > target){
                c--;
            }
            else{
                r++;
            }
        }
        return false;
    }
}
