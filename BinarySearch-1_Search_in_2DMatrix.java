Time Complexity - O(row*column)
Space Complexity - O(1)
import java.util.*;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int row = matrix.length;
        int column = matrix[0].length;
        
        int left = 0;
        int right = row*column - 1;
        
        while(left <= right){
            int midpoint = left + (right-left)/2;
            int midElement = matrix[midpoint/column][midpoint%column];
            if(target==midElement){
                return true;
            }else if(target < midElement){
                right = midpoint-1;
            }else if(target > midElement){
                left = midpoint + 1;
            }
            
        }
        return false;
        
    }
}