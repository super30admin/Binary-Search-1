// Time Complexity : O (log m + log n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
 * I applied binary search first to find the correct row which may contain the element.
 * Once I had the row with me, I used binary search on the row to find the element.
 */

public class Problem1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;

        int rowToFind = searchRowRange(matrix, target);
        if(rowToFind == -1) {
            return false;
        }

        int low = 0;
        int high = n-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(matrix[rowToFind][mid] == target) {
                return true;
            } else if(matrix[rowToFind][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    private int searchRowRange(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(matrix[mid][0] <= target && matrix[mid][matrix[0].length-1] >= target) {
                return mid;
            } else if(matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem1 sol = new Problem1();
        int[][] matrix = {
           {1, 3, 5, 7},
           {10, 11, 16, 20},
           {23, 30, 34, 60}
        };
        int target1 = 3;
        int target2 = 13;

        System.out.println(sol.searchMatrix(matrix, target1)); // Should print true
        System.out.println(sol.searchMatrix(matrix, target2)); // Should print false
    }
}
