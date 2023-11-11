// Time Complexity : O(log(m*n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only

/* flatten array row wise and implement binary search for the
flattened array. Calculate row and column by using the array index to
 get the value from the 2d array for comparison */

class Problem1 {
    public static boolean searchMatrix(int[][] matrix, int target) {

        int low = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int high = m*n-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int row = mid/n;
            int column = mid%n;
            if(matrix[row][column] == target)
                return true;
            else if(target < matrix[row][column]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return false;
    }

    public static void main(String[] agrs){
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println("Target present is "+searchMatrix(matrix, target));
    }
}
