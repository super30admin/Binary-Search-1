// Time Complexity : O(log(m*n))
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class SearchIn2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        while (i < matrix.length) {
            if (target > matrix[i][matrix[i].length - 1]) {
                i++;
            } else if (target <= matrix[i][matrix[i].length - 1]) {
                int start = 0;
                int end = matrix[i].length - 1;
                int mid;

                while (start <= end) {
                    mid = start + (end - start) / 2;
                    if (matrix[i][mid] == target)
                        return true;
                    else if (target > matrix[i][mid])
                        start = mid + 1;
                    else if (target < matrix[i][mid])
                        end = mid - 1;
                }
                return false;
            }
        }
        return false;
    }
}