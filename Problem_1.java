// Time Complexity : O(log(m*n)) or O(log(m) + log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english
// Fist find the middle index and then the row and column index for the middle index, and compare with the target value if it is same then return true else compare with other half by the same process
// Your code here along with comments explaining your approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix.length == 0) return false;
        int m = matrix.length; int n = matrix[0].length; // get m and n
        int low = 0; int high = m * n - 1;  // get both low and high value
        while( low <= high){
            int mid = low + ( high - low ) / 2;
            int r = mid / n; int c = mid % n; // get r and c of mid
            if( matrix[r][c] == target){
                return true;   // return true
            }else if( matrix[r][c] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }// return false
        return false;
    }

}