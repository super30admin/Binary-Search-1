class Solution {
    // Time complexity is O(logmn)
    // Space complexity is O(mn)
    // Solution is submitted with no errors
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int low = 0;
        int high =rowLen*colLen -1;
        while(low <= high) {
            int mid = low + (high -low)/2;
            int row = mid/colLen;
            int column = mid%colLen;
            if (matrix[row][column]==target) return true;
            if (matrix[row][column] > target) {
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return false;
    }
}