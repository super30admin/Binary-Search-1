// Time Complexity : O(log(mxn)) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : i found it little bit hard.


class Search2DMatrixClass {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int m = matrix.length;
        int n= matrix[0].length;
        int left = 0;
        int right = m*n-1;

        while(left <= right){
            int mid = left + (right - left)/2;
            int midValue = matrix[mid/n][mid%n];
            if(midValue == target){
                return true;
            }
            else if(midValue < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }

 public static void main(String[] args) {

         Search2DMatrixClass obj = new  Search2DMatrixClass();

        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        int target = 3;

        System.out.println(obj.searchMatrix(matrix, target));
    }
}
