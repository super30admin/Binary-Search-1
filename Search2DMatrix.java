    //Time Complexcity: O(log(m*n)) where m=num of rows and n=num of columns
    //Space Complexcity:O(1)
    // Did this code successfully run on Leetcode : yes
    // Any problem you faced while coding this : no

class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        //if no elements exist
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) return false;

        int totalRows = matrix.length;
        int totalCols = matrix[0].length;

        //num of elements
        int totalElements = totalRows*totalCols;
        //initializing low and high
        int low = 0;
        int high = totalElements-1;

        //look for target using binary search throughout the matrix
        while(low<=high){
            
            //calculating mid
            int mid = low + (high-low)/2;

            //finding row and col index for the mid element
            int rowIndexOfMid = mid/totalCols;
            int colIndexOfMid = mid%totalCols;
           
            //target found
            if(target==matrix[rowIndexOfMid][colIndexOfMid]){
                return true;
            }
            //target greater than mid, update low
            else if(target>matrix[rowIndexOfMid][colIndexOfMid]){
                low = mid+1;
            }
            //target lesser than mid, update high
            else{
                high = mid-1;
            }
        }
        
        return false;
    }

}