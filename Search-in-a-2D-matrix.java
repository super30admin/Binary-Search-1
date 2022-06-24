//time complexcity: O(log(mn))
//space complexcity: O(1)
// Did it run successfully on leetcode: YES

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         if(matrix == null || matrix.length == 0) {
             return false;
         }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int low = 0; //lower bound
        int high = m * n - 1; //upper bound
        
        while(low <= high) {
            int mid = low + (high - low) / 2; //to avoid overflow
            int row = mid / n;
            int col = mid % n;
            
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                low = mid + 1; // target is greater, so search from the next element to mid
            } else {
                high = mid - 1; // target is lesser, so reduce the upperbound by 1
            }
        }
        return false;
    }
}