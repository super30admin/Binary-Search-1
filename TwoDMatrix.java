/*

Time Complexity: logmn
Space Complexity: O(1)

 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        //null check
        if(matrix == null || matrix.length == 0) return false;

        int n = matrix.length; //row
        int m = matrix[0].length; // col

        int low = 0;
        int high = (n*m)-1;

        while(low <= high){
            int mid = low + (high-low)/2;
            int r = mid / m;
            int c = mid % m;
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c]>target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        return false;

    }
}