// Time Complexity :
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Problem1 {

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 16;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        // System.out.println("Col" + colLen);
        // System.out.println("Row" + rowLen);

        for (int i = 0; i < rowLen; i++) {
            if (target <= matrix[i][colLen - 1]) {
                // System.out.print(matrix[i][colLen - 1]);
                int start = 0;
                int end = colLen - 1;
                while (start <= end) {
                    int mid = start + ((end - start) / 2);
                    // System.out.print("MID" + mid);
                    if (target == matrix[i][mid]) {
                        return true;
                    } else if (target < matrix[i][mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}