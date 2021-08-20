// Time Complexity : log(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0, end = rows*cols - 1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            int r = mid /cols;      //get the row no.
            int c = mid % cols;     //get the col no.
            
            //binary search logic
            if(matrix[r][c] == target){
                return true;
            } else {
                if (matrix[r][c] > target){
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            }
        }
        
        //no found case
        return false;
    }
}



