// Time Complexity :
//--O(1)
// Space Complexity :
//--O(1)
// Did this code successfully run on Leetcode :
//--yes
// Any problem you faced while coding this :
//--no problems


// Your code here along with comments explaining your approach in three sentences only
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //check if matrix is null or does have 0 length
        if(matrix == null || matrix.length == 0){
        return false;   
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        
        //Check if low pointer is less than high pointer
        while(low <= high) {
            int mid = low + (high-low)/2; //Prevent Integer Overload
            //row can be calculated by dividing n number of colums
            int row = mid/n;
            //column can be calculated by using % of n number of columns
            int col = mid%n;
            //if matrix ro col matches target
            if(matrix[row][col] == target) {
                return true;                           

            }
            //check if target > matrix[row][col]
            else if(target>matrix[row][col]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
            
        }
        return false;

}
}