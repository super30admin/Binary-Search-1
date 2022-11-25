// Time Complexity : O(log(m) + log(n)) = O(log(mn))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) //If there is no matrix at all(null pointer) or if matrix is declared, but length is zero return false
            return false;
        int m = matrix.length, n = matrix[0].length;  // m will store the number of rows and n will store the number of columns
        int low = 0, high = (m*n) - 1; // We are treating the matrix as a 1-D array, low will point to the first element of the first row and high will point to the last element of the last row
        while(low <= high){ //Iterate as long as low does not become greater than high
            int mid = low + (high - low) / 2; //Calculated this way to avoid integer overflow
            int row = mid / n; //Every row has n elements, hence we divide by n
            int col = mid % n; //Every row has 0 to n elements, hence we use modulo to get the correct column
            if(matrix[row][col] == target) //If the element at mid position is the target
                return true;
            else if(matrix[row][col] > target) //If target is less than the mid element
                high = mid - 1; //Shift high to the left of mid
            else
                low = mid + 1; //Shift low to the right of mid if the target is greater than mid
        }
        return false; //Target not found
    }
}