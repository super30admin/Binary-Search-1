// Time Complexity : log(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        //checking empty matrix
        if(matrix==null || matrix.length==0) return false;
        //assigning row and column size
        int m = matrix.length, n = matrix[0].length;
        //initializing low and high in the flattened 2D-Matrix
        int low = 0, high = (m*n)-1;
        //while search space is valid
        while(low<=high){
            //calculating mid in the flattened 2D-Matrix
            int mid = low+(high-low)/2;
            //finding row and col position in 2D matrix
            int row = mid/n;
            int col = mid%n;
            //if target found
            if(matrix[row][col]==target) return true;
            //if target on the left sub-array of our flattened 2D-Array
            else if(matrix[row][col]>target){
                high = mid-1;
            }// target on the right sub-array of our flattened 2D-Array
            else{
                low = mid+1;
            }
        }
        //if target not found
        return false;
    }
}