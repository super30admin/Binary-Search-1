class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // null check
        if(matrix == null || matrix.length == 0) return false;
        int n = matrix.length; // no of rows
        int m = matrix[0].length; // no of columns
        //System.out.println("Length = "+ n);
        int low = 0;
        int high = (m*n)-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int row = mid / m;
            int column = mid % m;
            if(matrix[row][column] == target) return true;
            else if(matrix[row][column] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}