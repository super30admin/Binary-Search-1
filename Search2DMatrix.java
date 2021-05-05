//Time complexity O(2logn)
//Space complexity O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int n = matrix[0].length;

        // binary search
        int left = 0;
        int right = matrix.length  * n - 1;
        int index, element;
        while (left <= right) {
            index = (left + right) / 2;
            element = matrix[index / n][index % n];
            if (target == element)
                return true;
            else {
                if (target < element)
                    right = index - 1;
                else
                    left = index + 1;
            }
        }
        return false;
    }
}
