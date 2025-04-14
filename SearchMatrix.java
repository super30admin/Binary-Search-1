class SearchMatrix {
    //Time complexity o(logn)
    //Space complexity - o(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int low = 0;
        int high = (rows*columns)-1;
        
        
        
        while(low<=high){
            int midElement = (low+high)/2;
            int matrixMid = matrix[midElement/columns][midElement%columns];
            if(target==matrixMid){
               return true;
            } else if(target<matrixMid){
                high = midElement - 1;
            } else if(target>matrixMid){
                low = midElement + 1;
            }
        }
        
        return false;
    }
}