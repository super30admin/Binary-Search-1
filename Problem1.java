// Time Complexity :O(log(m*n))
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :On local faced issue with getting setup done and running first code 


// Your code here along with comments explaining your approach in three sentences only
//for searching target element in 2D array we have approached using Binary search
//inorder to move with approach mid is calculated ,with help of mid we had calculated the position of number 
//on getting row and col we check for target

import java.util.Scanner;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter Columns: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Target: ");
        int target = scanner.nextInt();

        Solution solution = new Solution();
        boolean result = solution.searchMatrix(matrix, target);

        System.out.println(result);

        scanner.close();
    }
}
