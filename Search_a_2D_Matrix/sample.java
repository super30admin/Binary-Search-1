// Time Complexity :O(log m) + O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * First we will search in column 1 the index of row in which target can lie.
 * For this we will search a value which is equal to target or maximum between all values in column 1 which
 * are less than target.
 * The index of this element in column 1 is the row number of row in which our target can lie.
 * In 2nd step we will search target in row whose number we got in above step.
 * Since each row is sorted and starting element of each row, is higher then last element of previos row,
 * binary search is the only way which will give us ans in log time so we will do both searches using binary search
*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length -1;
        
        int row = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(matrix[mid][0] == target){
                row = mid;
                break;
            }else if(matrix[mid][0] < target){
                if(mid + 1 >= matrix.length || matrix[mid+1][0] > target){
                    row = mid;
                    break;
                }else{
                    low = mid + 1;
                }
            }else if(matrix[mid][0] > target){
                high = mid - 1;
            }
        }
        
        
        if(row == -1)return false;
        
        low = 0;
        high = matrix[row].length - 1;
        
        while(low <= high){
           int mid = low + (high - low) / 2;
            
            if(matrix[row][mid] == target)return true;
            else if(matrix[row][mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return false;
        
    }
}