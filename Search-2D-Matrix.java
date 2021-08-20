// Time Complexity:  O(log(mn)) - since it's a standard binary search.
// Space Complexity: O(1)
// Did this code run successfully on leetcode: Yes
// Did u face any difficulty while solvign this problem: No

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //if matrix null or  0 
        if(matrix == null || matrix.length ==0)
            return false;
        // row and column
        int m = matrix.length;
        int n = matrix[0].length;
        // initialise low and high
        int low = 0;
        int high = m * n -1;
        while(low <= high) { 
            // if low is less or equal to high then find the value of the row and column to locate the                position of that element in the matrix and compare it with the target
            int mid = low + (high-low)/2; // To prevent integer overflow
            int r = mid/n;
            int c = mid % n;
            if (matrix[r][c] == target) //if the element at that pos = target
                return true;
            else if (matrix[r][c] > target) {
                high = mid -1;
            } 
            else {
                low = mid + 1;
            }
        }
       return false;
        
    }
}