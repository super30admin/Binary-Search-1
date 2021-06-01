// Time Complexity: Since we use binary search methods here, 
// so the time complexity will be O(logn).
/* --------------------------------------------------------*/
// Space Complexity: the space complexity will be O(1).

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length; // n indicates the number of column
        int low = 0, high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int r = mid / n; 
            int c = mid % n;
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return false;
    }
}