Time Complexity: O(logn)
Space Complexity: O(1)


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length ==0)
            return false;
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int left = 0;
        int right = rows*columns -1;
        
        while (left<=right){
            int midpoint = left + (right-left) / 2 ;
            int midpoint_value = matrix[midpoint/columns][midpoint%columns];
            if(target == midpoint_value){
                return true;
            }
             if(target < midpoint_value){
                right = midpoint-1;
             }
             if(target > midpoint_value){
                left = midpoint+1;
             }
            }
        return false;
        }
         
    }