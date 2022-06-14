class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // null case
        if(matrix == null || matrix.length == 0){
            return false;
        }
        // initialize low and high pointer
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m*n - 1;
        // search the element in imaginary matrix array
        while(low <= high){
            int mid = low + (high-low)/2;
            int r = mid/ n;
            int c = mid% n;
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] > target){
               
                high = mid-1;
                
            } else{
               low = mid+1; 
            }
        }
        return false;
    }
}
//time complexity: O(log(mn))
//Space Complexity: O(1) 
// Did this code successfully run on Leetcode : Yes