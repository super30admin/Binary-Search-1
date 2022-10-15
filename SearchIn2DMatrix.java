package S30_Codes.Binary_Search_1;

// Time Complexity : O(log m*n)
// Space Complexity : O(1)
// Binary-Search-1

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = rows*cols-1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            int idx1 = mid/cols;
            int idx2 = mid % cols;

            if( target == matrix[idx1][idx2] )
                return true;

            if(target < matrix[idx1][idx2])
                end = mid-1;
            else
                start = mid+1;
        }
        return false;
    }
}