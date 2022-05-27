/* Time Complexity : O(m*logn) , where m is rows and n is columns
 * Space Complexity : O(n*m) size
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i=0; i<m; i++){
            if(target >= matrix[i][0] && target <= matrix[i][n-1]){
                 int low = 0, high = n-1;
                 while(low <= high){
                     int mid = low+ (high - low)/2;
                     if(matrix[i][mid] == target) return true;
                     else if(matrix[i][mid] > target){
                         high = mid-1;
                     } else{
                         low = mid+1;
                     }
                 }
                 return false;
             }
         } 
        
        return false;
    }
}
